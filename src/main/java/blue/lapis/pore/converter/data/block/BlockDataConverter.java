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

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.DataManipulator;
import org.spongepowered.api.data.manipulator.SingleValueData;
import org.spongepowered.api.world.Location;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
                    .put(BlockTypes.LEAVES, getConverter(LeavesDataConverter.class))
                    .put(BlockTypes.LEAVES2, getConverter(Leaves2DataConverter.class))
                    .put(BlockTypes.LOG, getConverter(LogDataConverter.class))
                    .put(BlockTypes.LOG2, getConverter(Log2DataConverter.class))
                    .put(BlockTypes.PLANKS, getConverter(PlanksDataConverter.class))
                    .put(BlockTypes.STONEBRICK, getConverter(BrickDataConverter.class))
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

    @SuppressWarnings({"rawtypes", "unchecked"})
    public byte getDataValue(Collection<DataManipulator<?>> manipulators, BlockType target) {
        final DataTypeConverter converter = getConverter(target);
        Collection<DataManipulator<?>> data = Collections2.filter(manipulators, new Predicate<DataManipulator<?>>() {
            @Override
            public boolean apply(DataManipulator<?> input) {
                if (input == null) {
                    return false;
                }
                try {
                    Class<? extends DataManipulator<?>> clazz = (Class<? extends DataManipulator<?>>)
                            Class.forName(input.getClass().getName().split("\\$")[0]);
                    return converter.getApplicableDataTypes().contains(clazz);
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                    return false;
                }
            }
        });
        return converter.of(data);
    }

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public byte getDataValue(Location target) {
        return getDataValue(target.getManipulators(), target.getBlockType());
    }

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void setDataValue(Location target, byte dataValue) {
        DataTypeConverter converter = getConverter(target.getBlockType());
        Collection<AbstractDataValue> data = converter.of(dataValue);
        for (AbstractDataValue datum : data) {
            if (datum.getValue() != AbstractDataValue.ABSENT) {
                DataManipulator dm = (DataManipulator) target.getOrCreate(datum.getDataClass()).get();
                if (datum instanceof SingleValueData) {
                    ((SingleValueData) dm).setValue(datum.getValue());
                }
            }
        }
    }

    @SuppressWarnings("rawtypes")
    private DataTypeConverter getConverter(BlockType target) {
        if (!CONVERTER_MAP.containsKey(target)) {
            throw new IllegalArgumentException("Cannot convert data for block type " + target.getName());
        }
        return CONVERTER_MAP.get(target);
    }

}
