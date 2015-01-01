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
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapMaker;

import javax.annotation.Nullable;
import java.util.Map;

public abstract class TypeConverter<S, B> implements Function<S, B> {

    private final Map<S, B> instances = new MapMaker().concurrencyLevel(1).weakKeys().weakValues().makeMap();

    private final ImmutableMap<Class<? extends S>, TypeConverter<? extends S, ? extends B>> children;

    @SuppressWarnings("unchecked")
    protected TypeConverter() {
        this.children = (ImmutableMap) ImmutableMap.of();
    }

    // We need some strange workarounds here to make it work on Java 6
    @SuppressWarnings("unchecked")
    protected TypeConverter(Class<? extends S> type, TypeConverter<? extends S, ? extends B> cache) {
        this.children = (ImmutableMap) ImmutableMap.of(type, cache);
    }

    protected TypeConverter(
            ImmutableMap<Class<? extends S>, TypeConverter<? extends S, ? extends B>> children) {
        this.children = children;
    }

    @Nullable
    @Override
    @SuppressWarnings("unchecked")
    public B apply(@Nullable S handle) {
        if (handle == null) return null;

        // Get the class of the sponge object
        Class<? extends S> spongeType = (Class<? extends S>) handle.getClass();

        // Check for the specific implementation first
        TypeConverter<? extends S, ? extends B> child = children.get(spongeType);
        if (child != null) {
            // Use the specific cache directly
            return child.applyUnchecked(handle);
        }

        // We should still check if there is a more accurate implementation
        for (Map.Entry<Class<? extends S>, TypeConverter<? extends S, ? extends B>> entry : children
                .entrySet()) {
            if (entry.getKey().isAssignableFrom(spongeType)) {
                // Use the more accurate cache instead
                return entry.getValue().applyUnchecked(handle);
            }
        }

        // We don't have any specific implementation for that type, so we'll use a generic one
        B result = instances.get(handle);
        if (result == null) {
            instances.put(handle, result = convert(handle));
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    protected B applyUnchecked(Object handle) {
        return apply((S) handle);
    }

    protected abstract B convert(S handle);

}
