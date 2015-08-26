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
package blue.lapis.pore.util.constructor;

import static com.google.common.base.Preconditions.checkNotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class SimpleReflectConstructor<T, P> implements SimpleConstructor<T, P> {

    private final Constructor<T> handle;

    public SimpleReflectConstructor(Constructor<T> handle) {
        this.handle = checkNotNull(handle, "handle");
        this.handle.setAccessible(true);
    }

    public SimpleReflectConstructor(Class<T> type, Class<P> parameter) throws NoSuchMethodException {
        this(type.getDeclaredConstructor(parameter));
    }

    @Override
    public Class<T> getType() {
        return this.handle.getDeclaringClass();
    }

    @Override
    public T construct(P parameter) {
        try {
            return this.handle.newInstance(parameter);
        } catch (InvocationTargetException e) {
            throw new RuntimeException("Failed to construct " + getType(), e);
        } catch (InstantiationException e) {
            throw new RuntimeException("Failed to construct " + getType(), e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to construct " + getType(), e);
        }
    }

    public static class Provider implements SimpleConstructor.Provider {

        @Override
        public <T, P> SimpleConstructor<T, P> create(Class<T> type, Class<P> parameter) throws Exception {
            return new SimpleReflectConstructor<T, P>(type, parameter);
        }

    }

}
