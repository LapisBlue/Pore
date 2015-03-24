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
package blue.lapis.pore.util;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * Utility class for building Maps via chained method calls.
 * @param <K> The key type
 * @param <V> The value type
 */
public final class BiMapBuilder<K, V> {

    private BiMap<K, V> backing;

    private BiMapBuilder() {
        backing = HashBiMap.create();
    }

    @SuppressWarnings("unchecked")
    public BiMapBuilder<K, V> put(K key, V value) {
        backing.put(key, value);
        return this;
    }

    public BiMap<K, V> build() {
        return backing;
    }

    public static <K, V> BiMapBuilder<K, V> builder() {
        return new BiMapBuilder<K, V>();
    }

}
