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
package blue.lapis.pore.converter.data.block;

import blue.lapis.pore.converter.data.AbstractDataValue;
import blue.lapis.pore.converter.data.DataTypeConverter;
import blue.lapis.pore.converter.type.TypeConverter;

import com.google.common.collect.ImmutableBiMap;
import org.spongepowered.api.data.manipulator.block.BrickData;
import org.spongepowered.api.data.type.BrickType;
import org.spongepowered.api.data.type.BrickTypes;

public class BrickDataConverter extends DataTypeConverter {

    @SuppressWarnings("rawtypes")
    private BrickDataConverter() {
        converters.put(
                ImmutableBiMap.<AbstractDataValue, Byte>builder()
                        .put(new BrickDataValue(BrickTypes.DEFAULT), (byte) 0)
                        .put(new BrickDataValue(BrickTypes.MOSSY), (byte) 1)
                        .put(new BrickDataValue(BrickTypes.CRACKED), (byte) 2)
                        .put(new BrickDataValue(BrickTypes.CHISELED), (byte)3)
                        .build(),
                (byte) 2
        );
        applicableTypes.add(BrickData.class);
    }

    static class BrickDataValue extends AbstractDataValue<BrickData, BrickType> {
        public BrickDataValue(BrickType value) {
            super(BrickData.class, value);
        }
    }
}
