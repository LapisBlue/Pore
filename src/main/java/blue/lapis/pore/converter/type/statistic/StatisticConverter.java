/*
 * Pore
 * Copyright (c) 2014-2016, Lapis <https://github.com/LapisBlue>
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

package blue.lapis.pore.converter.type.statistic;

import blue.lapis.pore.converter.type.TypeConverter;

import com.google.common.base.Converter;
import org.bukkit.Statistic;
import org.spongepowered.api.statistic.StatisticGroups;
import org.spongepowered.api.statistic.Statistics;

public final class StatisticConverter {

    private StatisticConverter() {
    }

    public static final Converter<Statistic, org.spongepowered.api.statistic.Statistic> STD_CONVERTER =
            TypeConverter.builder(Statistic.class, org.spongepowered.api.statistic.Statistic.class)
                    .add(Statistic.ANIMALS_BRED, Statistics.ANIMALS_BRED)
                    .add(Statistic.ARMOR_CLEANED, Statistics.ARMOR_CLEANED)
                    .add(Statistic.BANNER_CLEANED, Statistics.BANNER_CLEANED)
                    .add(Statistic.BEACON_INTERACTION, Statistics.BEACON_INTERACTION)
                    .add(Statistic.BOAT_ONE_CM, Statistics.BOAT_DISTANCE)
                    .add(Statistic.BREWINGSTAND_INTERACTION, Statistics.BREWINGSTAND_INTERACTION)
                    .add(Statistic.CAKE_SLICES_EATEN, Statistics.CAKE_SLICES_EATEN)
                    .add(Statistic.CAULDRON_FILLED, Statistics.CAULDRON_FILLED)
                    .add(Statistic.CAULDRON_USED, Statistics.CAULDRON_USED)
                    .add(Statistic.CHEST_OPENED, Statistics.CHEST_OPENED)
                    .add(Statistic.CLIMB_ONE_CM, Statistics.CLIMB_DISTANCE)
                    .add(Statistic.CRAFTING_TABLE_INTERACTION, Statistics.CRAFTING_TABLE_INTERACTION)
                    .add(Statistic.CROUCH_ONE_CM, Statistics.CROUCH_DISTANCE)
                    .add(Statistic.DAMAGE_DEALT, Statistics.DAMAGE_DEALT)
                    .add(Statistic.DAMAGE_TAKEN, Statistics.DAMAGE_TAKEN)
                    .add(Statistic.DEATHS, Statistics.DEATHS)
                    .add(Statistic.DISPENSER_INSPECTED, Statistics.DISPENSER_INSPECTED)
                    .add(Statistic.DIVE_ONE_CM, Statistics.DIVE_DISTANCE)
                    .add(Statistic.DROP, Statistics.ITEMS_DROPPED)
                    .add(Statistic.DROPPER_INSPECTED, Statistics.DROPPER_INSPECTED)
                    .add(Statistic.ENDERCHEST_OPENED, Statistics.ENDERCHEST_OPENED)
                    .add(Statistic.FALL_ONE_CM, Statistics.FALL_DISTANCE)
                    .add(Statistic.FISH_CAUGHT, Statistics.FISH_CAUGHT)
                    .add(Statistic.FLOWER_POTTED, Statistics.FLOWER_POTTED)
                    .add(Statistic.FLY_ONE_CM, Statistics.FLY_DISTANCE)
                    .add(Statistic.FURNACE_INTERACTION, Statistics.FURNACE_INTERACTION)
                    .add(Statistic.HOPPER_INSPECTED, Statistics.HOPPER_INSPECTED)
                    .add(Statistic.HORSE_ONE_CM, Statistics.HORSE_DISTANCE)
                    .add(Statistic.ITEM_ENCHANTED, Statistics.ITEMS_ENCHANTED)
                    .add(Statistic.JUMP, Statistics.JUMP)
                    .add(Statistic.JUNK_FISHED, Statistics.JUNK_FISHED)
                    .add(Statistic.LEAVE_GAME, Statistics.LEAVE_GAME)
                    .add(Statistic.MINECART_ONE_CM, Statistics.MINECART_DISTANCE)
                    .add(Statistic.MOB_KILLS, Statistics.MOB_KILLS)
                    .add(Statistic.NOTEBLOCK_PLAYED, Statistics.NOTEBLOCK_PLAYED)
                    .add(Statistic.NOTEBLOCK_TUNED, Statistics.NOTEBLOCK_TUNED)
                    .add(Statistic.PIG_ONE_CM, Statistics.PIG_DISTANCE)
                    .add(Statistic.PLAYER_KILLS, Statistics.PLAYER_KILLS)
                    .add(Statistic.PLAY_ONE_TICK, Statistics.TIME_PLAYED)
                    .add(Statistic.RECORD_PLAYED, Statistics.RECORD_PLAYED)
                    .add(Statistic.SPRINT_ONE_CM, Statistics.SPRINT_DISTANCE)
                    .add(Statistic.SWIM_ONE_CM, Statistics.SWIM_DISTANCE)
                    .add(Statistic.TALKED_TO_VILLAGER, Statistics.TALKED_TO_VILLAGER)
                    .add(Statistic.TIME_SINCE_DEATH, Statistics.TIME_SINCE_DEATH)
                    .add(Statistic.TRADED_WITH_VILLAGER, Statistics.TRADED_WITH_VILLAGER)
                    .add(Statistic.TRAPPED_CHEST_TRIGGERED, Statistics.TRAPPED_CHEST_TRIGGERED)
                    .add(Statistic.TREASURE_FISHED, Statistics.TREASURE_FISHED)
                    .add(Statistic.WALK_ONE_CM, Statistics.WALK_DISTANCE)
                    .build();

    public static final Converter<Statistic, org.spongepowered.api.statistic.StatisticGroup> GROUP_CONVERTER =
            TypeConverter.builder(Statistic.class, org.spongepowered.api.statistic.StatisticGroup.class)
                    .add(Statistic.BREAK_ITEM, StatisticGroups.BREAK_ITEM)
                    .add(Statistic.CRAFT_ITEM, StatisticGroups.CRAFT_ITEM)
                    .add(Statistic.ENTITY_KILLED_BY, StatisticGroups.KILLED_BY_ENTITY)
                    .add(Statistic.KILL_ENTITY, StatisticGroups.HAS_KILLED_ENTITY)
                    .add(Statistic.MINE_BLOCK, StatisticGroups.MINE_BLOCK)
                    .add(Statistic.USE_ITEM, StatisticGroups.USE_ITEM)
                    .build();

    public static org.spongepowered.api.statistic.Statistic asStdStat(Statistic statistic) {
        return STD_CONVERTER.convert(statistic);
    }

    public static org.spongepowered.api.statistic.StatisticGroup asGroupStat(Statistic statistic) {
        return GROUP_CONVERTER.convert(statistic);
    }

    public static Statistic of(org.spongepowered.api.statistic.Statistic statistic) {
        return STD_CONVERTER.reverse().convert(statistic);
    }

    public static Statistic of(org.spongepowered.api.statistic.StatisticGroup statistic) {
        return GROUP_CONVERTER.reverse().convert(statistic);
    }
}
