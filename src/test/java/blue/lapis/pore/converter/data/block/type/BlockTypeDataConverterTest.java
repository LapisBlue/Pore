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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import blue.lapis.pore.Pore;
import blue.lapis.pore.PoreTests;
import blue.lapis.pore.converter.data.AbstractDataValue;
import blue.lapis.pore.converter.data.DataTypeConverter;
import blue.lapis.pore.converter.data.block.BlockDataConverter;
import blue.lapis.pore.impl.block.PoreBlock;

import com.google.common.base.Optional;
import org.bukkit.block.Block;
import org.junit.Before;
import org.junit.Test;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.DataManipulator;
import org.spongepowered.api.data.manipulator.SingleValueData;
import org.spongepowered.api.data.manipulator.block.BigMushroomData;
import org.spongepowered.api.data.manipulator.block.BrickData;
import org.spongepowered.api.data.type.BigMushroomTypes;
import org.spongepowered.api.data.type.BrickTypes;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.extent.Extent;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;

public class BlockTypeDataConverterTest {

    @Before
    public void setupEnvironment() throws Exception {
        Field instance = Pore.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, new Pore());
        Field logger = Pore.class.getDeclaredField("logger");
        logger.setAccessible(true);
        logger.set(instance.get(null), PoreTests.getLogger());
        setConstants();
    }

    public void setConstants() throws Exception {
        PoreTests.setConstants(BlockTypes.class);
        PoreTests.setConstants(BigMushroomTypes.class);
        PoreTests.setConstants(BrickTypes.class);
    }

    @SuppressWarnings("rawtypes")
    public <T extends SingleValueData<V, T>, V> void testSingleAbstraction(BlockType blockType, Class<T> dataClass,
                                                                           byte inputByte, V expectedValue)
            throws Exception {
        AbstractDataValue<T, V> output = new AbstractDataValue<T, V>(dataClass, expectedValue);
        Collection<AbstractDataValue<T, V>> outputColl = Collections.singletonList(output);
        testAbstraction(blockType, inputByte, outputColl);
    }

    @SuppressWarnings("rawtypes")
    public <T extends SingleValueData<V, T>, V> void testSingleDeabstraction(BlockType blockType, Class<T> dataClass,
                                                                             V inputValue, byte expectedByte,
                                                                             boolean invert) throws Exception {
        AbstractDataValue<T, V> input = new AbstractDataValue<T, V>(dataClass, inputValue);
        Collection<AbstractDataValue<T, V>> inputColl = Collections.singletonList(input);
        testDeabstraction(blockType, inputColl, expectedByte, invert);
    }

    public <T extends SingleValueData<V, T>, V> void testSingleDeabstraction(BlockType blockType, Class<T> dataClass,
                                                                             V inputValue, byte expectedByte)
            throws Exception {
        testSingleDeabstraction(blockType, dataClass, inputValue, expectedByte, false);
    }

    @SuppressWarnings("rawtypes")
    public void testAbstraction(BlockType blockType, byte inputByte,
                                Collection<? extends AbstractDataValue<? extends SingleValueData, ?>> expectedData)
            throws Exception {
        Location loc = new Location(mock(Extent.class), 0, 0, 0);
        when(loc.getType()).thenReturn(blockType);
        Method getConverter = BlockDataConverter.class.getDeclaredMethod("getConverter", Location.class);
        getConverter.setAccessible(true);
        DataTypeConverter converter = (DataTypeConverter) getConverter.invoke(BlockDataConverter.INSTANCE, loc);
        Collection<AbstractDataValue> derived = converter.of(inputByte);
        assertTrue(derived.containsAll(expectedData));
        assertTrue(expectedData.containsAll(derived));
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public void testDeabstraction(BlockType blockType,
                                  Collection<? extends AbstractDataValue<? extends SingleValueData, ?>> inputData,
                                  byte expectedByte, boolean invert) throws Exception {
        Location loc = new Location(mock(Extent.class), 0, 0, 0);
        when(loc.getType()).thenReturn(blockType);
        for (AbstractDataValue datum : inputData) {
            SingleValueData<?, ?> spongeDatum = (SingleValueData<?, ?>)mock(datum.getDataClass());
            when(spongeDatum.getValue()).thenReturn(datum.getValue());
            Optional<? extends SingleValueData<?, ?>> optData = Optional.fromNullable(spongeDatum);
            // for some unknown reason IntellIJ doesn't think the next line compiles, but javac handles it fine
            when(loc.getData((Class<DataManipulator>)datum.getDataClass())).thenReturn(optData);
        }
        Block block = PoreBlock.of(loc);
        if (invert) {
            assertNotEquals((long) expectedByte, (long) block.getData());
        } else {
            assertEquals(expectedByte, block.getData());
        }
    }

    @SuppressWarnings("rawtypes")
    public void testDeabstraction(BlockType blockType,
                                  Collection<? extends AbstractDataValue<? extends SingleValueData, ?>> inputData,
                                  byte expectedByte) throws Exception {
        testDeabstraction(blockType, inputData, expectedByte, false);
    }

    @Test
    public void testBigMushroomAbstraction() throws Exception {
        testSingleAbstraction(BlockTypes.BROWN_MUSHROOM_BLOCK, BigMushroomData.class, (byte) 5,
                BigMushroomTypes.CENTER);
        // 245 = 5 & ((2^4 - 1) << 4), i.e. 11110101
        testSingleAbstraction(BlockTypes.BROWN_MUSHROOM_BLOCK, BigMushroomData.class, (byte) 245,
                BigMushroomTypes.CENTER);
    }

    @Test
    public void testBigMushroomDeabstraction() throws Exception {
        testSingleDeabstraction(BlockTypes.BROWN_MUSHROOM_BLOCK, BigMushroomData.class, BigMushroomTypes.ALL_OUTSIDE,
                (byte) 14);
        testSingleDeabstraction(BlockTypes.BROWN_MUSHROOM_BLOCK, BigMushroomData.class, BigMushroomTypes.ALL_OUTSIDE,
                (byte) 5, true);
    }

    @Test
    public void testBrickAbstraction() throws Exception {
        testSingleAbstraction(BlockTypes.STONEBRICK, BrickData.class, (byte) 3,
                BrickTypes.CHISELED);
        // 243 = 5 & ((2^4 - 1) << 4), i.e. 11110011
        testSingleAbstraction(BlockTypes.STONEBRICK, BrickData.class, (byte) 243,
                BrickTypes.CHISELED);
    }

    @Test
    public void testBrickDeabstraction() throws Exception {
        testSingleDeabstraction(BlockTypes.STONEBRICK, BrickData.class, BrickTypes.CHISELED,
                (byte) 3);
        testSingleDeabstraction(BlockTypes.STONEBRICK, BrickData.class, BrickTypes.CHISELED,
                (byte) 2, true);
    }

}
