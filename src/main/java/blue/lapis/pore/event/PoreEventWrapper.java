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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.MapMaker;
import org.spongepowered.api.event.Event;

import java.util.IdentityHashMap;
import java.util.Map;

final class PoreEventWrapper {

    private static final Map<Event, PoreEventWrapper> cache = new MapMaker().makeMap();

    static PoreEventWrapper get(Event event) {
        checkNotNull(event, "event");

        PoreEventWrapper result = cache.get(event);
        if (result == null) {
            result = new PoreEventWrapper();
            cache.put(event, result);
        }

        return result;
    }

    static void remove(Event event) {
        cache.remove(event);
    }

    private final Map<Class<? extends org.bukkit.event.Event>, ImmutableList<? extends org.bukkit.event.Event>>
            instances = new IdentityHashMap<>(3);

    private PoreEventWrapper() {
    }

    @SuppressWarnings("unchecked")
    <P extends org.bukkit.event.Event & PoreEvent<S>, S extends Event> Iterable<P> get(S spongeEvent,
            RegisteredPoreEvent<P, S> event) {
        final Class<P> poreClass = event.getEvent();

        ImmutableList<P> result = (ImmutableList<P>) this.instances.get(poreClass);
        if (result == null) {
            result = event.construct(spongeEvent);
            this.instances.put(poreClass, result);
        }

        return result;
    }

}
