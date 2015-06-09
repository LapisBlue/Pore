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
import org.spongepowered.api.data.manipulator.block.BrickData;
import org.spongepowered.api.data.type.BrickType;
import org.spongepowered.api.data.type.BrickTypes;

public class BrickDataConverter extends DataTypeConverter<BrickData, BrickType> {

    private static final Converter<BrickType, Integer> CONVERTER =
            TypeConverter.builder(BrickType.class, Integer.class)
                    .add(BrickTypes.DEFAULT, 0)
                    .add(BrickTypes.MOSSY, 1)
                    .add(BrickTypes.CRACKED, 2)
                    .add(BrickTypes.CHISELED, 3)
                    .build();

    public Converter<BrickType, Integer> getConverter() {
        return CONVERTER;
    }

    @Override
    public Class<BrickData> getDataClass() {
        return BrickData.class;
    }

    @Override
    public Class<BrickType> getValueClass() {
        return BrickType.class;
    }
}
