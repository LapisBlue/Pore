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
package blue.lapis.pore.impl.inventory;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

// TODO: bridge

// TODO: bridge

public class PorePlayerInventory extends PoreInventory implements PlayerInventory {

    @Override
    public ItemStack[] getArmorContents() {
        throw new NotImplementedException();
    }

    @Override
    public ItemStack getHelmet() {
        throw new NotImplementedException();
    }

    @Override
    public ItemStack getChestplate() {
        throw new NotImplementedException();
    }

    @Override
    public ItemStack getLeggings() {
        throw new NotImplementedException();
    }

    @Override
    public ItemStack getBoots() {
        throw new NotImplementedException();
    }

    @Override
    public void setArmorContents(ItemStack[] items) {
        throw new NotImplementedException();
    }

    @Override
    public void setHelmet(ItemStack helmet) {
        throw new NotImplementedException();
    }

    @Override
    public void setChestplate(ItemStack chestplate) {
        throw new NotImplementedException();
    }

    @Override
    public void setLeggings(ItemStack leggings) {
        throw new NotImplementedException();
    }

    @Override
    public void setBoots(ItemStack boots) {
        throw new NotImplementedException();
    }

    @Override
    public ItemStack getItemInHand() {
        throw new NotImplementedException();
    }

    @Override
    public void setItemInHand(ItemStack stack) {
        throw new NotImplementedException();
    }

    @Override
    public int getHeldItemSlot() {
        throw new NotImplementedException();
    }

    @Override
    public void setHeldItemSlot(int slot) {
        throw new NotImplementedException();
    }

    @Override
    public int clear(int id, int data) {
        throw new NotImplementedException();
    }

    @Override
    public Player getHolder() {
        throw new NotImplementedException();
    }
}