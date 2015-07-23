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

import blue.lapis.pore.converter.type.entity.EntityConverter;
import blue.lapis.pore.impl.entity.PoreEntity;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.spongepowered.api.event.entity.living.LivingChangeHealthEvent;

public class PoreEntityDamageByEntityEvent extends EntityDamageByEntityEvent {

    private final LivingChangeHealthEvent handle;

    public PoreEntityDamageByEntityEvent(LivingChangeHealthEvent handle) {
        super(null, null, null, -1.0);
        this.handle = checkNotNull(handle, "handle");
        checkState(handle.getCause().isPresent(), "Bad cause");
        checkState(handle.getCause().get().getCause() instanceof org.spongepowered.api.entity.Entity, "Bad cause");
    }

    public LivingChangeHealthEvent getHandle() {
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
    public double getOriginalDamage(DamageModifier type) throws IllegalArgumentException {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setDamage(DamageModifier type, double damage) throws IllegalArgumentException {
        throw new NotImplementedException("TODO");
    }

    @Override
    public double getDamage(DamageModifier type) throws IllegalArgumentException {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean isApplicable(DamageModifier type) throws IllegalArgumentException {
        throw new NotImplementedException("TODO");
    }

    @Override
    public double getDamage() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public double getFinalDamage() {
        return getHandle().getOldData().getHealth() - getHandle().getNewData().getHealth();
    }

    @Override
    public void setDamage(double damage) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public DamageCause getCause() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Entity getDamager() {
        return PoreEntity.of((org.spongepowered.api.entity.Entity) this.getHandle().getCause().get().getCause());
    }

    @Override
    public boolean isCancelled() {
        return this.getHandle().isCancelled();
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.getHandle().setCancelled(cancel);
    }

    @Override
    public boolean isValid() {
        return handle.getCause().isPresent()
                && handle.getCause().get().getCause() instanceof org.spongepowered.api.entity.Entity;
    }

}
