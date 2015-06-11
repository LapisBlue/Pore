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

import blue.lapis.pore.Pore;
import blue.lapis.pore.converter.data.AbstractDataValue;
import blue.lapis.pore.converter.data.DataConverter;
import blue.lapis.pore.converter.data.DataTypeConverter;
import blue.lapis.pore.converter.data.block.type.BigMushroomDataConverter;
import blue.lapis.pore.converter.data.block.type.BrickDataConverter;
import blue.lapis.pore.converter.data.block.type.Log2DataConverter;
import blue.lapis.pore.converter.data.block.type.LogDataConverter;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.manipulator.SingleValueData;
import org.spongepowered.api.world.Location;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class BlockDataConverter implements DataConverter<Location> {

    public static BlockDataConverter INSTANCE = new BlockDataConverter();

    private static final Map<Class<?>, DataTypeConverter> CONVERTER_OBJECTS = Maps.newHashMap();

    @SuppressWarnings("ConstantConditions")
    private static final Map<BlockType, DataTypeConverter> CONVERTER_MAP =
            ImmutableMap.<BlockType, DataTypeConverter>builder()
                    .put(BlockTypes.BROWN_MUSHROOM_BLOCK, getConverter(BigMushroomDataConverter.class))
                    .put(BlockTypes.RED_MUSHROOM_BLOCK, getConverter(BigMushroomDataConverter.class))
                    .put(BlockTypes.STONEBRICK, getConverter(BrickDataConverter.class))
                    .put(BlockTypes.LOG, getConverter(LogDataConverter.class))
                    .put(BlockTypes.LOG2, getConverter(Log2DataConverter.class))
                    .build();

    private BlockDataConverter() {
    }

    private static DataTypeConverter getConverter(Class<?> clazz) {
        Exception e; // f--- Java 6 yo
        if (CONVERTER_OBJECTS.containsKey(clazz)) {
            return CONVERTER_OBJECTS.get(clazz);
        } else {
            try {
                Constructor<?> c = clazz.getDeclaredConstructors()[0];
                c.setAccessible(true);
                return (DataTypeConverter) c.newInstance();
            } catch (IllegalAccessException ex) {
                e = ex;
            } catch (InstantiationException ex) {
                e = ex;
            } catch (InvocationTargetException ex) {
                e = ex;
            }
            Pore.getLogger().error("Failed to instantiate " + clazz.getName());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public byte getDataValue(Location target) {
        DataTypeConverter converter = getConverter(target);
        ArrayList<SingleValueData<?, ?>> data = new ArrayList<SingleValueData<?, ?>>();
        for (Class<? extends SingleValueData> clazz : converter.getApplicableDataTypes()) {
            // SingleValueData extends DataManipulator, idk why javac thinks the below call is unchecked
            Optional<?> optData = target.getData(clazz);
            if (optData.isPresent()) {
                if (optData.get() instanceof SingleValueData) {
                    data.add((SingleValueData)optData.get());
                }
            }
        }
        return converter.of(data);
    }

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void setDataValue(Location target, byte dataValue) {
        DataTypeConverter converter = getConverter(target);
        Collection<AbstractDataValue> data = converter.of(dataValue);
        for (AbstractDataValue datum : data) {
            SingleValueData svd = (SingleValueData) target.getOrCreate(datum.getDataClass()).get();
            svd.setValue(datum.getValue());
        }
    }

    @SuppressWarnings("rawtypes")
    private DataTypeConverter getConverter(Location target) {
        if (!CONVERTER_MAP.containsKey(target.getType())) {
            throw new IllegalArgumentException("Cannot convert data for block type " + target.getType().getName());
        }
        return CONVERTER_MAP.get(target.getType());
    }

}
