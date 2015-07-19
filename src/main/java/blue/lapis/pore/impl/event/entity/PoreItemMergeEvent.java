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
package blue.lapis.pore.impl.event.entity;

import static com.google.common.base.Preconditions.checkNotNull;

import blue.lapis.pore.event.RegisterEvent;
import blue.lapis.pore.impl.entity.PoreItem;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.event.entity.ItemMergeEvent;

@RegisterEvent
public class PoreItemMergeEvent extends ItemMergeEvent {

    private final org.spongepowered.api.event.inventory.ItemMergeEvent handle;

    public PoreItemMergeEvent(org.spongepowered.api.event.inventory.ItemMergeEvent handle) {
        super(null, null);
        this.handle = checkNotNull(handle, "handle");
    }

    public org.spongepowered.api.event.inventory.ItemMergeEvent getHandle() {
        return handle;
    }

    @Override
    public Item getEntity() {
        return PoreItem.of(getHandle().getItem());
    }

    @Override
    public EntityType getEntityType() {
        return getEntity().getType();
    }

    @Override
    public Item getTarget() {
        return PoreItem.of(getHandle().getItemToMerge());
    }

    @Override
    public boolean isCancelled() {
        return getHandle().isCancelled();
    }

    @Override
    public void setCancelled(boolean cancelled) {
        getHandle().setCancelled(cancelled);
    }

}
