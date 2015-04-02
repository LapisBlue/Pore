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
package blue.lapis.pore.impl.event.entity;

import static com.google.common.base.Preconditions.checkNotNull;

import blue.lapis.pore.converter.type.entity.EntityConverter;
import blue.lapis.pore.converter.vector.LocationConverter;
import blue.lapis.pore.impl.entity.PoreEntity;

import com.google.common.base.Optional;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityPortalExitEvent;
import org.bukkit.util.Vector;
import org.spongepowered.api.event.entity.EntityTeleportEvent;

public class PoreEntityPortalExitEvent extends EntityPortalExitEvent {

    // Sponge's concept of this event seems to be different from Bukkit's, so
    // for now I'm using the teleport event as a handle
    private final EntityTeleportEvent handle;

    private Optional<Location> from = Optional.absent(); // so we can implement the ever-useless setFrom method

    public PoreEntityPortalExitEvent(EntityTeleportEvent handle) {
        super(null, null, null, null, null);
        this.handle = checkNotNull(handle, "handle");
    }

    public EntityTeleportEvent getHandle() {
        return this.handle;
    }

    @Override
    public Entity getEntity() {
        return PoreEntity.of(this.getHandle().getEntity());
    }

    @Override
    public EntityType getEntityType() {
        return EntityConverter.of(this.getHandle().getEntity().getType());
    }

    @Override
    public Location getFrom() {
        return this.from.isPresent() ? this.from.get() : LocationConverter.of(this.getHandle().getOldLocation());
    }

    @Override
    public void setFrom(Location from) {
        this.from = Optional.fromNullable(from);
    }

    @Override
    public Location getTo() {
        return LocationConverter.of(this.getHandle().getNewLocation());
    }

    @Override
    public void setTo(Location to) {
        this.setCancelled(true);
        this.getHandle().getEntity().setLocation(LocationConverter.of(to));
    }

    @Override
    public Vector getBefore() { // eh, this will be tricky to implement
        throw new NotImplementedException(); //TODO
    }

    @Override
    public Vector getAfter() { // WHY DOES SPONGEAPI HAVE NO VELOCITY METHODS
        throw new NotImplementedException(); //TODO
    }

    @Override
    public void setAfter(Vector after) {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public boolean isCancelled() {
        return this.getHandle().isCancelled();
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.getHandle().setCancelled(cancel);
    }
}
