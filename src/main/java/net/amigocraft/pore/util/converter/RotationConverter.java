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

import com.google.common.collect.ImmutableMap;
import org.bukkit.Rotation;
import org.spongepowered.api.util.rotation.Rotations;

public class RotationConverter {

    private static final ImmutableMap<Rotation, org.spongepowered.api.util.rotation.Rotation> map =
            ImmutableMap.<Rotation, org.spongepowered.api.util.rotation.Rotation>builder()
                    .put(Rotation.NONE, Rotations.TOP)
                    .put(Rotation.CLOCKWISE, Rotations.RIGHT)
                    .put(Rotation.FLIPPED, Rotations.BOTTOM)
                    .put(Rotation.COUNTER_CLOCKWISE, Rotations.LEFT)
                    .build();


    private static final ImmutableMap<org.spongepowered.api.util.rotation.Rotation, Rotation> reverseMap =
            ImmutableMap.<org.spongepowered.api.util.rotation.Rotation, Rotation>builder()
                    .put(Rotations.TOP, Rotation.NONE)
                    .put(Rotations.TOP_RIGHT, Rotation.NONE)
                    .put(Rotations.RIGHT, Rotation.CLOCKWISE)
                    .put(Rotations.BOTTOM_RIGHT, Rotation.CLOCKWISE)
                    .put(Rotations.BOTTOM, Rotation.FLIPPED)
                    .put(Rotations.BOTTOM_LEFT, Rotation.FLIPPED)
                    .put(Rotations.LEFT, Rotation.COUNTER_CLOCKWISE)
                    .put(Rotations.TOP_LEFT, Rotation.COUNTER_CLOCKWISE)
                    .build();

    public static org.spongepowered.api.util.rotation.Rotation of(Rotation rotation) {
        return map.get(rotation);
    }

    public static Rotation of(org.spongepowered.api.util.rotation.Rotation rotation) {
        return reverseMap.get(rotation);
    }
}
