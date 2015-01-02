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

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.potion.Potion;
import org.spongepowered.api.effect.particle.ParticleType;
import org.spongepowered.api.effect.particle.ParticleTypes;
import org.spongepowered.api.effect.sound.SoundType;
import org.spongepowered.api.effect.sound.SoundTypes;

public class EffectConverter {

    public static SoundType toSound(Effect effect, int data) {
        if (effect.getType() == Effect.Type.SOUND) {
            switch (effect) {
                case CLICK2:
                    return SoundTypes.WOOD_CLICK;
                case CLICK1:
                    return SoundTypes.CLICK;
                case BOW_FIRE:
                    return SoundTypes.SHOOT_ARROW;
                case DOOR_TOGGLE:
                    return Math.random() >= 0.5 ? SoundTypes.DOOR_OPEN : SoundTypes.DOOR_CLOSE;
                case EXTINGUISH:
                    return SoundTypes.FIZZ; //TODO: verify this is the correct sound
                case RECORD_PLAY:
                    throw new NotImplementedException();
                case GHAST_SHRIEK:
                    return SoundTypes.GHAST_SCREAM;
                case GHAST_SHOOT:
                    return SoundTypes.GHAST_FIREBALL;
                case BLAZE_SHOOT:
                    return SoundTypes.BLAZE_BREATH;
                case ZOMBIE_CHEW_WOODEN_DOOR:
                    return SoundTypes.ZOMBIE_WOOD;
                case ZOMBIE_CHEW_IRON_DOOR:
                    return SoundTypes.ZOMBIE_METAL;
                case ZOMBIE_DESTROY_DOOR:
                    return SoundTypes.ZOMBIE_WOODBREAK;
                case STEP_SOUND:
                    throw new NotImplementedException(); //TODO: determine generic type of block
                default:
                    return null;
            }
        }
        return null;
    }

    public static ParticleType toParticle(Effect effect) {
        if (effect.getType() == Effect.Type.VISUAL) {
            switch (effect) {
                case SMOKE:
                    return ParticleTypes.SMOKE_NORMAL;
                default:
                    return null;
            }
        }
        return null;
    }

    public static <T> int getDataValue(Effect effect, T data) {
        switch(effect) {
            case POTION_BREAK:
                return ((Potion)data).toDamageValue() & 0x3F;
            case RECORD_PLAY:
                if (((Material)data).isRecord())
                    return ((Material)data).getId();
                else
                    throw new IllegalArgumentException("Data must be a record type!");
            case SMOKE:
                switch ((BlockFace)data) {
                    case UP:
                        return 0;
                    case DOWN:
                        return 0;
                    case SOUTH_EAST:
                        return 0;
                    case SOUTH_SOUTH_EAST:
                        return 0;
                    case SOUTH:
                        return 1;
                    case SOUTH_SOUTH_WEST:
                        return 1;
                    case SOUTH_WEST:
                        return 2;
                    case WEST_SOUTH_WEST:
                        return 2;
                    case EAST:
                        return 3;
                    case EAST_SOUTH_EAST:
                        return 3;
                    case SELF:
                        return 4;
                    case WEST:
                        return 5;
                    case WEST_NORTH_WEST:
                        return 5;
                    case NORTH_EAST:
                        return 6;
                    case EAST_NORTH_EAST:
                        return 6;
                    case NORTH:
                        return 7;
                    case NORTH_NORTH_EAST:
                        return 7;
                    case NORTH_WEST:
                        return 8;
                    case NORTH_NORTH_WEST:
                        return 8;
                    default:
                        throw new IllegalArgumentException("Invalid smoke direction!");
            }
            default:
                return 0;
        }
    }

}
