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

package blue.lapis.pore.impl.event.player;

import static com.google.common.base.Preconditions.checkNotNull;

import blue.lapis.pore.converter.type.world.DirectionConverter;
import blue.lapis.pore.event.PoreEvent;
import blue.lapis.pore.event.RegisterEvent;
import blue.lapis.pore.event.Source;
import blue.lapis.pore.impl.block.PoreBlock;
import blue.lapis.pore.impl.entity.PorePlayer;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.block.InteractBlockEvent;

public abstract class PorePlayerInteractEvent<T extends InteractBlockEvent> extends PlayerInteractEvent
        implements PoreEvent<T> {

    private final T handle;
    private final Player player;

    private PorePlayerInteractEvent(T handle, @Source Player player) {
        super(null, null, null, null, null);
        this.handle = checkNotNull(handle, "handle");
        this.player = checkNotNull(player, "player");
    }

    @Override
    public T getHandle() {
        return this.handle;
    }

    @Override
    public org.bukkit.entity.Player getPlayer() {
        return PorePlayer.of(this.player);
    }

    @Override
    public ItemStack getItem() {
        return getPlayer().getItemInHand();
    }

    @Override
    public Material getMaterial() {
        ItemStack item = getItem();
        return item != null ? item.getType() : null;
    }

    @Override
    public boolean hasBlock() {
        return this.handle.getTargetBlock().getState().getType() != BlockTypes.AIR;
    }

    @Override
    public boolean hasItem() {
        return this.player.getItemInHand().isPresent();
    }

    @Override
    public boolean isBlockInHand() {
        Material material = getMaterial();
        return material != null && material.isBlock();
    }

    @Override
    public Block getClickedBlock() {
        return PoreBlock.of(handle.getTargetBlock().getLocation().get());
    }

    @Override
    public BlockFace getBlockFace() {
        return DirectionConverter.of(handle.getTargetSide());
    }

    @Override
    public Result useInteractedBlock() {
        return isCancelled() ? Result.DENY : Result.ALLOW; // TODO: This is kinda wrong
    }

    @Override
    public void setUseInteractedBlock(Result useInteractedBlock) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Result useItemInHand() {
        return isCancelled() ? Result.DENY : Result.ALLOW; // TODO: This is kinda wrong
    }

    @Override
    public void setUseItemInHand(Result useItemInHand) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean isCancelled() {
        return getHandle().isCancelled();
    }

    @Override
    public void setCancelled(boolean cancel) {
        getHandle().setCancelled(cancel);
    }

    @Override
    public String toString() {
        return toStringHelper().toString();
    }

    @RegisterEvent
    public static final class Primary extends PorePlayerInteractEvent<InteractBlockEvent.Primary> {

        public Primary(InteractBlockEvent.Primary handle, @Source Player player) {
            super(handle, player);
        }

        @Override
        public Action getAction() {
            return hasBlock() ? Action.LEFT_CLICK_BLOCK : Action.LEFT_CLICK_AIR;
        }

    }

    @RegisterEvent
    public static final class Secondary extends PorePlayerInteractEvent<InteractBlockEvent.Secondary> {

        public Secondary(InteractBlockEvent.Secondary handle, @Source Player player) {
            super(handle, player);
        }

        @Override
        public Action getAction() {
            return hasBlock() ? Action.RIGHT_CLICK_BLOCK : Action.RIGHT_CLICK_AIR;
        }

    }

}
