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

import static blue.lapis.pore.converter.data.block.BTDCTestUtil.testConversion;
import static blue.lapis.pore.converter.data.block.BTDCTestUtil.testDeabstraction;
import static blue.lapis.pore.converter.data.block.BTDCTestUtil.testSingleAbstraction;
import static blue.lapis.pore.converter.data.block.BTDCTestUtil.testSingleConversion;

import blue.lapis.pore.Pore;
import blue.lapis.pore.PoreTests;
import blue.lapis.pore.converter.data.AbstractDataValue;

import org.junit.Before;
import org.junit.Test;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.DataManipulator;
import org.spongepowered.api.data.manipulator.SingleValueData;
import org.spongepowered.api.data.manipulator.block.BigMushroomData;
import org.spongepowered.api.data.manipulator.block.BrickData;
import org.spongepowered.api.data.manipulator.block.TreeData;
import org.spongepowered.api.data.type.BigMushroomTypes;
import org.spongepowered.api.data.type.BrickTypes;
import org.spongepowered.api.data.type.TreeTypes;
import org.spongepowered.api.util.Axis;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;

@SuppressWarnings("rawtypes")
public class BlockTypeDataConverterTest {

    @Before
    public void setupEnvironment() throws Exception {
        Field instance = Pore.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, Pore.getInstance());
        Field logger = Pore.class.getDeclaredField("logger");
        logger.setAccessible(true);
        logger.set(instance.get(null), PoreTests.getLogger());
        setConstants();
    }

    public void setConstants() throws Exception {
        PoreTests.setConstants(Axis.class);
        PoreTests.setConstants(BlockTypes.class);
        PoreTests.setConstants(BigMushroomTypes.class);
        PoreTests.setConstants(BrickTypes.class);
        PoreTests.setConstants(TreeTypes.class);
    }

    @Test
    public void testBitmasking() throws Exception {
        // 245 = 5 | ((2^4 - 1) << 4), i.e. 0101 -> 11110101
        testSingleAbstraction(BlockTypes.BROWN_MUSHROOM_BLOCK, BigMushroomData.class, (byte) 245,
                BigMushroomTypes.CENTER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOutOfBoundsByte() throws Exception {
        testSingleAbstraction(BlockTypes.PLANKS, TreeData.class, (byte) 7, TreeTypes.JUNGLE);
    }

    @Test
    public void testBigMushroomConversion() throws Exception {
        testSingleConversion(BlockTypes.BROWN_MUSHROOM_BLOCK, BigMushroomData.class, (byte) 5, BigMushroomTypes.CENTER);
    }

    @Test
    public void testBrickConversion() throws Exception {
        testSingleConversion(BlockTypes.STONEBRICK, BrickData.class, (byte) 3, BrickTypes.CHISELED);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testLogConversion() throws Exception {
        Collection<? extends AbstractDataValue<? extends SingleValueData, ?>> expected = Arrays.asList(
                new LogDataConverter.TreeDataValue(TreeTypes.SPRUCE),
                new LogDataConverter.AxisDataValue(Axis.X)
        );
        testConversion(BlockTypes.LOG, (byte) 5, expected);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testLog2Conversion() throws Exception {
        Collection<? extends AbstractDataValue<? extends DataManipulator, ?>> expected = Arrays.asList(
                new LogDataConverter.TreeDataValue(TreeTypes.DARK_OAK),
                new LogDataConverter.AxisDataValue(Axis.X)
        );
        testConversion(BlockTypes.LOG2, (byte) 5, expected);
    }

    @Test
    public void testPlanksConversion() throws Exception {
        testSingleAbstraction(BlockTypes.PLANKS, TreeData.class, (byte) 3, TreeTypes.JUNGLE);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testLeavesConversion() throws Exception {
        Collection<? extends AbstractDataValue<? extends DataManipulator, ?>> input = Arrays.asList(
                new LogDataConverter.TreeDataValue(TreeTypes.SPRUCE),
                new LeavesDataConverter.DecayableDataValue(false)
        );
        testDeabstraction(BlockTypes.LEAVES, (byte) 1, input);
        testSingleAbstraction(BlockTypes.LEAVES, TreeData.class, (byte) 1, TreeTypes.SPRUCE);
        Collection<? extends AbstractDataValue<? extends DataManipulator, ?>> expected = Arrays.asList(
                new LogDataConverter.TreeDataValue(TreeTypes.SPRUCE),
                new LeavesDataConverter.DecayableDataValue(true)
        );
        testConversion(BlockTypes.LEAVES, (byte) 5, expected);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testLeaves2Conversion() throws Exception {
        Collection<? extends AbstractDataValue<? extends DataManipulator, ?>> input = Arrays.asList(
                new LogDataConverter.TreeDataValue(TreeTypes.DARK_OAK),
                new LeavesDataConverter.DecayableDataValue(false)
        );
        testDeabstraction(BlockTypes.LEAVES2, (byte) 1, input);
        testSingleAbstraction(BlockTypes.LEAVES2, TreeData.class, (byte) 1, TreeTypes.DARK_OAK);
        Collection<? extends AbstractDataValue<? extends DataManipulator, ?>> expected = Arrays.asList(
                new LogDataConverter.TreeDataValue(TreeTypes.DARK_OAK),
                new LeavesDataConverter.DecayableDataValue(true)
        );
        testConversion(BlockTypes.LEAVES2, (byte) 5, expected);
    }

}
