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
package blue.lapis.pore.impl.event.enchantment;

import static com.google.common.base.Preconditions.checkNotNull;

import blue.lapis.pore.impl.inventory.PoreInventory;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.spongepowered.api.event.inventory.InventoryEvent;

import java.util.List;
import java.util.Map;

public class PoreEnchantItemEvent extends EnchantItemEvent {

    private final InventoryEvent handle;

    public PoreEnchantItemEvent(InventoryEvent handle) {
        super(null, null, null, null, -1, null, -1);
        this.handle = checkNotNull(handle, "handle");
    }

    public InventoryEvent getHandle() {
        return handle;
    }

    @Override
    public Inventory getInventory() {
        return PoreInventory.of(getHandle().getInventory());
    }

    @Override
    public InventoryView getView() {
        throw new NotImplementedException("TODO"); // TODO
    }

    @Override
    public List<HumanEntity> getViewers() {
        return getInventory().getViewers();
    }

    @Override
    public Player getEnchanter() {
        throw new NotImplementedException("TODO"); // TODO
    }

    @Override
    public Block getEnchantBlock() {
        return (Block)getInventory().getHolder();
    }

    @Override
    public ItemStack getItem() {
        throw new NotImplementedException("TODO"); // TODO
    }

    @Override
    public int getExpLevelCost() {
        throw new NotImplementedException("TODO"); // TODO
    }

    @Override
    public void setExpLevelCost(int level) {
        throw new NotImplementedException("TODO"); // TODO
    }

    @Override
    public Map<Enchantment, Integer> getEnchantsToAdd() {
        throw new NotImplementedException("TODO"); // TODO
    }

    @Override
    public int whichButton() {
        throw new NotImplementedException("TODO"); // TODO
    }

    @Override
    public boolean isCancelled() {
        throw new NotImplementedException("TODO"); // TODO
    }

    @Override
    public void setCancelled(boolean cancel) {
        throw new NotImplementedException("TODO"); // TODO
    }

}
