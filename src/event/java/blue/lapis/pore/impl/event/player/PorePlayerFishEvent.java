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

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fish;
import org.bukkit.entity.Player;
import org.spongepowered.api.event.entity.player.fishing.PlayerFishEvent;

public class PorePlayerFishEvent extends org.bukkit.event.player.PlayerFishEvent {

    private final PlayerFishEvent handle;

    public PorePlayerFishEvent(PlayerFishEvent handle) {
        super(null, null, null, null);
        this.handle = checkNotNull(handle, "handle");
    }

    public PlayerFishEvent getHandle() {
        return handle;
    }

    @Override
    public Player getPlayer() {
        throw new NotImplementedException("TODO"); // TODO
    }

    @Override
    public State getState() {
        throw new NotImplementedException("TODO"); // TODO
    }

    @Override
    public Entity getCaught() {
        throw new NotImplementedException("TODO"); // TODO
    }

    @Override
    @SuppressWarnings("deprecation")
    public Fish getHook() {
        throw new NotImplementedException("TODO"); // TODO
    }

    @Override
    public int getExpToDrop() {
        throw new NotImplementedException("TODO"); // TODO
    }

    @Override
    public void setExpToDrop(int amount) {
        throw new NotImplementedException("TODO"); // TODO
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
