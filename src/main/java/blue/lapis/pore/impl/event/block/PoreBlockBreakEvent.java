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

import blue.lapis.pore.impl.block.PoreBlock;
import blue.lapis.pore.impl.entity.PorePlayer;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.spongepowered.api.event.entity.living.player.PlayerBreakBlockEvent;

public class PoreBlockBreakEvent extends BlockBreakEvent {

    private final PlayerBreakBlockEvent handle;

    public PoreBlockBreakEvent(PlayerBreakBlockEvent handle) {
        super(null, null);
        this.handle = checkNotNull(handle, "handle");
    }

    @Override
    public Player getPlayer() {
        return PorePlayer.of(handle.getPlayer());
    }

    @Override
    public Block getBlock() {
        return PoreBlock.of(handle.getBlock());
    }

    @Override
    public int getExpToDrop() {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public void setExpToDrop(int exp) {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public boolean isCancelled() {
        return handle.isCancelled();
    }

    @Override
    public void setCancelled(boolean cancel) {
        handle.setCancelled(cancel);
    }

}
