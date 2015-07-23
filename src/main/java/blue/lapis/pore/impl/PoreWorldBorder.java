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
package blue.lapis.pore.impl;

import blue.lapis.pore.converter.vector.LocationConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;
import blue.lapis.pore.util.PoreWrapper;

import org.bukkit.Location;
import org.spongepowered.api.world.WorldBorder;

public class PoreWorldBorder extends PoreWrapper<WorldBorder> implements org.bukkit.WorldBorder {

    // these are all just magic numbers; they don't have any specific significance
    private static final double DEFAULT_SIZE = 6e7;
    private static final double DEFAULT_DAMAGE_AMOUNT = 0.2;
    private static final double DEFAULT_DAMAGE_BUFFER = 5;
    private static final int DEFAULT_WARNING_DISTANCE = 5;
    private static final int DEFAULT_WARNING_TIME = 15;

    private PoreWorld world;

    public static PoreWorldBorder of(WorldBorder handle, PoreWorld world) {
        PoreWorldBorder wb = WrapperConverter.of(PoreWorldBorder.class, handle);
        if (wb != null && wb.world == null) { // not very efficient but I'm not sure there's a cleaner solution
            wb.world = world;
        }
        return wb;
    }

    protected PoreWorldBorder(WorldBorder handle) {
        super(handle);
    }

    @Override
    public void reset() {
        setSize(DEFAULT_SIZE);
        setDamageAmount(DEFAULT_DAMAGE_AMOUNT);
        setDamageBuffer(DEFAULT_DAMAGE_BUFFER);
        setWarningDistance(DEFAULT_WARNING_DISTANCE);
        setWarningTime(DEFAULT_WARNING_TIME);
        setCenter(0, 0);
    }

    @Override
    public double getSize() {
        return getHandle().getDiameter();
    }

    @Override
    public void setSize(double newSize) {
        getHandle().setDiameter(newSize);
    }

    @Override
    public void setSize(double newSize, long seconds) {
        getHandle().setDiameter(newSize, seconds);
    }

    @Override
    public Location getCenter() {
        // this is more efficient than passing the Sponge world and doing a lookup for it
        Location l = LocationConverter.fromVector3d(null, getHandle().getCenter());
        l.setWorld(world);
        return l;
    }

    @Override
    public void setCenter(double x, double z) {
        getHandle().setCenter(x, z);
    }

    @Override
    public void setCenter(Location location) {
        getHandle().setCenter(location.getX(), location.getZ());
    }

    @Override
    public double getDamageBuffer() {
        return getHandle().getDamageThreshold();
    }

    @Override
    public void setDamageBuffer(double blocks) {
        getHandle().setDamageThreshold(blocks);
    }

    @Override
    public double getDamageAmount() {
        return getHandle().getDamageAmount();
    }

    @Override
    public void setDamageAmount(double damage) {
        getHandle().setDamageAmount((int) damage);
    }

    @Override
    public int getWarningTime() {
        return getHandle().getWarningTime();
    }

    @Override
    public void setWarningTime(int seconds) {
        getHandle().setWarningTime(seconds);
    }

    @Override
    public int getWarningDistance() {
        return getHandle().getWarningDistance();
    }

    @Override
    public void setWarningDistance(int distance) {
        getHandle().setWarningDistance(distance);
    }
}
