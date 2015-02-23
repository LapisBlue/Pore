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
import static com.google.common.base.Preconditions.checkState;

import blue.lapis.pore.converter.ItemStackConverter;
import blue.lapis.pore.converter.type.EntityConverter;
import blue.lapis.pore.impl.entity.PoreEntity;
import blue.lapis.pore.impl.entity.PoreLivingEntity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.spongepowered.api.entity.ArmorEquipable;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.event.entity.ProjectileLaunchEvent;

public class PoreEntityShootBowEvent extends EntityShootBowEvent {

    //TODO: no way to cancel this and I'm confused as to what SpongeAPI's getEntity() returns for this event

    private final ProjectileLaunchEvent handle;

    public PoreEntityShootBowEvent(ProjectileLaunchEvent handle) {
        super(null, null, null, -1f);
        this.handle = checkNotNull(handle, "handle");
        checkState(handle.getSource().isPresent(), "No projectile source");
        checkState(handle.getSource().get() instanceof Living, "Bad entity type");
        checkState(handle.getSource().get() instanceof org.spongepowered.api.entity.Entity, "Bad projectile source");
        checkState(handle.getSource().get() instanceof ArmorEquipable, "Bad projectile source");
        checkState(((ArmorEquipable) handle.getSource().get()).getItemInHand().isPresent(), "Bad source itemstack");
    }

    public ProjectileLaunchEvent getHandle() {
        return this.handle;
    }

    @Override
    public LivingEntity getEntity() {
        return PoreLivingEntity.of((Living) this.getHandle().getSource().get());
    }

    @Override
    public EntityType getEntityType() {
        return EntityConverter.of(((Living) this.getHandle().getSource().get()).getType());
    }

    @Override
    public ItemStack getBow() {
        return ItemStackConverter.of(((ArmorEquipable) handle.getSource().get()).getItemInHand().get());
    }

    @Override
    public Entity getProjectile() {
        return PoreEntity.of(this.getHandle().getLaunchedProjectile());
    }

    @Override
    public void setProjectile(Entity projectile) {
        throw new NotImplementedException();
    }

    @Override
    public float getForce() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isCancelled() {
        throw new NotImplementedException();
    }

    @Override
    public void setCancelled(boolean cancel) {
        throw new NotImplementedException();
    }
}
