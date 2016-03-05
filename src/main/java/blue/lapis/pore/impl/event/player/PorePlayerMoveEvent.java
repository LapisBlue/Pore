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

import blue.lapis.pore.converter.vector.LocationConverter;
import blue.lapis.pore.event.PoreEvent;
import blue.lapis.pore.event.RegisterEvent;
import blue.lapis.pore.impl.entity.PorePlayer;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;
import org.spongepowered.api.event.entity.DisplaceEntityEvent;

@RegisterEvent
public final class PorePlayerMoveEvent extends PlayerMoveEvent
        implements PoreEvent<DisplaceEntityEvent.Move.TargetPlayer> {

    private final DisplaceEntityEvent.Move.TargetPlayer handle;

    public PorePlayerMoveEvent(DisplaceEntityEvent.Move.TargetPlayer handle) {
        super(null, null, null);
        this.handle = checkNotNull(handle, "handle");
    }

    public DisplaceEntityEvent.Move.TargetPlayer getHandle() {
        return handle;
    }

    @Override
    public Player getPlayer() {
        return PorePlayer.of(getHandle().getTargetEntity());
    }

    @Override
    public Location getFrom() {
        return LocationConverter.fromTransform(getHandle().getFromTransform());
    }

    @Override
    public void setFrom(Location from) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Location getTo() {
        return LocationConverter.fromTransform(getHandle().getToTransform());
    }

    @Override
    public void setTo(Location to) {
        getHandle().setToTransform(LocationConverter.toTransform(to));
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
