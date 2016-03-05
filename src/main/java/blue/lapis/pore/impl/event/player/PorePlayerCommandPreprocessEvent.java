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

package blue.lapis.pore.impl.event.player;

import static com.google.common.base.Preconditions.checkNotNull;

import blue.lapis.pore.event.PoreEvent;
import blue.lapis.pore.event.Source;
import blue.lapis.pore.impl.entity.PorePlayer;

import com.google.common.collect.ImmutableSet;
import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.command.SendCommandEvent;

import java.util.Set;

public final class PorePlayerCommandPreprocessEvent extends PlayerCommandPreprocessEvent
        implements PoreEvent<SendCommandEvent> {

    private final SendCommandEvent handle;
    private final Player source;

    public PorePlayerCommandPreprocessEvent(SendCommandEvent handle, @Source Player source) {
        super(null, null, null);
        this.handle = checkNotNull(handle, "handle");
        this.source = checkNotNull(source, "source");
    }

    @Override
    public SendCommandEvent getHandle() {
        return handle;
    }

    @Override
    public org.bukkit.entity.Player getPlayer() {
        return PorePlayer.of(source);
    }

    @Override
    public void setPlayer(org.bukkit.entity.Player player) throws IllegalArgumentException {
        throw new NotImplementedException("TODO"); // TODO
    }

    @Override
    public String getMessage() {
        return getHandle().getCommand();
    }

    @Override
    public void setMessage(String command) throws IllegalArgumentException {
        // TODO
    }

    @Override
    @SuppressWarnings("deprecation")
    public String getFormat() {
        throw new NotImplementedException("TODO"); // TODO
    }

    @Override
    @SuppressWarnings("deprecation")
    public void setFormat(String format) {
        throw new NotImplementedException("TODO"); // TODO
    }

    @Override
    @SuppressWarnings("deprecation")
    public Set<org.bukkit.entity.Player> getRecipients() {
        return ImmutableSet.of();
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

}
