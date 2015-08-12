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

import blue.lapis.pore.converter.vector.LocationConverter;
import blue.lapis.pore.impl.entity.PoreEntity;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.spongepowered.api.event.world.WorldExplosionEvent;

import java.util.List;

public class PoreEntityExplodeEvent extends EntityExplodeEvent {

    private final WorldExplosionEvent handle;

    public PoreEntityExplodeEvent(WorldExplosionEvent handle) {
        super(null, null, null, -1);
        this.handle = checkNotNull(handle, "handle");
    }

    public WorldExplosionEvent getHandle() {
        return this.handle;
    }

    @Override
    public Entity getEntity() {
        return getHandle().getExplosion().getSourceExplosive().isPresent()
                ? PoreEntity.of(getHandle().getExplosion().getSourceExplosive().get())
                : null;
    }

    @Override
    public EntityType getEntityType() {
        return getEntity() != null ? getEntity().getType() : null;
    }

    @Override
    public List<Block> blockList() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public org.bukkit.Location getLocation() {
        return LocationConverter.fromVector3d(getHandle().getExplosion().getWorld(),
                getHandle().getExplosion().getOrigin());
    }

    @Override
    public float getYield() {
        return this.getHandle().getExplosion().getRadius();
    }

    @Override
    public void setYield(float yield) {
        this.getHandle().getExplosion().setRadius(yield);
    }

    @Override
    public boolean isCancelled() {
        return false; //TODO: Sponge fires this event after the entity has exploded - it can't be cancelled
    }

    @Override
    public void setCancelled(boolean cancel) {
        throw new NotImplementedException("TODO");
    }
}
