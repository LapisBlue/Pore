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
package net.amigocraft.pore.util.converter;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import org.bukkit.potion.PotionEffectType;
import org.spongepowered.api.potion.PotionEffectTypes;

public class PotionEffectTypeConverter {

    private static BiMap<PotionEffectType, org.spongepowered.api.potion.PotionEffectType> TYPES =
            ImmutableBiMap.<PotionEffectType, org.spongepowered.api.potion.PotionEffectType>builder()
                    .put(PotionEffectType.SPEED, PotionEffectTypes.SPEED)
                    .put(PotionEffectType.SLOW, PotionEffectTypes.SLOWNESS)
                    .put(PotionEffectType.FAST_DIGGING, PotionEffectTypes.HASTE)
                    .put(PotionEffectType.SLOW_DIGGING, PotionEffectTypes.MINING_FATIGUE)
                    .put(PotionEffectType.INCREASE_DAMAGE, PotionEffectTypes.STRENGTH)
                    .put(PotionEffectType.HEAL, PotionEffectTypes.INSTANT_HEALTH)
                    .put(PotionEffectType.HARM, PotionEffectTypes.INSTANT_DAMAGE)
                    .put(PotionEffectType.JUMP, PotionEffectTypes.JUMP_BOOST)
                    .put(PotionEffectType.CONFUSION, PotionEffectTypes.NAUSEA)
                    .put(PotionEffectType.REGENERATION, PotionEffectTypes.REGENERATION)
                    .put(PotionEffectType.DAMAGE_RESISTANCE, PotionEffectTypes.RESISTANCE)
                    .put(PotionEffectType.FIRE_RESISTANCE, PotionEffectTypes.FIRE_RESISTANCE)
                    .put(PotionEffectType.WATER_BREATHING, PotionEffectTypes.WATER_BREATHING)
                    .put(PotionEffectType.INVISIBILITY, PotionEffectTypes.INVISIBILITY)
                    .put(PotionEffectType.BLINDNESS, PotionEffectTypes.BLINDNESS)
                    .put(PotionEffectType.NIGHT_VISION, PotionEffectTypes.NIGHT_VISION)
                    .put(PotionEffectType.HUNGER, PotionEffectTypes.HUNGER)
                    .put(PotionEffectType.WEAKNESS, PotionEffectTypes.WEAKNESS)
                    .put(PotionEffectType.POISON, PotionEffectTypes.POISON)
                    .put(PotionEffectType.WITHER, PotionEffectTypes.WITHER)
                    .put(PotionEffectType.HEALTH_BOOST, PotionEffectTypes.HEALTH_BOOST)
                    .put(PotionEffectType.ABSORPTION, PotionEffectTypes.ABSORPTION)
                    .put(PotionEffectType.SATURATION, PotionEffectTypes.SATURATION)
                    .build();

    public static org.spongepowered.api.potion.PotionEffectType of(PotionEffectType type) {
        return TYPES.get(type);
    }

    public static PotionEffectType of(org.spongepowered.api.potion.PotionEffectType type) {
        return TYPES.inverse().get(type);
    }
}
