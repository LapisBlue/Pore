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

import blue.lapis.pore.converter.data.DataConverter;
import blue.lapis.pore.converter.data.DataTypeConverter;
import blue.lapis.pore.converter.data.block.type.BigMushroomDataConverter;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.manipulators.SingleValueData;
import org.spongepowered.api.world.Location;

import java.util.Map;

public class BlockDataConverter implements DataConverter<Location> {

    public static BlockDataConverter INSTANCE = new BlockDataConverter();

    private static final Map<BlockType, DataTypeConverter<?, ?>> CONVERTERS =
            ImmutableMap.<BlockType, DataTypeConverter<?, ?>>builder()
                    .put(BlockTypes.BROWN_MUSHROOM_BLOCK, new BigMushroomDataConverter())
                    .build();

    private BlockDataConverter() {
    }

    //TODO: this method is slightly horrific
    @Override
    public short getDataValue(Location target) {
        Optional<SingleValueData> data = getDataObject(target);
        if (!data.isPresent()) {
            return 0;
        }
        Object value = data.get().getValue();
        DataTypeConverter converter = getConverter(target);
        assert converter.getValueClass() == value.getClass();
        @SuppressWarnings("unchecked")
        short rawData = converter.of(value);
        return rawData;
    }

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void setDataValue(Location target, short dataValue) {
        DataTypeConverter converter = getConverter(target);
        SingleValueData data = getDataObject(target)
                .or((SingleValueData)target.getOrCreate(converter.getDataClass()).get());
        Optional<?> value = converter.of(dataValue);
        if (!value.isPresent()) {
            throw new IllegalArgumentException("Out of bounds data value");
        }
        data.setValue(value.get());
    }

    private DataTypeConverter getConverter(Location target) {
        if (!CONVERTERS.containsKey(target.getType())) {
            throw new IllegalArgumentException("Cannot convert data for block type " + target.getType().getName());
        }
        return CONVERTERS.get(target.getType());
    }

    @SuppressWarnings("rawtypes")
    private Optional<SingleValueData> getDataObject(Location target) {
        DataTypeConverter converter = getConverter(target);
        @SuppressWarnings("unchecked")
        Optional<?> optData = target.getData(converter.getDataClass());
        if (!optData.isPresent()) {
            return Optional.absent();
        }
        assert optData.get() instanceof SingleValueData;
        return Optional.of((SingleValueData)optData.get());
    }

}
