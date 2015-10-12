/*
 * Pore
 * Copyright (c) 2014-2015, Lapis <https://github.com/LapisBlue>
 *
 * The MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package blue.lapis.pore.event;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import blue.lapis.pore.Pore;
import blue.lapis.pore.converter.type.plugin.EventPriorityConverter;
import blue.lapis.pore.util.constructor.PoreConstructors;
import blue.lapis.pore.util.constructor.SimpleConstructor;

import com.google.common.base.Stopwatch;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import org.bukkit.event.Event;
import org.bukkit.event.EventException;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.AuthorNagException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredListener;
import org.bukkit.plugin.SimplePluginManager;
import org.spongepowered.api.service.event.EventManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.EnumMap;
import java.util.Map;
import java.util.logging.Level;

public final class PoreEventWrapper {

    private static final String EVENT_PACKAGE = "blue.lapis.pore.impl.event";

    private PoreEventWrapper() {
    }

    @SuppressWarnings("unchecked")
    public static void register() throws IOException {
        Stopwatch watch = Stopwatch.createStarted();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(PoreEventWrapper.class.getResourceAsStream("events.txt")));

        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty() || line.charAt(0) == '#') {
                continue;
            }

            try {
                register((Class<? extends Event>) Class.forName(line));
            } catch (ClassNotFoundException e) {
                Pore.getLogger().warn("Failed to register class {} as an event", line, e);
            }
        }

        Pore.getLogger().debug("Registered events in {}", watch.stop());
    }

    public static void call(Event event, EventPriority priority) {
        for (RegisteredListener registration : event.getHandlers().getRegisteredListeners(priority)) {
            if (!registration.getPlugin().isEnabled()) {
                continue;
            }

            try {
                registration.callEvent(event);
            } catch (AuthorNagException ex) {
                Plugin plugin = registration.getPlugin();

                if (plugin.isNaggable()) {
                    plugin.setNaggable(false);

                    Pore.getServer().getLogger().log(Level.SEVERE, String.format(
                            "Nag author(s): '%s' of '%s' about the following: %s",
                            plugin.getDescription().getAuthors(),
                            plugin.getDescription().getFullName(),
                            ex.getMessage()
                    ));
                }
            } catch (EventException ex) {
                Pore.getServer().getLogger().log(Level.SEVERE, "Could not pass event " + event.getEventName() + " to "
                        + registration.getPlugin().getDescription().getFullName(), ex);
            }
        }
    }

    public static void register(Class<? extends Event> pore) {
        checkNotNull(pore, "pore");

        Class<? extends org.spongepowered.api.event.Event> sponge = null;
        for (Constructor<?> constructor : pore.getConstructors()) {
            Class<?>[] parameters = constructor.getParameterTypes();
            if (parameters.length == 1) {
                Class<?> parameter = parameters[0];
                if (org.spongepowered.api.event.Event.class.isAssignableFrom(parameter)) {
                    sponge = parameter.asSubclass(org.spongepowered.api.event.Event.class);
                }
            }
        }

        checkArgument(sponge != null, "No event constructor found in %s", pore);

        Class<?> superClass = pore.getSuperclass();
        checkState(
                !Modifier.isAbstract(superClass.getModifiers()) && superClass.getName().startsWith("org.bukkit.event"),
                "Not a Bukkit handle event %s", superClass
        );
        Class<? extends Event> handle = superClass.asSubclass(Event.class);

        HandlerList list = SimplePluginManager.getEventListeners(handle);
        list.addAdapter(create(pore, sponge));
    }

    private static <P extends Event, S extends org.spongepowered.api.event.Event> Registration<P, S> create(
            Class<P> pore, Class<S> sponge) {
        return new Registration<P, S>(pore, sponge);
    }

    private static class Registration<P extends Event,
            S extends org.spongepowered.api.event.Event> implements HandlerList.Adapter {

        private final Class<P> pore;
        private final Class<S> sponge;
        private SimpleConstructor<P, S> constructor;

        private final EnumMap<EventPriority, PoreEventHandler<S>> listeners = Maps.newEnumMap(EventPriority.class);

        public Registration(Class<P> pore, Class<S> sponge) {
            this.pore = pore;
            this.sponge = sponge;
        }

        @Override
        public void register(EventPriority priority) {
            PoreEventHandler<S> listener = listeners.get(priority);
            if (listener == null) {
                if (constructor == null) {
                    this.constructor = PoreConstructors.create(pore, sponge);
                }

                listener = new PoreEventHandler<S>(priority, constructor);
                listeners.put(priority, listener);
            }

            Pore.getGame().getEventManager().registerListener(Pore.getPlugin(), sponge,
                    EventPriorityConverter.of(priority), listener);
        }

        @Override
        public void unregister() {
            EventManager manager = Pore.getGame().getEventManager();

            for (Object listener : listeners.values()) {
                manager.unregisterListeners(listener);
            }
        }

        @Override
        public void unregister(EventPriority priority) {
            Object listener = listeners.get(priority);
            if (listener != null) {
                Pore.getGame().getEventManager().unregisterListeners(listener);
            }
        }
    }

    private static final Map<org.spongepowered.api.event.Event, Event> cache = new MapMaker().weakKeys().makeMap();

    @SuppressWarnings("unchecked")
    public static <T extends Event> T get(org.spongepowered.api.event.Event handle) {
        return handle != null ? (T) cache.get(handle) : null;
    }

    public static void set(org.spongepowered.api.event.Event handle, Event event) {
        cache.put(handle, event);
    }

}
