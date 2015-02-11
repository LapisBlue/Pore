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

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.Block;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.spongepowered.api.event.inventory.ItemEvent;

import java.util.List;

public class PorePrepareItemEnchantEvent extends PrepareItemEnchantEvent {

    private final ItemEvent handle;

    public PorePrepareItemEnchantEvent(ItemEvent handle) {
        super(null, null, null, null, null, -1);
        this.handle = checkNotNull(handle, "handle");
    }

    public ItemEvent getHandle() {
        return handle;
    }

    @Override
    public Inventory getInventory() {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public InventoryView getView() {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public List<HumanEntity> getViewers() {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public Player getEnchanter() {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public Block getEnchantBlock() {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public ItemStack getItem() {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public int[] getExpLevelCostsOffered() {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public int getEnchantmentBonus() {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public boolean isCancelled() {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public void setCancelled(boolean cancel) {
        throw new NotImplementedException(); // TODO
    }

}
