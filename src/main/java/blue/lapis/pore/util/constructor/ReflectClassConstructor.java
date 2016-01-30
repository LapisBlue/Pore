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

public abstract class ReflectClassConstructor<T> implements ClassConstructor<T> {

    protected final Constructor<T> handle;

    private ReflectClassConstructor(Constructor<T> handle) {
        this.handle = checkNotNull(handle, "handle");
        this.handle.setAccessible(true);
    }

    @Override
    public Class<T> getType() {
        return this.handle.getDeclaringClass();
    }

    private static final class Simple<T, P> extends ReflectClassConstructor<T> implements SimpleClassConstructor<T, P> {

        private Simple(Class<T> type, Class<P> parameter) throws NoSuchMethodException {
            super(type.getConstructor(parameter));
        }

        @Override
        public T apply(P parameter) {
            try {
                return this.handle.newInstance(parameter);
            } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
                throw new RuntimeException("Failed to construct " + getType(), e);
            }
        }

    }

    private static final class Bi<T, A, B> extends ReflectClassConstructor<T> implements BiClassConstructor<T, A, B> {

        private Bi(Class<T> type, Class<A> parameterA, Class<B> parameterB) throws NoSuchMethodException {
            super(type.getConstructor(parameterA, parameterB));
        }

        @Override
        public T apply(A a, B b) {
            try {
                return this.handle.newInstance(a, b);
            } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
                throw new RuntimeException("Failed to construct " + getType(), e);
            }
        }

    }

    public static final class Provider implements SimpleClassConstructor.Provider {

        @Override
        public <T, P> SimpleClassConstructor<T, P> create(Class<T> type, Class<P> parameter) throws Exception {
            return new Simple<>(type, parameter);
        }

        @Override
        public <T, A, B> BiClassConstructor<T, A, B> create(Class<T> type, Class<A> parameterA, Class<B> parameterB)
                throws Exception {
            return new Bi<>(type, parameterA, parameterB);
        }

    }

}
