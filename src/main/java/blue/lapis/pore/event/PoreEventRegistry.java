/*
 * Pore
 * Copyright (c) 2014-2016, Lapis <https://github.com/LapisBlue>
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

import static com.google.common.base.Preconditions.checkNotNull;

import blue.lapis.pore.Pore;

import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableList;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.SimplePluginManager;
import org.spongepowered.api.event.Event;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Modifier;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public final class PoreEventRegistry {

    private PoreEventRegistry() {
    }

    private static final Map<Class<? extends Event>, SpongeEvent<?>> handlers = new IdentityHashMap<>();

    @SuppressWarnings("unchecked")
    private static <S extends Event> SpongeEvent<S> registerSpongeHandler(Class<S> event) {
        SpongeEvent<S> result = (SpongeEvent<S>) handlers.get(event);
        if (result == null) {
            result = new SpongeEvent<>(event);
            handlers.put(event, result);
        }

        return result;
    }

    private static HandlerList getHandlerList(Class<?> pore) {
        Class<?> superClass = pore;
        do {
            superClass = superClass.getSuperclass();
            if (!Modifier.isAbstract(superClass.getModifiers())
                    && superClass.getName().startsWith("org.bukkit.event")) {
                break;
            }
        } while (superClass != null);

        if (superClass == null) {
            throw new IllegalStateException("Not a Bukkit handle event " + pore);
        }

        Class<? extends org.bukkit.event.Event> handle = superClass.asSubclass(org.bukkit.event.Event.class);
        return SimplePluginManager.getEventListeners(handle);
    }

    public static  <P extends org.bukkit.event.Event & PoreEvent<S>, S extends Event> void register(
            Class<P> pore, Class<S> sponge, Function<S, ImmutableList<P>> constructor) {
        checkNotNull(pore, "pore");
        checkNotNull(sponge, "sponge");
        checkNotNull(constructor, "constructor");

        HandlerList handlerList = getHandlerList(pore);
        SpongeEvent<S> spongeEvent = registerSpongeHandler(sponge);
        handlerList.addAdapter(new RegisteredPoreEvent<>(pore, spongeEvent, constructor));
    }

    public static  <P extends org.bukkit.event.Event & PoreEvent<S>, S extends Event> void register(
            Class<P> pore, Predicate<S> matcher) {
        checkNotNull(pore, "pore");

        EventConstructor<P, S> constructor = EventConstructor.create(pore, matcher);
        register(pore, constructor.getSpongeEvent(), constructor);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void register() throws IOException {
        Stopwatch watch = Stopwatch.createStarted();

        InputStream in = PoreEventRegistry.class.getResourceAsStream("events.txt");
        if (in == null) {
            Pore.getLogger().warn("No registered events found, Bukkit events will not be called.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.charAt(0) == '#') {
                    continue;
                }

                String owner = line;
                String method = null;

                int pos = line.lastIndexOf(':');
                if (pos >= 0) {
                    owner = line.substring(0, pos);
                    method = line.substring(pos + 1);
                }

                try {
                    // Pff
                    Class poreEvent = Class.forName(owner);

                    if (method != null) {
                        poreEvent.getMethod(method).invoke(null);
                    } else {
                        register(poreEvent, null);
                    }
                } catch (Exception e) {
                    Pore.getLogger().warn("Failed to register class {} as an event", line, e);
                }
            }
        }

        Pore.getLogger().debug("Registered events in {}", watch.stop());
    }

}
