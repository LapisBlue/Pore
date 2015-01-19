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
package blue.lapis.pore.impl.entity.minecart;

import blue.lapis.pore.impl.entity.PoreVehicle;
import blue.lapis.pore.util.converter.PoreConverter;
import blue.lapis.pore.util.converter.vector.VectorConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.material.MaterialData;
import org.bukkit.util.Vector;
import org.spongepowered.api.entity.vehicle.minecart.Minecart;

public class PoreMinecart extends PoreVehicle implements org.bukkit.entity.Minecart {

    public static PoreMinecart of(Minecart handle) {
        return PoreConverter.of(PoreMinecart.class, handle);
    }

    protected PoreMinecart(Minecart handle) {
        super(handle);
    }

    @Override
    public Minecart getHandle() {
        return (Minecart) super.getHandle();
    }

    @Override
    public EntityType getType() {
        return EntityType.MINECART;
    }

    @Override
    public void _INVALID_setDamage(int damage) {
        this.setDamage((double)damage);
    }

    @Override
    public void setDamage(double damage) {
        throw new NotImplementedException();
    }

    @Override
    public int _INVALID_getDamage() {
        return (int)this.getDamage();
    }

    @Override
    public double getDamage() {
        throw new NotImplementedException();
    }

    @Override
    public double getMaxSpeed() {
        return getHandle().getSwiftness();
    }

    @Override
    public void setMaxSpeed(double speed) {
        getHandle().setSwiftness(speed);
    }

    @Override
    public boolean isSlowWhenEmpty() {
        return getHandle().doesSlowWhenEmpty();
    }

    @Override
    public void setSlowWhenEmpty(boolean slow) {
        getHandle().setSlowWhenEmpty(slow);
    }

    @Override
    public Vector getFlyingVelocityMod() {
        return VectorConverter.createBukkitVector(getHandle().getAirborneVelocityMod());
    }

    @Override
    public void setFlyingVelocityMod(Vector flying) {
        getHandle().setAirborneVelocityMod(VectorConverter.create3d(flying));
    }

    @Override
    public Vector getDerailedVelocityMod() {
        return VectorConverter.createBukkitVector(getHandle().getDerailedVelocityMod());
    }

    @Override
    public void setDerailedVelocityMod(Vector derailed) {
        getHandle().setDerailedVelocityMod(VectorConverter.create3d(derailed));
    }

    @Override
    public MaterialData getDisplayBlock() {
        throw new NotImplementedException();
    }

    @Override
    public void setDisplayBlock(MaterialData material) {
        throw new NotImplementedException();
    }

    @Override
    public int getDisplayBlockOffset() {
        throw new NotImplementedException();
    }

    @Override
    public void setDisplayBlockOffset(int offset) {
        throw new NotImplementedException();
    }
}
