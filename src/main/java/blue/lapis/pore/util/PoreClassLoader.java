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

import blue.lapis.pore.PoreBootstrap;
import com.google.common.collect.Sets;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Set;

public class PoreClassLoader extends URLClassLoader {

    private static Set<String> exclusions = Sets.newHashSet(
            "blue.lapis.pore.PoreBootstrap"
    );
    private final ClassLoader parent;

    public PoreClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, null);
        this.parent = parent;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            if (!exclusions.contains(name)) {
                return super.findClass(name);
            }
        } catch (ClassNotFoundException ignored) {
            try {
                return findClass0(name, PoreBootstrap.class.getClassLoader());
            } catch (ClassNotFoundException ignored2) {}
        }
        return findClass0(name, this.parent);
    }

    private static Class<?> findClass0(String name, ClassLoader loader) throws ClassNotFoundException {
        try {
            Method method = loader.getClass().getDeclaredMethod("findClass", String.class);
            method.setAccessible(true);
            return (Class<?>) method.invoke(loader, name);
        } catch (Throwable e) {
            throw new ClassNotFoundException(name);
        }
    }

    @Override
    public Class<?> loadClass(final String name) throws ClassNotFoundException {
        try {
            if (!exclusions.contains(name)) {
                return super.loadClass(name);
            }
        } catch (ClassNotFoundException ignored) {
            try {
                return PoreBootstrap.class.getClassLoader().loadClass(name);
            } catch (ClassNotFoundException ignored2) {}
        }
        return this.parent.loadClass(name);
    }
}
