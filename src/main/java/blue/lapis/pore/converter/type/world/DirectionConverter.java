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
package blue.lapis.pore.converter.type.world;

import blue.lapis.pore.converter.type.TypeConverter;

import com.google.common.base.Converter;
import org.bukkit.block.BlockFace;
import org.spongepowered.api.util.Direction;

public final class DirectionConverter {

    public static final Converter<BlockFace, Direction> CONVERTER = TypeConverter.<BlockFace, Direction>builder()
            .add(BlockFace.NORTH, Direction.NORTH)
            .add(BlockFace.EAST, Direction.EAST)
            .add(BlockFace.SOUTH, Direction.SOUTH)
            .add(BlockFace.WEST, Direction.WEST)
            .add(BlockFace.UP, Direction.UP)
            .add(BlockFace.DOWN, Direction.DOWN)
            .add(BlockFace.NORTH_EAST, Direction.NORTHEAST)
            .add(BlockFace.NORTH_WEST, Direction.NORTHWEST)
            .add(BlockFace.SOUTH_EAST, Direction.SOUTHEAST)
            .add(BlockFace.SOUTH_WEST, Direction.SOUTHWEST)
            .add(BlockFace.WEST_NORTH_WEST, Direction.WEST_NORTHWEST)
            .add(BlockFace.NORTH_NORTH_WEST, Direction.NORTH_NORTHWEST)
            .add(BlockFace.NORTH_NORTH_EAST, Direction.NORTH_NORTHEAST)
            .add(BlockFace.EAST_NORTH_EAST, Direction.EAST_NORTHEAST)
            .add(BlockFace.EAST_SOUTH_EAST, Direction.EAST_SOUTHEAST)
            .add(BlockFace.SOUTH_SOUTH_EAST, Direction.SOUTH_SOUTHEAST)
            .add(BlockFace.SOUTH_SOUTH_WEST, Direction.SOUTH_SOUTHWEST)
            .add(BlockFace.WEST_SOUTH_WEST, Direction.WEST_SOUTHWEST)
            .build();

    public static Direction of(BlockFace blockFace) {
        return CONVERTER.convert(blockFace);
    }

    public static BlockFace of(Direction direction) {
        return CONVERTER.reverse().convert(direction);
    }

}
