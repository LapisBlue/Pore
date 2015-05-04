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
import org.bukkit.Rotation;
import org.spongepowered.api.util.rotation.Rotations;

public final class RotationConverter {

    private RotationConverter() {
    }

    public static final Converter<Rotation, org.spongepowered.api.util.rotation.Rotation> CONVERTER =
            TypeConverter.<Rotation, org.spongepowered.api.util.rotation.Rotation>builder()
                    .add(Rotation.NONE, Rotations.TOP)
                    .add(Rotation.CLOCKWISE_45, Rotations.TOP_RIGHT)
                    .add(Rotation.CLOCKWISE, Rotations.RIGHT)
                    .add(Rotation.CLOCKWISE_135, Rotations.BOTTOM_RIGHT)
                    .add(Rotation.FLIPPED, Rotations.BOTTOM)
                    .add(Rotation.FLIPPED_45, Rotations.BOTTOM_LEFT)
                    .add(Rotation.COUNTER_CLOCKWISE, Rotations.LEFT)
                    .add(Rotation.COUNTER_CLOCKWISE_45, Rotations.TOP_LEFT)
                    .build();

    public static org.spongepowered.api.util.rotation.Rotation of(Rotation rotation) {
        return CONVERTER.convert(rotation);
    }

    public static Rotation of(org.spongepowered.api.util.rotation.Rotation rotation) {
        return CONVERTER.reverse().convert(rotation);
    }
}
