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
package net.amigocraft.pore.util.converter;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import net.amigocraft.pore.Pore;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.Map;

public class CachedConverter<B> {
    private final Map<Object, Object> cache = new MapMaker().weakKeys().weakValues().makeMap();
    private final Map<Class<? extends B>, Converter<?, ?>> registry;

    @SuppressWarnings("unchecked")
    protected CachedConverter(Class<B> base, Map<Class<? extends B>, Class<?>> registrations) {
        Multimap<Class<? extends B>, Map.Entry<Class<? extends B>, Class<?>>> children = HashMultimap.create();

        for (Map.Entry<Class<? extends B>, Class<?>> entry : registrations.entrySet()) {
            Class<?> parent = entry.getKey().getSuperclass();
            Class<?> spongeParent = null;
            while (parent != null && parent != base && parent != Object.class &&
                    (spongeParent = registrations.get(parent)) == null) {
                Pore.getLogger().warn("Unknown super class: " + parent);
                parent = parent.getSuperclass();
            }

            // We have found a registered parent class of this
            if (spongeParent != null) {
                children.put((Class<? extends B>) parent, entry);
            }
        }

        Map<Class<? extends B>, Converter<?, ?>> registry = Maps.newHashMapWithExpectedSize(registrations
                .size());
        for (Map.Entry<Class<? extends B>, Class<?>> entry : registrations.entrySet()) {
            build(children, registry, entry.getValue(), entry.getKey());
        }

        this.registry = ImmutableMap.copyOf(registry);
    }

    @SuppressWarnings("unchecked")
    private <S, P extends B> Converter<S, P> build(
            Multimap<Class<? extends B>, Map.Entry<Class<? extends B>, Class<?>>> childrenRegistry,
            Map<Class<? extends B>, Converter<?, ?>> registry,
            Class<S> sponge, Class<P> pore) {
        Converter<S, P> converter = (Converter<S, P>) registry.get(pore);
        if (converter != null) {
            return converter;
        }

        // Add children converters
        Collection<Map.Entry<Class<? extends B>, Class<?>>> children = childrenRegistry.get(pore);
        ImmutableMap<Class<? extends S>, Converter<? extends S, ? extends P>> converterRegistry;
        if (children.isEmpty()) {
            converterRegistry = ImmutableMap.of();
        } else {
            Map<Class<? extends S>, Converter<? extends S, ? extends P>> converterBuild =
                    Maps.newHashMapWithExpectedSize(children.size());
            for (Map.Entry<Class<? extends B>, Class<?>> child : children) {
                Class<? extends S> childSponge = (Class<? extends S>) child.getValue();
                converterBuild.put(childSponge,
                        build(childrenRegistry, registry, childSponge, (Class<? extends P>) child.getKey()));
            }

            converterRegistry = ImmutableMap.copyOf(converterBuild);
        }

        // Create converter
        converter = new Converter<S, P>(sponge, pore, converterRegistry);
        registry.put(pore, converter);
        return converter;
    }

    @SuppressWarnings("unchecked")
    public <P extends B> P get(Object handle, Class<P> pore) {
        if (handle == null)
            return null;

        Object cached = cache.get(handle);
        if (cached != null) {
            return (P) cached; // We have this cached already, throw an exception if it's of the wrong type
        }

        // Our entry point is the given Pore class
        Converter<?, P> converter = (Converter<?, P>) registry.get(pore);
        Preconditions.checkState(converter != null, "Unknown Pore class: %s", pore);

        // Convert the Sponge object
        P result = converter.applyUnchecked(handle);
        cache.put(handle, result);
        return result;
    }

    private static class Converter<S, P> implements Function<S, P> {
        private final Class<S> sponge;
        private final Constructor<P> constructor;
        private final ImmutableMap<Class<? extends S>, Converter<? extends S, ? extends P>> registry;

        private Converter(Class<S> sponge, Class<P> pore,
                          ImmutableMap<Class<? extends S>, Converter<? extends S, ? extends P>> registry) {
            this.sponge = sponge;

            try {
                this.constructor = pore.getDeclaredConstructor(sponge);
                constructor.setAccessible(true);
            } catch (NoSuchMethodException e) {
                throw new AssertionError(e);
            }

            this.registry = registry;
        }

        @Override
        @SuppressWarnings("unchecked")
        public P apply(S input) {
            Class<? extends S> sponge = (Class<? extends S>) input.getClass();

            // First, check for an exact check
            Converter<? extends S, ? extends P> converter = registry.get(sponge);
            if (converter != null) { // Let this converter convert it instead
                return converter.applyUnchecked(input);
            }

            // Check for the most specific type
            for (Map.Entry<Class<? extends S>, Converter<? extends S, ? extends P>> entry : registry.entrySet()) {
                if (entry.getKey().isAssignableFrom(sponge)) {
                    // Let this converter convert it instead
                    return entry.getValue().applyUnchecked(input);
                }
            }

            // Create the pore wrapper
            try {
                return constructor.newInstance(input);
            } catch (Exception e) {
                throw new RuntimeException("Failed to create Pore wrapper for " + sponge, e);
            }
        }

        @SuppressWarnings("unchecked")
        public P applyUnchecked(Object input) {
            Preconditions.checkArgument(sponge.isAssignableFrom(input.getClass()), "Unsupported Sponge type: " +
                    "%s", input.getClass());
            return apply((S) input);
        }
    }

    public static <B> Builder<B> builder(Class<B> base) {
        return new Builder<B>(base);
    }

    public static class Builder<B> {
        private final Class<B> base;
        private final BiMap<Class<? extends B>, Class<?>> registry = HashBiMap.create();

        private Builder(Class<B> base) {
            this.base = Preconditions.checkNotNull(base, "base");
        }

        public <S, P extends B> Builder<B> register(Class<S> sponge, Class<P> pore) {
            Preconditions.checkNotNull(pore, "pore");
            Preconditions.checkNotNull(sponge, "sponge");
            Preconditions.checkState(!registry.containsKey(pore), "Pore %s is already registered", pore);
            Preconditions
                    .checkState(!registry.containsValue(sponge), "Sponge %s is already registered", sponge);

            registry.put(pore, sponge);
            return this;
        }

        public CachedConverter<B> build() {
            return new CachedConverter<B>(base, registry);
        }
    }
}
