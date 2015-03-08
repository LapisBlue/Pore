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

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.spongepowered.api.event.inventory.InventoryClickEvent;

import java.util.List;

//TODO: this is just a reimplementation of InventoryClickEvent. Should we try to wrap it?
public class PoreInventoryCreativeEvent extends org.bukkit.event.inventory.InventoryCreativeEvent {

    private final InventoryClickEvent handle;

    public PoreInventoryCreativeEvent(InventoryClickEvent handle) {
        super(null, null, -1, null);
        this.handle = checkNotNull(handle, "handle");
    }

    public InventoryClickEvent getHandle() {
        return this.handle;
    }

    @Override
    public Inventory getInventory() {
        return PoreInventory.of(this.getHandle().getContainer());
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
    public Result getResult() {
        throw new NotImplementedException();
    }

    @Override
    public void setResult(Result newResult) {
        throw new NotImplementedException();
    }

    @Override
    public InventoryType.SlotType getSlotType() {
        throw new NotImplementedException();
    }

    @Override
    public ItemStack getCursor() {
        throw new NotImplementedException();
    }

    @Override
    public void setCursor(ItemStack stack) {
        this.getView().setCursor(stack);
    }

    @Override
    public ItemStack getCurrentItem() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isRightClick() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isLeftClick() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isShiftClick() {
        throw new NotImplementedException();
    }

    @Override
    public void setCurrentItem(ItemStack stack) {
        throw new NotImplementedException();
    }

    @Override
    public int getSlot() {
        throw new NotImplementedException();
    }

    @Override
    public int getRawSlot() {
        throw new NotImplementedException();
    }

    @Override
    public int getHotbarButton() {
        throw new NotImplementedException();
    }

    @Override
    public InventoryAction getAction() {
        throw new NotImplementedException();
    }

    @Override
    public ClickType getClick() {
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
