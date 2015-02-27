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

import blue.lapis.pore.impl.block.PoreBlock;

import com.google.common.base.Preconditions;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.spongepowered.api.event.block.BlockEvent;

public class PoreBlockDamageEvent extends BlockDamageEvent {

    private final BlockEvent handle;

    public PoreBlockDamageEvent(BlockEvent handle) {
        super(null, null, null, false);
        this.handle = Preconditions.checkNotNull(handle, "handle");
    }

    public BlockEvent getHandle() {
        return handle;
    }

    @Override
    public Block getBlock() {
        return PoreBlock.of(getHandle().getBlock());
    }

    @Override
    public Player getPlayer() {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public ItemStack getItemInHand() {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public boolean getInstaBreak() {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public void setInstaBreak(boolean bool) {
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
