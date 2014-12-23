/*
 * Pore
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
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.Environment;
import org.spongepowered.api.world.Environments;

public final class EnvironmentConverter {

    private static final BiMap<World.Environment, Environment> LOOKUP = ImmutableBiMap.of(
            World.Environment.NORMAL, Environments.OVERWORLD,
            World.Environment.NETHER, Environments.NETHER,
            World.Environment.THE_END, Environments.END
    );

    public static World.Environment of(Environment dir) {
        return LOOKUP.inverse().get(dir);
    }

    public static Environment of(World.Environment environment) {
        return LOOKUP.get(environment);
    }

}
