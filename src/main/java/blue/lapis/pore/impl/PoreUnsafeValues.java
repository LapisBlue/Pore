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

package blue.lapis.pore.impl;

import blue.lapis.pore.Pore;
import blue.lapis.pore.converter.type.material.MaterialConverter;
import blue.lapis.pore.converter.type.statistic.AchievementConverter;
import blue.lapis.pore.converter.type.statistic.StatisticConverter;

import com.google.common.collect.Iterables;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.UnsafeValues;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.StringUtil;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.statistic.achievement.Achievement;

import java.util.List;
import java.util.Optional;

@Deprecated
@SuppressWarnings("deprecation")
public class PoreUnsafeValues implements UnsafeValues {

    @SuppressWarnings("deprecation")
    protected static final UnsafeValues INSTANCE = new PoreUnsafeValues();

    @Override
    public Material getMaterialFromInternalName(String name) {
        Optional<BlockType> block = Pore.getGame().getRegistry().getType(BlockType.class, name); //TODO is this right?
        Optional<ItemType> item = Pore.getGame().getRegistry().getType(ItemType.class, name); //TODO is this right?
        if (block.isPresent()) {
            return MaterialConverter.of(block.get());
        } else if (item.isPresent()) {
            return MaterialConverter.of(item.get());
        } else {
            return null;
        }
    }

    @Override
    public List<String> tabCompleteInternalMaterialName(String token, List<String> completions) {
        return StringUtil.copyPartialMatches(
                token,
                Iterables.transform(Pore.getGame().getRegistry().getAllOf(ItemType.class), //TODO is this right?
                        CatalogType::getId),
                completions
        );
    }

    @Override
    public ItemStack modifyItemStack(ItemStack stack, String arguments) throws UnsupportedOperationException {
        /*
         * TODO: this is a very evil method which happens to require access to
         * NBT data. I propose we throw an UnsupportedOperationException and
         * modify Porekit to rewrite any calls to it since this class isn't
         * supported anyway.
         * - caseif
         *
         * Update: I went ahead and did it. Feel free to yell at me on IRC if
         * you think this was a bad idea.
         * - caseif
         */
        //throw new UnsupportedOperationException("Pore does not support direct NBT manipulation at this time");
        return stack;
        // TODO: Some plugins use this, and break completely in that case
        // Simply doing nothing here kind of fixes it, at least it does nothing in that case
    }

    @Override
    public Statistic getStatisticFromInternalName(String name) {
        //TODO: maybe search block and entity stats too if they're not encompassed
        //TODO is this right?
        Optional<org.spongepowered.api.statistic.Statistic> stat =
                Pore.getGame().getRegistry().getType(org.spongepowered.api.statistic.Statistic.class, name);
        if (stat.isPresent()) {
            return StatisticConverter.of(stat.get());
        } else {
            return null;
        }
    }

    @Override
    public org.bukkit.Achievement getAchievementFromInternalName(String name) {
        Optional<Achievement> ach = Pore.getGame().getRegistry().getType(Achievement.class, name); //TODO is this right?
        if (ach.isPresent()) {
            return AchievementConverter.of(ach.get());
        } else {
            return null;
        }
    }

    @Override
    public List<String> tabCompleteInternalStatisticOrAchievementName(String token, List<String> completions) {
        List<String> found = StringUtil.copyPartialMatches(
                token,
                Iterables.transform(Pore.getGame().getRegistry().getAllOf(Achievement.class), //TODO is this right?
                        CatalogType::getName),
                completions
        );
        found.addAll(StringUtil.copyPartialMatches(
                token,
                Iterables.transform(
                        Pore.getGame().getRegistry().getAllOf(org.spongepowered.api.statistic.Statistic.class),
                        CatalogType::getName), //TODO is this right?
                completions
        ));
        return found;
    }
}
