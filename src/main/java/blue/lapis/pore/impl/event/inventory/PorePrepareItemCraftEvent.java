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
import static com.google.common.base.Preconditions.checkState;

import blue.lapis.pore.impl.inventory.PoreCraftingInventory;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.Recipe;
import org.spongepowered.api.event.inventory.InventoryEvent;
import org.spongepowered.api.item.inventory.crafting.CraftingInventory;

import java.util.List;

public class PorePrepareItemCraftEvent extends PrepareItemCraftEvent {

    private final InventoryEvent handle;

    public PorePrepareItemCraftEvent(InventoryEvent handle) {
        super(null, null, false);
        this.handle = checkNotNull(handle, "handle");
        checkState(handle.getInventory() instanceof CraftingInventory, "Bad inventory type");
    }

    public InventoryEvent getHandle() {
        return this.handle;
    }

    @Override
    public org.bukkit.inventory.CraftingInventory getInventory() {
        return PoreCraftingInventory.of((CraftingInventory)this.getHandle().getInventory());
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
    public Recipe getRecipe() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isRepair() {
        throw new NotImplementedException();
    }
}
