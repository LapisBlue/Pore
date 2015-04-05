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
package blue.lapis.pore.converter.type.entity;

import blue.lapis.pore.converter.type.TypeConverter;

import com.google.common.base.Converter;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.EntityTypes;

public final class EntityConverter {

    private static final Converter<org.bukkit.entity.EntityType, org.spongepowered.api.entity.EntityType> CONVERTER =
            TypeConverter.<org.bukkit.entity.EntityType, org.spongepowered.api.entity.EntityType>builder()
                    .add(EntityType.ARMOR_STAND, EntityTypes.ARMOR_STAND)
                    .add(EntityType.ARROW, EntityTypes.ARROW)
                    .add(EntityType.BAT, EntityTypes.BAT)
                    .add(EntityType.BLAZE, EntityTypes.BLAZE)
                    .add(EntityType.BOAT, EntityTypes.BOAT)
                    .add(EntityType.CAVE_SPIDER, EntityTypes.CAVE_SPIDER)
                    .add(EntityType.CHICKEN, EntityTypes.CHICKEN)
                    .add(EntityType.COMPLEX_PART, EntityTypes.COMPLEX_PART)
                    .add(EntityType.COW, EntityTypes.COW)
                    .add(EntityType.CREEPER, EntityTypes.CREEPER)
                    .add(EntityType.DROPPED_ITEM, EntityTypes.DROPPED_ITEM)
                    .add(EntityType.EGG, EntityTypes.EGG)
                    .add(EntityType.ENDER_CRYSTAL, EntityTypes.ENDER_CRYSTAL)
                    .add(EntityType.ENDER_DRAGON, EntityTypes.ENDER_DRAGON)
                    .add(EntityType.ENDER_PEARL, EntityTypes.ENDER_PEARL)
                    .add(EntityType.ENDER_SIGNAL, EntityTypes.EYE_OF_ENDER)
                    .add(EntityType.ENDERMAN, EntityTypes.ENDERMAN)
                    .add(EntityType.ENDERMITE, EntityTypes.ENDERMITE)
                    .add(EntityType.EXPERIENCE_ORB, EntityTypes.EXPERIENCE_ORB)
                    .add(EntityType.FALLING_BLOCK, EntityTypes.FALLING_BLOCK)
                    .add(EntityType.FIREBALL, EntityTypes.FIREBALL)
                    .add(EntityType.FIREWORK, EntityTypes.FIREWORK)
                    .add(EntityType.FISHING_HOOK, EntityTypes.FISHING_HOOK)
                    .add(EntityType.GHAST, EntityTypes.GHAST)
                    .add(EntityType.GIANT, EntityTypes.GIANT)
                    .add(EntityType.GUARDIAN, EntityTypes.GUARDIAN)
                    .add(EntityType.HORSE, EntityTypes.HORSE)
                    .add(EntityType.IRON_GOLEM, EntityTypes.IRON_GOLEM)
                    .add(EntityType.ITEM_FRAME, EntityTypes.ITEM_FRAME)
                    .add(EntityType.LEASH_HITCH, EntityTypes.LEASH_HITCH)
                    .add(EntityType.LIGHTNING, EntityTypes.LIGHTNING)
                    .add(EntityType.MAGMA_CUBE, EntityTypes.MAGMA_CUBE)
                    .add(EntityType.MINECART, EntityTypes.RIDEABLE_MINECART)
                    .add(EntityType.MINECART_CHEST, EntityTypes.CHESTED_MINECART)
                    .add(EntityType.MINECART_COMMAND, EntityTypes.COMMANDBLOCK_MINECART)
                    .add(EntityType.MINECART_FURNACE, EntityTypes.FURNACE_MINECART)
                    .add(EntityType.MINECART_HOPPER, EntityTypes.HOPPER_MINECART)
                    .add(EntityType.MINECART_MOB_SPAWNER, EntityTypes.MOB_SPAWNER_MINECART)
                    .add(EntityType.MINECART_TNT, EntityTypes.TNT_MINECART)
                    .add(EntityType.MUSHROOM_COW, EntityTypes.MUSHROOM_COW)
                    .add(EntityType.OCELOT, EntityTypes.OCELOT)
                    .add(EntityType.PAINTING, EntityTypes.PAINTING)
                    .add(EntityType.PIG, EntityTypes.PIG)
                    .add(EntityType.PIG_ZOMBIE, EntityTypes.PIG_ZOMBIE)
                    .add(EntityType.PLAYER, EntityTypes.PLAYER)
                    .add(EntityType.PRIMED_TNT, EntityTypes.PRIMED_TNT)
                    .add(EntityType.RABBIT, EntityTypes.RABBIT)
                    .add(EntityType.SHEEP, EntityTypes.SHEEP)
                    .add(EntityType.SILVERFISH, EntityTypes.SILVERFISH)
                    .add(EntityType.SKELETON, EntityTypes.SKELETON)
                    .add(EntityType.SLIME, EntityTypes.SLIME)
                    .add(EntityType.SMALL_FIREBALL, EntityTypes.SMALL_FIREBALL)
                    .add(EntityType.SNOWBALL, EntityTypes.SNOWBALL)
                    .add(EntityType.SNOWMAN, EntityTypes.SNOWMAN)
                    .add(EntityType.SPIDER, EntityTypes.SPIDER)
                    .add(EntityType.SPLASH_POTION, EntityTypes.SPLASH_POTION)
                    .add(EntityType.SQUID, EntityTypes.SQUID)
                    .add(EntityType.THROWN_EXP_BOTTLE, EntityTypes.THROWN_EXP_BOTTLE)
                    //.add(EntityType.UNKNOWN, EntityTypes.UNKNOWN) //TODO: this is null in Sponge
                    .add(EntityType.VILLAGER, EntityTypes.VILLAGER)
                    .add(EntityType.WEATHER, EntityTypes.WEATHER)
                    .add(EntityType.WITCH, EntityTypes.WITCH)
                    .add(EntityType.WITHER, EntityTypes.WITHER)
                    .add(EntityType.WITHER_SKULL, EntityTypes.WITHER_SKULL)
                    .add(EntityType.WOLF, EntityTypes.WOLF)
                    .add(EntityType.ZOMBIE, EntityTypes.ZOMBIE)
                    .build();

    public static org.spongepowered.api.entity.EntityType of(org.bukkit.entity.EntityType entityType) {
        return CONVERTER.convert(entityType);
    }

    public static org.bukkit.entity.EntityType of(org.spongepowered.api.entity.EntityType entityType) {
        EntityType bukkitType = CONVERTER.reverse().convert(entityType);
        return bukkitType != null ? bukkitType : EntityType.UNKNOWN;
    }
}
