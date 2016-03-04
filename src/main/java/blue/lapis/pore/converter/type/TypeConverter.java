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

package blue.lapis.pore.converter.type;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import com.google.common.base.Converter;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Map;

public final class TypeConverter<B, S> extends Converter<B, S> {

    private final ImmutableMap<B, S> bukkitToSponge;
    private final ImmutableMap<S, B> spongeToBukkit;

    private TypeConverter(ImmutableMap<B, S> bukkitToSponge, ImmutableMap<S, B> spongeToBukkit) {
        this.bukkitToSponge = bukkitToSponge;
        this.spongeToBukkit = spongeToBukkit;
    }

    private static <T> T checkDefined(T result, Object input) {
        if (result == null) {
            throw new UnsupportedOperationException(input.toString());
        }
        return result;
    }

    @Override
    protected S doForward(B bukkit) {
        if (bukkit == null) {
            return null;
        }
        return checkDefined(bukkitToSponge.get(bukkit), bukkit);
    }

    @Override
    protected B doBackward(S sponge) {
        if (sponge == null) {
            return null;
        }
        return checkDefined(spongeToBukkit.get(sponge), sponge);
    }

    public static <B, S> Builder<B, S> builder(Class<B> bukkit, Class<S> sponge) {
        return new Builder<>(bukkit, sponge);
    }

    public static class Builder<B, S> {

        private final Class<B> bukkit;
        private final Class<S> sponge;
        private final BiMap<B, S> registry = HashBiMap.create();

        public Builder(Class<B> bukkit, Class<S> sponge) {
            this.bukkit = bukkit;
            this.sponge = sponge;
        }

        public Builder<B, S> add(B bukkit, S sponge) {
            checkState(registry.put(checkNotNull(bukkit, "bukkit"), checkNotNull(sponge, "sponge")) == null,
                    "Key %s is already present", bukkit);
            return this;
        }

        public TypeConverter<B, S> build() {
            return new TypeConverter<>(create(bukkit, registry), create(sponge, registry.inverse()));
        }

        @SuppressWarnings({"unchecked", "rawtypes"})
        private static <K, V> ImmutableMap<K, V> create(Class<K> keyType, Map<K, V> input) {
            if (keyType.isEnum()) {
                return Maps.immutableEnumMap((Map) input);
            }

            return ImmutableMap.copyOf(input);
        }

    }

}
