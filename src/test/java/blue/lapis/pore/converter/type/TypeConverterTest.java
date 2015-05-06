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

import static blue.lapis.pore.PoreTests.PACKAGE;

import blue.lapis.pore.PoreTests;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import org.apache.commons.lang3.StringUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.Set;

@RunWith(Parameterized.class)
public class TypeConverterTest {

    private static final String API_PACKAGE = "org.spongepowered.api";
    private static final String CONVERTER_PACKAGE = PACKAGE + "converter.type";
    private static final String CONVERTER_PREFIX = CONVERTER_PACKAGE + '.';

    @BeforeClass
    public static void initializeCatalogs() throws Exception {
        for (ClassPath.ClassInfo info : PoreTests.getClassPath().getTopLevelClassesRecursive(API_PACKAGE)) {
            Class<?> loaded = info.load();
            CatalogedBy catalogedBy = loaded.getAnnotation(CatalogedBy.class);
            if (catalogedBy != null) {
                PoreTests.setConstants(catalogedBy.value());
            }
        }
    }

    @Parameterized.Parameters(name = "{0}")
    public static Set<String> getConverters() throws Exception {
        ImmutableSet.Builder<String> converters = ImmutableSet.builder();
        for (ClassPath.ClassInfo converter : PoreTests.getClassPath().getTopLevelClassesRecursive(CONVERTER_PACKAGE)) {
            converters.add(StringUtils.removeStart(converter.getName(), CONVERTER_PREFIX));
        }
        return converters.build();
    }

    @Parameterized.Parameter
    public String converter;

    @Test
    public void load() throws ClassNotFoundException {
        Class.forName(CONVERTER_PREFIX + converter, true, ClassLoader.getSystemClassLoader());
    }

}
