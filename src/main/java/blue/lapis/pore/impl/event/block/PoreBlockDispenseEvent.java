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
package blue.lapis.pore.impl.event.block;

import static com.google.common.base.Preconditions.checkNotNull;

import blue.lapis.pore.converter.type.material.ItemStackConverter;
import blue.lapis.pore.converter.vector.VectorConverter;
import blue.lapis.pore.impl.block.PoreBlock;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.spongepowered.api.event.block.BlockDispenseEvent;

public class PoreBlockDispenseEvent extends org.bukkit.event.block.BlockDispenseEvent {

    private final BlockDispenseEvent handle;

    public PoreBlockDispenseEvent(BlockDispenseEvent handle) {
        super(null, null, null);
        this.handle = checkNotNull(handle, "handle");
    }

    public BlockDispenseEvent getHandle() {
        return handle;
    }

    @Override
    public Block getBlock() {
        return PoreBlock.of(getHandle().getBlock());
    }

    @Override
    public ItemStack getItem() {
        return ItemStackConverter.of(getHandle().getDispensedItem());
    }

    @Override
    public void setItem(ItemStack item) {
        getHandle().setDispensedItem(ItemStackConverter.of(item));
    }

    @Override
    public Vector getVelocity() {
        return VectorConverter.createBukkitVector(getHandle().getVelocity());
    }

    @Override
    public void setVelocity(Vector vel) {
        getHandle().setVelocity(VectorConverter.create3d(vel));
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
