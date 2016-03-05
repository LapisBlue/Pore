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

package blue.lapis.pore.impl.entity;

import static org.spongepowered.api.data.manipulator.catalog.CatalogEntityData.CRITICAL_HIT_DATA;
import static org.spongepowered.api.data.manipulator.catalog.CatalogEntityData.KNOCKBACK_DATA;

import blue.lapis.pore.converter.wrapper.WrapperConverter;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.projectile.Arrow;

public class PoreArrow extends PoreProjectile implements org.bukkit.entity.Arrow {

    public static PoreArrow of(Arrow handle) {
        return WrapperConverter.of(PoreArrow.class, handle);
    }

    protected PoreArrow(Arrow handle) {
        super(handle);
    }

    @Override
    public Arrow getHandle() {
        return (Arrow) super.getHandle();
    }

    @Override
    public EntityType getType() {
        return EntityType.ARROW;
    }

    @Override
    public int getKnockbackStrength() {
        return getHandle().get(KNOCKBACK_DATA).isPresent()
                ? getHandle().get(KNOCKBACK_DATA).get().knockbackStrength().get()
                : 0;
    }

    @Override
    public void setKnockbackStrength(int knockbackStrength) {
        getHandle().getOrCreate(KNOCKBACK_DATA).get().knockbackStrength().set(knockbackStrength);
    }

    @Override
    public boolean isCritical() {
        return getHandle().get(CRITICAL_HIT_DATA).isPresent();
    }

    @Override
    public void setCritical(boolean critical) {
        if (critical != isCritical()) {
            if (critical) {
                getHandle().getOrCreate(CRITICAL_HIT_DATA).get().criticalHit().set(true);
            } else {
                getHandle().remove(CRITICAL_HIT_DATA);
            }
        }
    }

    @Override
    public boolean doesBounce() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setBounce(boolean doesBounce) {
        throw new NotImplementedException("TODO");
    }

}
