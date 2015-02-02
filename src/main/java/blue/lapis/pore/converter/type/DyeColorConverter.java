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
package blue.lapis.pore.converter.type;

import com.google.common.base.Converter;
import org.bukkit.DyeColor;
import org.spongepowered.api.entity.living.meta.DyeColors;

public final class DyeColorConverter {

    public static Converter<DyeColor, org.spongepowered.api.entity.living.meta.DyeColor> CONVERTER =
            TypeConverter.<DyeColor, org.spongepowered.api.entity.living.meta.DyeColor>builder()
                    .add(DyeColor.BLACK, DyeColors.BLACK)
                    .add(DyeColor.BLUE, DyeColors.BLUE)
                    .add(DyeColor.BROWN, DyeColors.BROWN)
                    .add(DyeColor.CYAN, DyeColors.CYAN)
                    .add(DyeColor.GRAY, DyeColors.GRAY)
                    .add(DyeColor.GREEN, DyeColors.GREEN)
                    .add(DyeColor.LIGHT_BLUE, DyeColors.LIGHT_BLUE)
                    .add(DyeColor.LIME, DyeColors.LIME)
                    .add(DyeColor.MAGENTA, DyeColors.MAGENTA)
                    .add(DyeColor.ORANGE, DyeColors.ORANGE)
                    .add(DyeColor.PINK, DyeColors.PINK)
                    .add(DyeColor.PURPLE, DyeColors.PURPLE)
                    .add(DyeColor.RED, DyeColors.RED)
                    .add(DyeColor.SILVER, DyeColors.SILVER)
                    .add(DyeColor.WHITE, DyeColors.WHITE)
                    .add(DyeColor.YELLOW, DyeColors.YELLOW)
                    .build();

    public static org.spongepowered.api.entity.living.meta.DyeColor of(org.bukkit.DyeColor color) {
        return CONVERTER.convert(color);
    }

    public static DyeColor of(org.spongepowered.api.entity.living.meta.DyeColor color) {
        return CONVERTER.reverse().convert(color);
    }

}
