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
package blue.lapis.pore.util.converter.entity;

import blue.lapis.pore.util.converter.TypeConverter;
import com.google.common.base.Converter;
import org.bukkit.entity.Horse;
import org.spongepowered.api.entity.living.meta.HorseColor;
import org.spongepowered.api.entity.living.meta.HorseColors;
import org.spongepowered.api.entity.living.meta.HorseStyle;
import org.spongepowered.api.entity.living.meta.HorseStyles;
import org.spongepowered.api.entity.living.meta.HorseVariant;
import org.spongepowered.api.entity.living.meta.HorseVariants;

public final class HorseConverter {

    public static final Converter<Horse.Variant, HorseVariant> VARIANT_CONVERTER =
            TypeConverter.<Horse.Variant, HorseVariant>builder()
                    .add(Horse.Variant.HORSE, HorseVariants.HORSE)
                    .add(Horse.Variant.DONKEY, HorseVariants.DONKEY)
                    .add(Horse.Variant.MULE, HorseVariants.MULE)
                    .add(Horse.Variant.UNDEAD_HORSE, HorseVariants.UNDEAD_HORSE)
                    .add(Horse.Variant.SKELETON_HORSE, HorseVariants.SKELETON_HORSE)
                    .build();

    public static HorseVariant of(Horse.Variant variant) {
        return VARIANT_CONVERTER.convert(variant);
    }

    public static Horse.Variant of(HorseVariant variant) {
        return VARIANT_CONVERTER.reverse().convert(variant);
    }

    public static final Converter<Horse.Color, HorseColor> COLOR_CONVERTER =
            TypeConverter.<Horse.Color, HorseColor>builder()
                    .add(Horse.Color.WHITE, HorseColors.WHITE)
                    .add(Horse.Color.CREAMY, HorseColors.CREAMY)
                    .add(Horse.Color.CHESTNUT, HorseColors.CHESTNUT)
                    .add(Horse.Color.BROWN, HorseColors.BROWN)
                    .add(Horse.Color.BLACK, HorseColors.BLACK)
                    .add(Horse.Color.GRAY, HorseColors.GRAY)
                    .add(Horse.Color.DARK_BROWN, HorseColors.DARK_BROWN)
                    .build();

    public static HorseColor of(Horse.Color color) {
        return COLOR_CONVERTER.convert(color);
    }

    public static Horse.Color of(HorseColor color) {
        return COLOR_CONVERTER.reverse().convert(color);
    }

    public static final Converter<Horse.Style, HorseStyle> STYLE_CONVERTER =
            TypeConverter.<Horse.Style, HorseStyle>builder()
                    .add(Horse.Style.NONE, HorseStyles.NONE)
                    .add(Horse.Style.WHITE, HorseStyles.WHITE)
                    .add(Horse.Style.WHITEFIELD, HorseStyles.WHITEFIELD)
                    .add(Horse.Style.WHITE_DOTS, HorseStyles.WHITE_DOTS)
                    .add(Horse.Style.BLACK_DOTS, HorseStyles.BLACK_DOTS)
                    .build();

    public static HorseStyle of(Horse.Style style) {
        return STYLE_CONVERTER.convert(style);
    }

    public static Horse.Style of(HorseStyle style) {
        return STYLE_CONVERTER.reverse().convert(style);
    }

}
