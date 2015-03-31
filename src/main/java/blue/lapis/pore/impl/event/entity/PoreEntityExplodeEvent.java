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

import blue.lapis.pore.converter.type.EntityConverter;
import blue.lapis.pore.converter.vector.LocationConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;
import blue.lapis.pore.impl.block.PoreBlock;
import blue.lapis.pore.impl.entity.PoreEntity;
import blue.lapis.pore.util.PoreCollections;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.spongepowered.api.event.entity.EntityExplosionEvent;
import org.spongepowered.api.world.Location;

import java.util.List;

public class PoreEntityExplodeEvent extends EntityExplodeEvent {

    private final EntityExplosionEvent handle;

    public PoreEntityExplodeEvent(EntityExplosionEvent handle) {
        super(null, null, null, -1);
        this.handle = checkNotNull(handle, "handle");
    }

    public EntityExplosionEvent getHandle() {
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
    public List<Block> blockList() {
        return PoreCollections.<Location, Block>transformToList(
                this.getHandle().getBlocks(),
                WrapperConverter.<Location, PoreBlock>getConverter()
        );
    }

    @Override
    public org.bukkit.Location getLocation() {
        return LocationConverter.of(this.getHandle().getExplosionLocation());
    }

    @Override
    public float getYield() {
        return (float) this.getHandle().getYield();
    }

    @Override
    public void setYield(float yield) {
        this.getHandle().setYield(yield);
    }

    @Override
    public boolean isCancelled() {
        return false; //TODO: Sponge fires this event after the entity has exploded - it can't be cancelled
    }

    @Override
    public void setCancelled(boolean cancel) {
        throw new NotImplementedException();
    }
}
