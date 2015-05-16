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

import blue.lapis.pore.converter.data.DataTypeConverter;
import blue.lapis.pore.converter.type.TypeConverter;

import com.google.common.base.Converter;
import com.google.common.base.Optional;
import org.spongepowered.api.data.manipulators.blocks.BigMushroomData;
import org.spongepowered.api.data.types.BigMushroomType;
import org.spongepowered.api.data.types.BigMushroomTypes;

public class BigMushroomDataConverter implements DataTypeConverter<BigMushroomData, BigMushroomType> {

    private static final Converter<BigMushroomType, Integer> CONVERTER =
            TypeConverter.builder(BigMushroomType.class, Integer.class)
                    .add(BigMushroomTypes.ALL_INSIDE, 0)
                    .add(BigMushroomTypes.NORTH_WEST, 1)
                    .add(BigMushroomTypes.NORTH, 2)
                    .add(BigMushroomTypes.NORTH_EAST, 3)
                    .add(BigMushroomTypes.WEST, 4)
                    .add(BigMushroomTypes.CENTER, 5)
                    .add(BigMushroomTypes.EAST, 6)
                    .add(BigMushroomTypes.SOUTH_WEST, 7)
                    .add(BigMushroomTypes.SOUTH, 8)
                    .add(BigMushroomTypes.SOUTH_EAST, 9)
                    .add(BigMushroomTypes.STEM, 10)
                    .add(BigMushroomTypes.ALL_OUTSIDE, 14)
                    .add(BigMushroomTypes.ALL_STEM, 15)
                    .build();

    @Override
    public short of(BigMushroomType data) {
        Integer value = CONVERTER.convert(data);
        return value != null ? value.shortValue() : 0;
    }

    @Override
    public Optional<BigMushroomType> of(short data) {
        return Optional.fromNullable(CONVERTER.reverse().convert((int)data));
    }

    @Override
    public Class<BigMushroomData> getDataClass() {
        return BigMushroomData.class;
    }

    @Override
    public Class<BigMushroomType> getValueClass() {
        return BigMushroomType.class;
    }
}
