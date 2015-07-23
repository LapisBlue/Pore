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
package blue.lapis.pore.impl.entity;

import blue.lapis.pore.converter.vector.VectorConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.util.Vector;
import org.spongepowered.api.data.manipulator.entity.ExplosiveRadiusData;
import org.spongepowered.api.entity.projectile.explosive.ExplosiveProjectile;

public class PoreFireball extends PoreProjectile implements org.bukkit.entity.Fireball {

    public static PoreFireball of(ExplosiveProjectile handle) {
        return WrapperConverter.of(PoreFireball.class, handle);
    }

    protected PoreFireball(ExplosiveProjectile handle) {
        super(handle);
    }

    @Override
    public ExplosiveProjectile getHandle() {
        return (ExplosiveProjectile) super.getHandle();
    }

    @Override
    public EntityType getType() {
        return EntityType.FIREBALL;
    }

    @Override
    public void setDirection(Vector direction) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Vector getDirection() {
        //TODO: I'm not entirely sure how this method is supposed to behave, so this impl might change
        return VectorConverter.getUnitVector(this.getVelocity()).multiply(0.1);
    }

    @Override
    public float getYield() { // TODO: ???
        return get(ExplosiveRadiusData.class).getExplosionRadius();
    }

    @Override
    public void setYield(float yield) {
        ExplosiveRadiusData data = getOrCreate(ExplosiveRadiusData.class);
        data.setExplosionRadius((int) yield);
        set(data);
    }

    @Override
    public void setIsIncendiary(boolean isIncendiary) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean isIncendiary() {
        throw new NotImplementedException("TODO");
    }
}
