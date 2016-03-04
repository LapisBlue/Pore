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

package blue.lapis.pore.util.classloader;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableSet;

import java.net.URL;
import java.net.URLClassLoader;

public class PoreClassLoader extends URLClassLoader implements LocalClassLoader {

    private static final ImmutableSet<String> EXCLUSIONS = ImmutableSet.of(
            "blue.lapis.pore.launch.",
            "blue.lapis.pore.util.classloader.",
            "blue.lapis.pore.PoreVersion"
    );

    private final ClassLoader parent;

    public PoreClassLoader(ClassLoader parent, URL... urls) {
        super(urls, null);
        this.parent = checkNotNull(parent, "parent");
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            boolean included = true;
            for (String exclusion : EXCLUSIONS) {
                if (name.startsWith(exclusion)) {
                    included = false;
                    break;
                }
            }

            if (included) {
                return super.findClass(name);
            }
        } catch (ClassNotFoundException ignored) {
        }

        return this.parent.loadClass(name);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> Class<T> defineClass(String name, byte[] b) {
        return (Class<T>) super.defineClass(name, b, 0, b.length);
    }

}
