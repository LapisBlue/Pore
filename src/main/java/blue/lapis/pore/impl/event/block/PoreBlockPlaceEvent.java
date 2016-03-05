/*
 * Pore
 * Copyright (c) 2014-2016, Lapis <https://github.com/LapisBlue>
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
import static org.spongepowered.api.event.cause.NamedCause.SOURCE;

import blue.lapis.pore.converter.type.material.ItemStackConverter;
import blue.lapis.pore.event.PoreEvent;
import blue.lapis.pore.event.PoreEventRegistry;
import blue.lapis.pore.event.RegisterEvent;
import blue.lapis.pore.impl.block.PoreBlock;
import blue.lapis.pore.impl.block.PoreBlockState;
import blue.lapis.pore.impl.entity.PorePlayer;

import com.google.common.collect.ImmutableList;
import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.block.ChangeBlockEvent;
import org.spongepowered.api.util.GuavaCollectors;

public final class PoreBlockPlaceEvent extends BlockPlaceEvent implements PoreEvent<ChangeBlockEvent.Place> {

    private final ChangeBlockEvent.Place handle;
    private final Player player;
    private final Transaction<BlockSnapshot> transaction;

    public PoreBlockPlaceEvent(ChangeBlockEvent.Place handle, Player player, Transaction<BlockSnapshot> transaction) {
        super(null, null, null, null, null, false);
        this.handle = checkNotNull(handle, "handle");
        this.player = checkNotNull(player, "player");
        this.transaction = checkNotNull(transaction, "transaction");
    }

    @Override
    public ChangeBlockEvent.Place getHandle() {
        return this.handle;
    }

    @Override
    public org.bukkit.entity.Player getPlayer() {
        return PorePlayer.of(this.player);
    }

    @Override
    public Block getBlock() {
        return PoreBlock.of(this.transaction.getOriginal().getLocation().get());
    }

    @Override
    public Block getBlockPlaced() {
        return getBlock();
    }

    @Override
    public BlockState getBlockReplacedState() {
        return PoreBlockState.of(this.transaction.getFinal());
    }

    @Override
    public Block getBlockAgainst() {
        throw new NotImplementedException("TODO"); // TODO
    }

    @Override
    public ItemStack getItemInHand() {
        return ItemStackConverter.of(this.player.getItemInHand().orElse(null));
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
        return !this.transaction.isValid();
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.transaction.setValid(!cancel);
    }

    @Override
    public String toString() {
        return toStringHelper()
                .add("transaction", this.transaction)
                .toString();
    }

    @RegisterEvent
    public static void register() {
        PoreEventRegistry.register(PoreBlockPlaceEvent.class, ChangeBlockEvent.Place.class, event -> {
            Player player = event.getCause().get(SOURCE, Player.class).orElse(null);
            if (player != null) {
                return event.getTransactions().stream()
                        .map(transaction -> new PoreBlockPlaceEvent(event, player, transaction))
                        .collect(GuavaCollectors.toImmutableList());
            } else {
                return ImmutableList.of();
            }
        });
    }

}
