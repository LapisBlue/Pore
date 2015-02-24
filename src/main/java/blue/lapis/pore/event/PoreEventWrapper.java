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
import blue.lapis.pore.impl.event.block.PoreBlockBreakEvent;
import blue.lapis.pore.impl.event.player.PoreAsyncPlayerChatEvent;
import blue.lapis.pore.impl.event.player.PorePlayerJoinEvent;
import blue.lapis.pore.impl.event.player.PorePlayerQuitEvent;
import blue.lapis.pore.impl.event.server.PoreServerListPingEvent;

import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.AuthorNagException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredListener;
import org.bukkit.plugin.SimplePluginManager;
import org.spongepowered.api.service.event.EventManager;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.EnumMap;
import java.util.Map;
import java.util.logging.Level;

public final class PoreEventWrapper {

    public static void register() {
        register(PorePlayerJoinEvent.class);
        register(PorePlayerQuitEvent.class);
        register(PoreAsyncPlayerChatEvent.class);

        register(PoreBlockBreakEvent.class);

        register(PoreServerListPingEvent.class);
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
            } catch (Throwable ex) {
                Pore.getServer().getLogger().log(Level.SEVERE, "Could not pass event " + event.getEventName() + " to "
                        + registration.getPlugin().getDescription().getFullName(), ex);
            }
        }
    }

    public static void register(Class<? extends Event> pore) {
        checkNotNull(pore, "pore");

        Class<? extends org.spongepowered.api.util.event.Event> sponge = null;
        for (Constructor<?> constructor : pore.getConstructors()) {
            Class<?>[] parameters = constructor.getParameterTypes();
            if (parameters.length == 1) {
                Class<?> parameter = parameters[0];
                if (org.spongepowered.api.util.event.Event.class.isAssignableFrom(parameter)) {
                    sponge = parameter.asSubclass(org.spongepowered.api.util.event.Event.class);
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
        list.addAdapter(new Registration(pore, sponge));
    }

    private static class Registration implements HandlerList.Adapter {

        private final Class<? extends Event> pore;
        private final Class<? extends org.spongepowered.api.util.event.Event> sponge;

        private final EnumMap<EventPriority, Object> listeners = Maps.newEnumMap(EventPriority.class);

        public Registration(Class<? extends Event> pore,
                Class<? extends org.spongepowered.api.util.event.Event> sponge) {
            this.pore = pore;
            this.sponge = sponge;
        }

        @Override
        public void register(EventPriority priority) {
            Object listener = listeners.get(priority);
            if (listener == null) {
                listener = PoreListenerGenerator.createListener(pore, sponge, priority);
                listeners.put(priority, listener);
            }

            Pore.getGame().getEventManager().register(Pore.getInstance(), listener);
        }

        @Override
        public void unregister() {
            EventManager manager = Pore.getGame().getEventManager();

            for (Object listener : listeners.values()) {
                manager.unregister(listener);
            }
        }

        @Override
        public void unregister(EventPriority priority) {
            Object listener = listeners.get(priority);
            if (listener != null) {
                Pore.getGame().getEventManager().unregister(listener);
            }
        }
    }

    private static final Map<org.spongepowered.api.util.event.Event, Event> cache = new MapMaker().weakKeys().makeMap();

    @SuppressWarnings("unchecked")
    public static <T extends Event> T get(org.spongepowered.api.util.event.Event handle) {
        return handle != null ? (T) cache.get(handle) : null;
    }

    public static void set(org.spongepowered.api.util.event.Event handle, Event event) {
        cache.put(handle, event);
    }

}
