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
import static org.spongepowered.api.event.cause.NamedCause.SOURCE;

import blue.lapis.pore.converter.type.world.DirectionConverter;
import blue.lapis.pore.event.PoreEvent;
import blue.lapis.pore.event.PoreEventRegistry;
import blue.lapis.pore.event.RegisterEvent;
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
    private Player player;

    public PorePlayerInteractEvent(T handle) {
        super(null, null, null, null, null);
        this.handle = checkNotNull(handle, "handle");
    }

    @Override
    public T getHandle() {
        return this.handle;
    }

    public final Player getPlayerHandle() {
        if (this.player == null) {
            this.player = this.handle.getCause().get(SOURCE, Player.class).get();
        }

        return this.player;
    }

    @Override
    public org.bukkit.entity.Player getPlayer() {
        return PorePlayer.of(getPlayerHandle());
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
        return getPlayerHandle().getItemInHand().isPresent();
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
        return handle.isCancelled();
    }

    @Override
    public void setCancelled(boolean cancel) {
        handle.setCancelled(cancel);
    }

    @Override
    public String toString() {
        return toStringHelper().toString();
    }

    public static final class Primary extends PorePlayerInteractEvent<InteractBlockEvent.Primary> {

        public Primary(InteractBlockEvent.Primary handle) {
            super(handle);
        }

        @Override
        public Action getAction() {
            return hasBlock() ? Action.LEFT_CLICK_BLOCK : Action.LEFT_CLICK_AIR;
        }

    }

    public static final class Secondary extends PorePlayerInteractEvent<InteractBlockEvent.Secondary> {

        public Secondary(InteractBlockEvent.Secondary handle) {
            super(handle);
        }

        @Override
        public Action getAction() {
            return hasBlock() ? Action.RIGHT_CLICK_BLOCK : Action.RIGHT_CLICK_AIR;
        }

    }

    @RegisterEvent
    public static void register() {
        PoreEventRegistry.registerFor(Primary.class, InteractBlockEvent.Primary.class, event ->
                event.getCause().get(SOURCE, Player.class).isPresent());
        PoreEventRegistry.registerFor(Secondary.class, InteractBlockEvent.Secondary.class, event ->
                event.getCause().get(SOURCE, Player.class).isPresent());
    }

}
