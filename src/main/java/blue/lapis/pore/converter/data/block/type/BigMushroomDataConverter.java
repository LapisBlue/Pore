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
package blue.lapis.pore.converter.data.block.type;

import blue.lapis.pore.converter.data.AbstractDataValue;
import blue.lapis.pore.converter.data.DataTypeConverter;

import com.google.common.collect.ImmutableBiMap;
import org.spongepowered.api.data.manipulator.block.BigMushroomData;
import org.spongepowered.api.data.type.BigMushroomType;
import org.spongepowered.api.data.type.BigMushroomTypes;

public class BigMushroomDataConverter extends DataTypeConverter {

    @SuppressWarnings("rawtypes")
    private BigMushroomDataConverter() {
        converters.put(
                ImmutableBiMap.<AbstractDataValue, Byte>builder()
                        .put(new BigMushroomDataValue(BigMushroomTypes.ALL_INSIDE), (byte) 0)
                        .put(new BigMushroomDataValue(BigMushroomTypes.NORTH_WEST), (byte) 1)
                        .put(new BigMushroomDataValue(BigMushroomTypes.NORTH), (byte) 2)
                        .put(new BigMushroomDataValue(BigMushroomTypes.NORTH_EAST), (byte) 3)
                        .put(new BigMushroomDataValue(BigMushroomTypes.WEST), (byte) 4)
                        .put(new BigMushroomDataValue(BigMushroomTypes.CENTER), (byte) 5)
                        .put(new BigMushroomDataValue(BigMushroomTypes.EAST), (byte) 6)
                        .put(new BigMushroomDataValue(BigMushroomTypes.SOUTH_WEST), (byte) 7)
                        .put(new BigMushroomDataValue(BigMushroomTypes.SOUTH), (byte) 8)
                        .put(new BigMushroomDataValue(BigMushroomTypes.SOUTH_EAST), (byte) 9)
                        .put(new BigMushroomDataValue(BigMushroomTypes.STEM), (byte) 10)
                        .put(new BigMushroomDataValue(BigMushroomTypes.ALL_OUTSIDE), (byte) 14)
                        .put(new BigMushroomDataValue(BigMushroomTypes.ALL_STEM), (byte)15)
                        .build(),
                (byte)4);
        applicableTypes.add(BigMushroomData.class);
    }

    static class BigMushroomDataValue extends AbstractDataValue<BigMushroomData, BigMushroomType> {
        public BigMushroomDataValue(BigMushroomType value) {
            super(BigMushroomData.class, value);
        }
    }
}
