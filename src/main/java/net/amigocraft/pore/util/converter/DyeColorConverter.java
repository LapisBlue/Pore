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

import com.google.common.collect.ImmutableBiMap;
import org.bukkit.DyeColor;
import org.spongepowered.api.entity.living.meta.DyeColors;

public class DyeColorConverter {

    private static ImmutableBiMap<org.bukkit.DyeColor, org.spongepowered.api.entity.living.meta.DyeColor> map =
            ImmutableBiMap.<org.bukkit.DyeColor, org.spongepowered.api.entity.living.meta.DyeColor>builder()
                    .put(DyeColor.BLACK, DyeColors.BLACK)
                    .put(DyeColor.BLUE, DyeColors.BLUE)
                    .put(DyeColor.BROWN, DyeColors.BROWN)
                    .put(DyeColor.CYAN, DyeColors.CYAN)
                    .put(DyeColor.GRAY, DyeColors.GRAY)
                    .put(DyeColor.GREEN, DyeColors.GREEN)
                    .put(DyeColor.LIGHT_BLUE, DyeColors.LIGHT_BLUE)
                    .put(DyeColor.LIME, DyeColors.LIME)
                    .put(DyeColor.MAGENTA, DyeColors.MAGENTA)
                    .put(DyeColor.ORANGE, DyeColors.ORANGE)
                    .put(DyeColor.PINK, DyeColors.PINK)
                    .put(DyeColor.PURPLE, DyeColors.PURPLE)
                    .put(DyeColor.RED, DyeColors.RED)
                    .put(DyeColor.SILVER, DyeColors.SILVER)
                    .put(DyeColor.WHITE, DyeColors.WHITE)
                    .put(DyeColor.YELLOW, DyeColors.YELLOW)
                    .build();

    public static org.spongepowered.api.entity.living.meta.DyeColor of(org.bukkit.DyeColor color) {
        return map.get(color);
    }

    public static org.bukkit.DyeColor of(org.spongepowered.api.entity.living.meta.DyeColor color) {
        return map.inverse().get(color);
    }

}
