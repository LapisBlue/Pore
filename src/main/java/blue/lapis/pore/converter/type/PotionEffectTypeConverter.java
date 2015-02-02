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
import org.bukkit.potion.PotionEffectType;
import org.spongepowered.api.potion.PotionEffectTypes;

public final class PotionEffectTypeConverter {

    public static final Converter<PotionEffectType, org.spongepowered.api.potion.PotionEffectType> CONVERTER =
            TypeConverter.<PotionEffectType, org.spongepowered.api.potion.PotionEffectType>mapBuilder()
                    .add(PotionEffectType.SPEED, PotionEffectTypes.SPEED)
                    .add(PotionEffectType.SLOW, PotionEffectTypes.SLOWNESS)
                    .add(PotionEffectType.FAST_DIGGING, PotionEffectTypes.HASTE)
                    .add(PotionEffectType.SLOW_DIGGING, PotionEffectTypes.MINING_FATIGUE)
                    .add(PotionEffectType.INCREASE_DAMAGE, PotionEffectTypes.STRENGTH)
                    .add(PotionEffectType.HEAL, PotionEffectTypes.INSTANT_HEALTH)
                    .add(PotionEffectType.HARM, PotionEffectTypes.INSTANT_DAMAGE)
                    .add(PotionEffectType.JUMP, PotionEffectTypes.JUMP_BOOST)
                    .add(PotionEffectType.CONFUSION, PotionEffectTypes.NAUSEA)
                    .add(PotionEffectType.REGENERATION, PotionEffectTypes.REGENERATION)
                    .add(PotionEffectType.DAMAGE_RESISTANCE, PotionEffectTypes.RESISTANCE)
                    .add(PotionEffectType.FIRE_RESISTANCE, PotionEffectTypes.FIRE_RESISTANCE)
                    .add(PotionEffectType.WATER_BREATHING, PotionEffectTypes.WATER_BREATHING)
                    .add(PotionEffectType.INVISIBILITY, PotionEffectTypes.INVISIBILITY)
                    .add(PotionEffectType.BLINDNESS, PotionEffectTypes.BLINDNESS)
                    .add(PotionEffectType.NIGHT_VISION, PotionEffectTypes.NIGHT_VISION)
                    .add(PotionEffectType.HUNGER, PotionEffectTypes.HUNGER)
                    .add(PotionEffectType.WEAKNESS, PotionEffectTypes.WEAKNESS)
                    .add(PotionEffectType.POISON, PotionEffectTypes.POISON)
                    .add(PotionEffectType.WITHER, PotionEffectTypes.WITHER)
                    .add(PotionEffectType.HEALTH_BOOST, PotionEffectTypes.HEALTH_BOOST)
                    .add(PotionEffectType.ABSORPTION, PotionEffectTypes.ABSORPTION)
                    .add(PotionEffectType.SATURATION, PotionEffectTypes.SATURATION)
                    .build();

    public static org.spongepowered.api.potion.PotionEffectType of(PotionEffectType potionEffectType) {
        return CONVERTER.convert(potionEffectType);
    }

    public static PotionEffectType of(org.spongepowered.api.potion.PotionEffectType potionEffectType) {
        return CONVERTER.reverse().convert(potionEffectType);
    }

}
