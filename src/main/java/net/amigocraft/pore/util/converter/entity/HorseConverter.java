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
package net.amigocraft.pore.util.converter.entity;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import org.bukkit.entity.Horse;
import org.spongepowered.api.entity.living.meta.HorseColor;
import org.spongepowered.api.entity.living.meta.HorseColors;
import org.spongepowered.api.entity.living.meta.HorseStyle;
import org.spongepowered.api.entity.living.meta.HorseStyles;
import org.spongepowered.api.entity.living.meta.HorseVariant;
import org.spongepowered.api.entity.living.meta.HorseVariants;

public class HorseConverter {

    private static final BiMap<Horse.Variant, HorseVariant> VARIANTS =
            ImmutableBiMap.<Horse.Variant, HorseVariant>builder()
                    .put(Horse.Variant.HORSE, HorseVariants.HORSE)
                    .put(Horse.Variant.DONKEY, HorseVariants.DONKEY)
                    .put(Horse.Variant.MULE, HorseVariants.MULE)
                    .put(Horse.Variant.UNDEAD_HORSE, HorseVariants.UNDEAD_HORSE)
                    .put(Horse.Variant.SKELETON_HORSE, HorseVariants.SKELETON_HORSE)
                    .build();

    public static HorseVariant of(Horse.Variant variant) {
        return VARIANTS.get(variant);
    }

    public static Horse.Variant of(HorseVariant variant) {
        return VARIANTS.inverse().get(variant);
    }

    private static final BiMap<Horse.Color, HorseColor> COLORS =
            ImmutableBiMap.<Horse.Color, HorseColor>builder()
                    .put(Horse.Color.WHITE, HorseColors.WHITE)
                    .put(Horse.Color.CREAMY, HorseColors.CREAMY)
                    .put(Horse.Color.CHESTNUT, HorseColors.CHESTNUT)
                    .put(Horse.Color.BROWN, HorseColors.BROWN)
                    .put(Horse.Color.BLACK, HorseColors.BLACK)
                    .put(Horse.Color.GRAY, HorseColors.GRAY)
                    .put(Horse.Color.DARK_BROWN, HorseColors.DARK_BROWN)
                    .build();

    public static HorseColor of(Horse.Color color) {
        return COLORS.get(color);
    }

    public static Horse.Color of(HorseColor color) {
        return COLORS.inverse().get(color);
    }

    private static final BiMap<Horse.Style, HorseStyle> STYLES =
            ImmutableBiMap.<Horse.Style, HorseStyle>builder()
                    .put(Horse.Style.NONE, HorseStyles.NONE)
                    .put(Horse.Style.WHITE, HorseStyles.WHITE)
                    .put(Horse.Style.WHITEFIELD, HorseStyles.WHITEFIELD)
                    .put(Horse.Style.WHITE_DOTS, HorseStyles.WHITE_DOTS)
                    .put(Horse.Style.BLACK_DOTS, HorseStyles.BLACK_DOTS)
                    .build();

    public static HorseStyle of(Horse.Style Style) {
        return STYLES.get(Style);
    }

    public static Horse.Style of(HorseStyle Style) {
        return STYLES.inverse().get(Style);
    }
}
