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
package blue.lapis.pore.converter.wrapper;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import blue.lapis.pore.Pore;

import com.google.common.base.Function;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

final class CachedWrapperConverter<B> implements Function<Object, B> {

    private final LoadingCache<Object, Object> cache = CacheBuilder.newBuilder()
            .weakKeys()
            .build(new CacheLoader<Object, Object>() {
                @Override
                public Object load(Object handle) {
                    return create(handle);
                }
            });

    private final LoadingCache<Class<?>, Converter<?, ? extends B>> classCache = CacheBuilder.newBuilder()
            .weakKeys()
            .build(new CacheLoader<Class<?>, Converter<?, ? extends B>>() {
                @Override
                public Converter<?, ? extends B> load(Class<?> sponge) {
                    return find(sponge);
                }
            });

    final ImmutableMap<Class<?>, Converter<?, ? extends B>> registry;

    @SuppressWarnings("unchecked")
    protected CachedWrapperConverter(Class<B> base, Map<Class<? extends B>, Class<?>> registrations) {
        Set<Class<? extends B>> registered = Sets.newHashSet();
        Set<Map.Entry<Class<? extends B>, Class<?>>> parents = Sets.newLinkedHashSet();
        Multimap<Class<? extends B>, Map.Entry<Class<? extends B>, Class<?>>> children = LinkedHashMultimap.create();

        for (Map.Entry<Class<? extends B>, Class<?>> entry : registrations.entrySet()) {
            Class<?> parent = entry.getKey().getSuperclass();
            while (parent != base && !registered.contains(parent)) {
                parent = parent.getSuperclass();
            }

            registered.add(entry.getKey());

            if (parent == base) {
                parents.add(entry);
            } else {
                children.put((Class<? extends B>) parent, entry);
            }
        }

        ImmutableMap.Builder<Class<?>, Converter<?, ? extends B>> builder = ImmutableMap.builder();

        for (Map.Entry<Class<? extends B>, Class<?>> entry : parents) {
            builder.put(entry.getValue(), build(children, entry.getValue(), entry.getKey()));
        }

        this.registry = builder.build();
    }

    @SuppressWarnings("unchecked")
    private <S, P extends B> Converter<S, P> build(
            Multimap<Class<? extends B>, Map.Entry<Class<? extends B>, Class<?>>> childrenRegistry,
            Class<S> sponge, Class<P> pore) {

        // Create children converters
        Collection<Map.Entry<Class<? extends B>, Class<?>>> children = childrenRegistry.get(pore);

        ImmutableMap.Builder<Class<? extends S>, Converter<? extends S, ? extends P>> converterRegistry =
                ImmutableMap.builder();

        for (Map.Entry<Class<? extends B>, Class<?>> child : children) {
            Class<? extends S> childSponge = (Class<? extends S>) child.getValue();
            converterRegistry.put(childSponge,
                    build(childrenRegistry, childSponge, (Class<? extends P>) child.getKey()));
        }

        return new Converter<S, P>(sponge, pore, converterRegistry.build());
    }

    @Nullable
    @SuppressWarnings("unchecked")
    public <P extends B> P get(Object handle) {
        if (handle == null) {
            return null;
        }

        return (P) cache.getUnchecked(handle);
    }

    @Nullable
    public <P extends B> P get(Class<P> type, Object handle) {
        return get(handle); // TODO: Optimize first access with type class as entry point
    }

    @Nullable
    @Override
    public B apply(@Nullable Object input) {
        return get(input);
    }

    protected Object create(Object handle) {
        Converter<?, ? extends B> converter = classCache.getUnchecked(handle.getClass());
        return converter.applyUnchecked(handle);
    }

    protected Converter<?, ? extends B> find(Class<?> sponge) {
        // Find a matching class
        for (Map.Entry<Class<?>, Converter<?, ? extends B>> entry : registry.entrySet()) {
            if (entry.getKey().isAssignableFrom(sponge)) {
                return entry.getValue().findUnchecked(sponge);
            }
        }

        throw new UnsupportedOperationException(sponge.toString());
    }

    static final class Converter<S, P> implements Function<S, P> {

        final Constructor<P> constructor;
        final ImmutableMap<Class<? extends S>, Converter<? extends S, ? extends P>> registry;

        private Converter(Class<S> sponge, Class<P> pore,
                ImmutableMap<Class<? extends S>, Converter<? extends S, ? extends P>> registry) {
            checkNotNull(sponge, "sponge");
            checkNotNull(pore, "pore");
            this.registry = checkNotNull(registry, "registry");

            try {
                this.constructor = pore.getDeclaredConstructor(sponge);
                constructor.setAccessible(true);
            } catch (NoSuchMethodException e) {
                throw new IllegalArgumentException("Pore " + pore + " doesn't have any constructor for Sponge " +
                        sponge, e);
            }
        }

        public Converter<? extends S, ? extends P> find(Class<? extends S> sponge) {
            // Find the most specific type
            for (Map.Entry<Class<? extends S>, Converter<? extends S, ? extends P>> entry : registry.entrySet()) {
                if (entry.getKey().isAssignableFrom(sponge)) {
                    return entry.getValue().findUnchecked(sponge);
                }
            }

            return this;
        }

        @SuppressWarnings("unchecked")
        public Converter<? extends S, ? extends P> findUnchecked(Class<?> sponge) {
            return find((Class<? extends S>) sponge);
        }

        @Override
        public P apply(S input) {
            try { // Create the pore wrapper
                return constructor.newInstance(input);
            } catch (Exception e) {
                throw new RuntimeException("Failed to create Pore wrapper for " + input.getClass(), e);
            }
        }

        @SuppressWarnings("unchecked")
        public P applyUnchecked(Object input) {
            return apply((S) input);
        }
    }

    static <B> Builder<B> builder(Class<B> base) {
        return new Builder<B>(base);
    }

    static final class Builder<B> {

        private final Class<B> base;
        private final Set<Class<?>> registered = Sets.newHashSet();
        private final Map<Class<? extends B>, Class<?>> registry = Maps.newLinkedHashMap();

        private Builder(Class<B> base) {
            this.base = checkNotNull(base, "base");
        }

        public <S, P extends B> Builder<B> register(Class<S> sponge, Class<P> pore) {
            checkState(!registered.contains(checkNotNull(pore, "pore")), "Pore %s is already registered", pore);
            checkState(!registered.contains(checkNotNull(sponge, "sponge")), "Sponge %s is already registered", sponge);

            Class<?> parent = pore.getSuperclass();
            while (parent != base) {
                if (parent == Object.class || parent == null) {
                    throw new AssertionError(String.format("Pore %s does not extend the parent class %s", pore, base));
                }
                if (!registered.contains(parent)) {
                    Pore.getTestLogger().warn("Parent class {} for {} ({}) is not registered", parent.getSimpleName(),
                            pore.getSimpleName(), sponge.getSimpleName());
                }

                parent = parent.getSuperclass();
            }

            registered.add(pore);
            registered.add(sponge);
            registry.put(pore, sponge);
            return this;
        }

        public CachedWrapperConverter<B> build() {
            return new CachedWrapperConverter<B>(base, registry);
        }
    }
}
