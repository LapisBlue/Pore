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
import static org.spongepowered.api.event.cause.NamedCause.SOURCE;

import blue.lapis.pore.util.constructor.BiClassConstructor;
import blue.lapis.pore.util.constructor.PoreConstructors;
import blue.lapis.pore.util.constructor.SimpleClassConstructor;

import com.google.common.collect.ImmutableList;
import org.spongepowered.api.event.Event;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.function.Function;
import java.util.function.Predicate;

abstract class EventConstructor<P extends org.bukkit.event.Event & PoreEvent<S>, S extends Event>
        implements Function<S, ImmutableList<P>>, Predicate<S> {

    @SuppressWarnings("unchecked")
    static <P extends org.bukkit.event.Event & PoreEvent<S>, S extends Event> EventConstructor<P, S> create(
            Class<P> pore, Predicate<S> matcher) {
        for (Constructor<?> c : pore.getConstructors()) {
            int len = c.getParameterCount();
            if (len == 0 || len > 2) {
                continue;
            }

            Parameter[] parameters = c.getParameters();
            Class<S> sponge = (Class<S>) parameters[0].getType();
            if (!Event.class.isAssignableFrom(sponge)) {
                continue;
            }

            if (len == 1) {
                return new Simple<>(pore, sponge, matcher);
            } else if (parameters[1].getAnnotation(blue.lapis.pore.event.Source.class) != null) {
                return new Source<>(pore, sponge, matcher, parameters[1].getType());
            }
        }

        throw new IllegalArgumentException("No supported constructor found in " + pore);
    }

    final Class<P> poreEvent;
    final Class<S> spongeEvent;

    private final Predicate<S> matcher;

    private EventConstructor(Class<P> poreEvent, Class<S> spongeEvent, Predicate<S> matcher) {
        this.poreEvent = checkNotNull(poreEvent, "poreEvent");
        this.spongeEvent = checkNotNull(spongeEvent, "spongeEvent");
        this.matcher = matcher;
    }

    Class<P> getPoreEvent() {
        return this.poreEvent;
    }

    Class<S> getSpongeEvent() {
        return this.spongeEvent;
    }

    @Override
    public boolean test(S event) {
        return this.matcher == null || this.matcher.test(event);
    }

    private static final class Simple<P extends org.bukkit.event.Event & PoreEvent<S>, S extends Event>
        extends EventConstructor<P, S> {

        // Lazily loaded
        private SimpleClassConstructor<P, S> constructor;

        private Simple(Class<P> poreEvent, Class<S> spongeEvent, Predicate<S> matcher) {
            super(poreEvent, spongeEvent, matcher);
        }

        @Override
        public ImmutableList<P> apply(S event) {
            if (!test(event)) {
                return ImmutableList.of();
            }

            if (this.constructor == null) {
                this.constructor = PoreConstructors.create(this.poreEvent, this.spongeEvent);
            }

            return ImmutableList.of(this.constructor.apply(event));
        }

    }

    private static final class Source<P extends org.bukkit.event.Event & PoreEvent<S>, S extends Event, T>
            extends EventConstructor<P, S> {

        private final Class<T> source;

        // Lazily loaded
        private BiClassConstructor<P, S, T> constructor;

        private Source(Class<P> poreEvent, Class<S> spongeEvent, Predicate<S> matcher, Class<T> source) {
            super(poreEvent, spongeEvent, matcher);
            this.source = checkNotNull(source, "source");
        }

        @Override
        public ImmutableList<P> apply(S event) {
            T source = event.getCause().get(SOURCE, this.source).orElse(null);
            if (source == null || !test(event)) {
                return ImmutableList.of();
            }

            if (this.constructor == null) {
                this.constructor = PoreConstructors.create(this.poreEvent, this.spongeEvent, this.source);
            }

            return ImmutableList.of(this.constructor.apply(event, source));
        }

    }

}
