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
package net.amigocraft.pore.impl.entity.minecart;

import com.google.common.collect.ImmutableMap;
import net.amigocraft.pore.impl.entity.PoreVehicle;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.material.MaterialData;
import org.bukkit.util.Vector;
import org.spongepowered.api.entity.vehicle.minecart.Minecart;
import org.spongepowered.api.entity.vehicle.minecart.MinecartChest;
import org.spongepowered.api.entity.vehicle.minecart.MinecartCommandBlock;
import org.spongepowered.api.entity.vehicle.minecart.MinecartFurnace;
import org.spongepowered.api.entity.vehicle.minecart.MinecartHopper;
import org.spongepowered.api.entity.vehicle.minecart.MinecartMobSpawner;
import org.spongepowered.api.entity.vehicle.minecart.MinecartRideable;
import org.spongepowered.api.entity.vehicle.minecart.MinecartTNT;

public class PoreMinecart extends PoreVehicle implements org.bukkit.entity.Minecart {

    private static TypeConverter<Minecart, PoreMinecart> converter;

    @SuppressWarnings("unchecked")
    public static TypeConverter<Minecart, PoreMinecart> getMinecartConverter() {
        if (converter == null) {
            converter = new TypeConverter<Minecart, PoreMinecart>(
                    (ImmutableMap) ImmutableMap.builder()
                            .put(MinecartCommandBlock.class, PoreCommandMinecart.getCommandMinecartConverter())
                            .put(MinecartTNT.class, PoreExplosiveMinecart.getExplosiveMinecartConverter())
                            .put(MinecartHopper.class, PoreHopperMinecart.getHopperMinecartConverter())
                            .put(MinecartFurnace.class, PorePoweredMinecart.getPoweredMinecartConverter())
                            .put(MinecartRideable.class, PoreRideableMinecart.getRideableMinecartConverter())
                            .put(MinecartMobSpawner.class, PoreRideableMinecart.getRideableMinecartConverter())
                            .put(MinecartChest.class, PoreStorageMinecart.getStorageMinecartConverter())
                            .build()
            ) {
                @Override
                protected PoreMinecart convert(Minecart handle) {
                    return new PoreMinecart(handle);
                }
            };
        }
        return converter;
    }

    protected PoreMinecart(Minecart handle) {
        super(handle);
    }

    @Override
    public Minecart getHandle() {
        return (Minecart) super.getHandle();
    }

    /**
     * Returns a Pore wrapper for the given handle.
     * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
     *
     * @param handle The Sponge object to wrap.
     * @return A Pore wrapper for the given Sponge object.
     */
    public static PoreMinecart of(Minecart handle) {
        return converter.apply(handle);
    }

    //TODO: bridge

    @Override
    public EntityType getType() {
        return EntityType.MINECART;
    }

    @Override
    public void _INVALID_setDamage(int damage) {
        throw new NotImplementedException();
    }

    @Override
    public void setDamage(double damage) {
        throw new NotImplementedException();
    }

    @Override
    public int _INVALID_getDamage() {
        throw new NotImplementedException();
    }

    @Override
    public double getDamage() {
        throw new NotImplementedException();
    }

    @Override
    public double getMaxSpeed() {
        throw new NotImplementedException();
    }

    @Override
    public void setMaxSpeed(double speed) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isSlowWhenEmpty() {
        throw new NotImplementedException();
    }

    @Override
    public void setSlowWhenEmpty(boolean slow) {
        throw new NotImplementedException();
    }

    @Override
    public Vector getFlyingVelocityMod() {
        throw new NotImplementedException();
    }

    @Override
    public void setFlyingVelocityMod(Vector flying) {
        throw new NotImplementedException();
    }

    @Override
    public Vector getDerailedVelocityMod() {
        throw new NotImplementedException();
    }

    @Override
    public void setDerailedVelocityMod(Vector derailed) {
        throw new NotImplementedException();
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
