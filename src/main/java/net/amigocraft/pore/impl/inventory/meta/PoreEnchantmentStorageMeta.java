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
package net.amigocraft.pore.impl.inventory.meta;

// TODO: bridge

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

import java.util.Map;

public class PoreEnchantmentStorageMeta extends PoreItemMeta implements EnchantmentStorageMeta {
    @Override
    public boolean hasStoredEnchants() {
        throw new NotImplementedException();
    }

    @Override
    public boolean hasStoredEnchant(Enchantment ench) {
        throw new NotImplementedException();
    }

    @Override
    public int getStoredEnchantLevel(Enchantment ench) {
        throw new NotImplementedException();
    }

    @Override
    public Map<Enchantment, Integer> getStoredEnchants() {
        throw new NotImplementedException();
    }

    @Override
    public boolean addStoredEnchant(Enchantment ench, int level, boolean ignoreLevelRestriction) {
        throw new NotImplementedException();
    }

    @Override
    public boolean removeStoredEnchant(Enchantment ench) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public boolean hasConflictingStoredEnchant(Enchantment ench) {
        throw new NotImplementedException();
    }

    @Override
    public EnchantmentStorageMeta clone() {
        throw new NotImplementedException();
    }
}
