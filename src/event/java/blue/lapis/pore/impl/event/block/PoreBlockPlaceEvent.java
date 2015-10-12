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
import blue.lapis.pore.impl.block.PoreBlock;
import blue.lapis.pore.impl.entity.PorePlayer;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.spongepowered.api.event.entity.player.PlayerPlaceBlockEvent;

public class PoreBlockPlaceEvent extends org.bukkit.event.block.BlockPlaceEvent {

    private final PlayerPlaceBlockEvent handle;

    public PoreBlockPlaceEvent(PlayerPlaceBlockEvent handle) {
        super(null, null, null, null, null, false);
        this.handle = checkNotNull(handle, "handle");
    }

    public PlayerPlaceBlockEvent getHandle() {
        return handle;
    }

    @Override
    public Block getBlock() {
        return PoreBlock.of(getHandle().getLocation());
    }

    @Override
    public Player getPlayer() {
        return PorePlayer.of(getHandle().getUser());
    }

    @Override
    public Block getBlockPlaced() {
        // TODO: return PoreBlock.of(getHandle().getReplacementBlock());
        throw new NotImplementedException("TODO");
    }

    @Override
    public BlockState getBlockReplacedState() {
        throw new NotImplementedException("TODO"); // TODO
    }

    @Override
    public Block getBlockAgainst() {
        throw new NotImplementedException("TODO"); // TODO
    }

    @Override
    public ItemStack getItemInHand() {
        return ItemStackConverter.of(getHandle().getUser().getItemInHand().orNull());
    }

    @Override
    public boolean canBuild() {
        throw new NotImplementedException("TODO"); // TODO
    }

    @Override
    public void setBuild(boolean canBuild) {
        throw new NotImplementedException("TODO"); // TODO
    }

    @Override
    public boolean isCancelled() {
        return getHandle().isCancelled();
    }

    @Override
    public void setCancelled(boolean cancel) {
        getHandle().setCancelled(cancel);
    }

}
