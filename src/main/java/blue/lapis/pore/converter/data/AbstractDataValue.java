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
package blue.lapis.pore.converter.data;

import com.google.common.base.Objects;
import org.spongepowered.api.data.manipulator.SingleValueData;

public class AbstractDataValue<T extends SingleValueData<V, T>, V> {

    private final Class<T> clazz;
    private final V value;

    public AbstractDataValue(Class<T> dataClass, V value) {
        this.clazz = dataClass;
        this.value = value;
    }

    public Class<T> getDataClass() {
        return this.clazz;
    }

    public V getValue() {
        return this.value;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static AbstractDataValue of(SingleValueData data) {
        return new AbstractDataValue(data.getClass(), data.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(clazz, value);
    }

}
