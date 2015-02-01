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
package blue.lapis.pore.converter;

import blue.lapis.pore.PoreTests;
import blue.lapis.pore.util.PoreWrapper;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ListMultimap;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.withSettings;

public class PoreConverterTest {

    private ListMultimap<Class<?>, Class<?>> testRegistry;

    @Before
    public void initConverters() {
        PoreTests.mockPlugin();
        this.testRegistry = createRegistry();
    }

    private static ListMultimap<Class<?>, Class<?>> createRegistry() {
        ImmutableListMultimap.Builder<Class<?>, Class<?>> builder = ImmutableListMultimap.builder();

        for (Map.Entry<Class<?>, CachedWrapperConverter.Converter<?, ? extends PoreWrapper>> entry :
                PoreConverter.converter.registry.entrySet()) {

            scan(builder, entry.getKey(), null, entry.getValue());
        }

        return builder.build();
    }

    private static void scan(ImmutableMultimap.Builder<Class<?>, Class<?>> builder, Class<?> sponge,
                             Set<Class<?>> parents, CachedWrapperConverter.Converter<?, ?> converter) {
        Class<?> pore = converter.constructor.getDeclaringClass();
        builder.put(pore, sponge);

        ImmutableSet.Builder<Class<?>> parentsBuilder = ImmutableSet.<Class<?>>builder().add(sponge);

        if (parents != null) {
            builder.putAll(pore, parents);
            parentsBuilder.addAll(parents);
        }

        parents = parentsBuilder.build();

         for (Map.Entry<? extends Class<?>, ? extends CachedWrapperConverter.Converter<?, ?>> entry :
                 converter.registry.entrySet()) {

             scan(builder, entry.getKey(), parents, entry.getValue());
        }
    }

    private Object create(Class<?> pore) {
        List<Class<?>> interfaces = testRegistry.get(pore);
        Class<?> base = interfaces.get(0);
        if (interfaces.size() == 1) {
            return mock(base);
        } else {
            return mock(base, withSettings().extraInterfaces(
                    interfaces.subList(1, interfaces.size()).toArray(new Class<?>[interfaces.size() - 1])));
        }
    }

    @Test
    public void resolve() {
        for (Class<?> pore : testRegistry.keySet()) {
            assertEquals(pore, PoreConverter.of(create(pore)).getClass());
        }
    }
}
