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

import net.amigocraft.pore.PoreTests;
import net.amigocraft.pore.util.PoreWrapper;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

public class PoreConverterTest {

    @Before
    public void initConverters() {
        PoreTests.mockPlugin();
    }

    @Test
    public void resolveNull() {
        assertNull(PoreConverter.of(null));
        assertNull(PoreConverter.of(null, null));
    }

    @Test
    public void resolve() {
        for (Map.Entry<Class<? extends PoreWrapper>, Class<?>> entry : PoreConverter.builder().registry.entrySet()) {
            Object handle = mock(entry.getValue());
            assertEquals(entry.getKey(), PoreConverter.of(handle).getClass());
        }
    }

    @Test
    public void resolveDirectly() {
        for (Map.Entry<Class<? extends PoreWrapper>, Class<?>> entry : PoreConverter.builder().registry.entrySet()) {
            Object handle = mock(entry.getValue());
            assertEquals(entry.getKey(), PoreConverter.of(entry.getKey(), handle).getClass());
        }
    }
}
