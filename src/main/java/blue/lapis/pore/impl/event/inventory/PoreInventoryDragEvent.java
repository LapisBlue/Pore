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
package blue.lapis.pore.impl.event.inventory;

import static com.google.common.base.Preconditions.checkNotNull;

import blue.lapis.pore.impl.inventory.PoreInventory;

import com.google.common.collect.Maps;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.DragType;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.spongepowered.api.event.inventory.InventoryEvent;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class PoreInventoryDragEvent extends InventoryDragEvent {

    private final InventoryEvent handle;

    public PoreInventoryDragEvent(InventoryEvent handle) {
        super(null, null, new ItemStack(Material.DIRT, 1), false, Maps.<Integer, ItemStack>newHashMap());
        this.handle = checkNotNull(handle, "handle");
    }

    public InventoryEvent getHandle() {
        return this.handle;
    }

    @Override
    public Inventory getInventory() {
        return PoreInventory.of(this.getHandle().getInventory());
    }

    @Override
    public List<HumanEntity> getViewers() {
        return this.getInventory().getViewers();
    }

    @Override
    public InventoryView getView() {
        throw new NotImplementedException();
    }

    @Override
    public HumanEntity getWhoClicked() {
        return this.getView().getPlayer();
    }

    @Override
    public Map<Integer, ItemStack> getNewItems() {
        throw new NotImplementedException();
    }

    @Override
    public Set<Integer> getRawSlots() {
        throw new NotImplementedException();
    }

    @Override
    public Set<Integer> getInventorySlots() {
        throw new NotImplementedException();
    }

    @Override
    public ItemStack getCursor() {
        throw new NotImplementedException();
    }

    @Override
    public void setCursor(ItemStack newCursor) {
        throw new NotImplementedException();
    }

    @Override
    public ItemStack getOldCursor() {
        throw new NotImplementedException();
    }

    @Override
    public DragType getType() {
        throw new NotImplementedException();
    }

    @Override
    public Result getResult() {
        throw new NotImplementedException();
    }

    @Override
    public void setResult(Result newResult) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isCancelled() {
        throw new NotImplementedException();
    }

    @Override
    public void setCancelled(boolean cancelled) {
        throw new NotImplementedException();
    }
}
