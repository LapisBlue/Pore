/*
 * Pore
 * Copyright (c) 2014, Maxim Roncacé <http://bitbucket.org/mproncace>
 * Copyright (c) 2014, Lapis <https://github.com/LapisBlue>
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
package net.amigocraft.pore.util.converter;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import org.bukkit.block.BlockFace;
import org.spongepowered.api.util.Direction;

public class DirectionConverter {
    private static final BiMap<BlockFace, Direction> LOOKUP = ImmutableBiMap.<BlockFace, Direction>builder()
            .put(BlockFace.NORTH, Direction.NORTH)
            .put(BlockFace.EAST, Direction.EAST)
            .put(BlockFace.SOUTH, Direction.SOUTH)
            .put(BlockFace.WEST, Direction.WEST)
            .put(BlockFace.UP, Direction.UP)
            .put(BlockFace.DOWN, Direction.DOWN)
            .put(BlockFace.NORTH_EAST, Direction.NORTHEAST)
            .put(BlockFace.NORTH_WEST, Direction.NORTHWEST)
            .put(BlockFace.SOUTH_EAST, Direction.SOUTHEAST)
            .put(BlockFace.SOUTH_WEST, Direction.SOUTHWEST)
            .put(BlockFace.WEST_NORTH_WEST, Direction.WEST_NORTHWEST)
            .put(BlockFace.NORTH_NORTH_WEST, Direction.NORTH_NORTHWEST)
            .put(BlockFace.NORTH_NORTH_EAST, Direction.NORTH_NORTHEAST)
            .put(BlockFace.EAST_NORTH_EAST, Direction.EAST_NORTHEAST)
            .put(BlockFace.EAST_SOUTH_EAST, Direction.EAST_SOUTHEAST)
            .put(BlockFace.SOUTH_SOUTH_EAST, Direction.SOUTH_SOUTHEAST)
            .put(BlockFace.SOUTH_SOUTH_WEST, Direction.SOUTH_SOUTHWEST)
            .put(BlockFace.WEST_SOUTH_WEST, Direction.WEST_SOUTHWEST)
            .build();

    private static <E extends Enum<E>> E checkDefined(Enum<?> in, E out) {
        if (out == null) {
            throw new UnsupportedOperationException(in.name());
        }

        return out;
    }

    public static BlockFace of(Direction dir) {
        return checkDefined(dir, LOOKUP.inverse().get(dir));
    }

    public static Direction of(BlockFace face) {
        return checkDefined(face, LOOKUP.get(face));
    }
}
