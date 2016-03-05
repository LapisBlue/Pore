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

import blue.lapis.pore.event.PoreEvent;
import blue.lapis.pore.event.PoreEventRegistry;
import blue.lapis.pore.event.RegisterEvent;
import blue.lapis.pore.impl.block.PoreBlock;
import blue.lapis.pore.impl.entity.PorePlayer;

import com.google.common.collect.ImmutableList;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.block.ChangeBlockEvent;
import org.spongepowered.api.util.GuavaCollectors;

public final class PoreBlockBreakEvent extends BlockBreakEvent implements PoreEvent<ChangeBlockEvent.Break> {

    private final ChangeBlockEvent.Break handle;
    private final Player player;
    private final Transaction<BlockSnapshot> transaction;

    public PoreBlockBreakEvent(ChangeBlockEvent.Break handle, Player player, Transaction<BlockSnapshot> transaction) {
        super(null, null);
        this.handle = checkNotNull(handle, "handle");
        this.player = checkNotNull(player, "player");
        this.transaction = checkNotNull(transaction, "transaction");
    }

    @Override
    public ChangeBlockEvent.Break getHandle() {
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
    public int getExpToDrop() {
        return 0; // TODO
    }

    @Override
    public void setExpToDrop(int exp) {
        // TODO
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
        PoreEventRegistry.register(PoreBlockBreakEvent.class, ChangeBlockEvent.Break.class, event -> {
            Player player = event.getCause().get(SOURCE, Player.class).orElse(null);
            if (player != null) {
                return event.getTransactions().stream()
                        .map(transaction -> new PoreBlockBreakEvent(event, player, transaction))
                        .collect(GuavaCollectors.toImmutableList());
            } else {
                return ImmutableList.of();
            }
        });
    }

}
