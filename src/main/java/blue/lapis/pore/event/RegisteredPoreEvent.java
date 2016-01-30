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

import blue.lapis.pore.util.constructor.PoreConstructors;
import blue.lapis.pore.util.constructor.SimpleConstructor;

import com.google.common.collect.ImmutableList;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.spongepowered.api.event.Event;

import java.util.function.Function;
import java.util.function.Predicate;

final class RegisteredPoreEvent<P extends org.bukkit.event.Event & PoreEvent<S>, S extends Event>
        implements HandlerList.Adapter {

    private final Class<P> poreEvent;
    private final SpongeEvent<S> spongeEvent;
    private final Function<S, ImmutableList<P>> constructor;

    RegisteredPoreEvent(Class<P> poreEvent, SpongeEvent<S> spongeEvent, Predicate<S> matcher) {
        this.poreEvent = checkNotNull(poreEvent, "poreEvent");
        this.spongeEvent = checkNotNull(spongeEvent, "spongeEvent");
        this.constructor = new SimpleEventConstructor(matcher);
    }

    RegisteredPoreEvent(Class<P> poreEvent, SpongeEvent<S> spongeEvent, Function<S, ImmutableList<P>> constructor) {
        this.poreEvent = checkNotNull(poreEvent, "poreEvent");
        this.spongeEvent = checkNotNull(spongeEvent, "spongeEvent");
        this.constructor = checkNotNull(constructor, "constructor");
    }

    Class<P> getEvent() {
        return this.poreEvent;
    }

    Class<S> getSpongeEvent() {
        return this.spongeEvent.getEvent();
    }

    ImmutableList<P> construct(S event) {
        return this.constructor.apply(event);
    }

    @Override
    public void register(EventPriority priority) {
        this.spongeEvent.register(this, priority);
    }

    @Override
    public void unregister() {
        this.spongeEvent.unregisterAll(this);
    }

    @Override
    public void unregister(EventPriority priority) {
        this.spongeEvent.unregister(this, priority);
    }

    private final class SimpleEventConstructor implements Function<S, ImmutableList<P>> {

        private final Predicate<S> matcher;

        // Lazily loaded
        private SimpleConstructor<P, S> constructor;

        private SimpleEventConstructor(Predicate<S> matcher) {
            this.matcher = matcher;
        }

        @Override
        public ImmutableList<P> apply(S event) {
            if (this.matcher != null && !this.matcher.test(event)) {
                return ImmutableList.of();
            }

            if (this.constructor == null) {
                this.constructor = PoreConstructors.create(poreEvent, spongeEvent.getEvent());
            }

            return ImmutableList.of(this.constructor.construct(event));
        }

    }

}
