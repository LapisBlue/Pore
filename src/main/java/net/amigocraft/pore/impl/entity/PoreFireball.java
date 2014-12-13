/*
 * Pore
 * Copyright (c) 2014, Lapis <https://github.com/LapisBlue>
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
package net.amigocraft.pore.impl.entity;

import com.google.common.collect.ImmutableMap;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.util.Vector;
import org.spongepowered.api.entity.projectile.fireball.LargeFireball;
import org.spongepowered.api.entity.projectile.fireball.SmallFireball;
import org.spongepowered.api.entity.projectile.fireball.WitherSkull;

public class PoreFireball extends PoreProjectile implements Fireball {

    private static TypeConverter<org.spongepowered.api.entity.projectile.fireball.Fireball, PoreFireball>
            converter;

    @SuppressWarnings("unchecked")
    static TypeConverter<org.spongepowered.api.entity.projectile.fireball.Fireball, PoreFireball>
    getFireballConverter() {
        if (converter == null) {
            converter =
                    new TypeConverter<org.spongepowered.api.entity.projectile.fireball.Fireball, PoreFireball>(
                            (ImmutableMap) ImmutableMap.builder()
                                    .put(LargeFireball.class, PoreLargeFireball.getLargeFireballConverter())
                                    .put(SmallFireball.class, PoreSmallFireball.getSmallFireballConverter())
                                    .put(WitherSkull.class, PoreWitherSkull.getWitherSkullConverter())
                                    .build()
                    ) {
                        @Override
                        protected PoreFireball convert(
                                org.spongepowered.api.entity.projectile.fireball.Fireball handle) {
                            return new PoreFireball(handle);
                        }
                    };
        }
        return converter;
    }

    protected PoreFireball(org.spongepowered.api.entity.projectile.fireball.Fireball handle) {
        super(handle);
    }

    @Override
    public org.spongepowered.api.entity.projectile.fireball.Fireball getHandle() {
        return (org.spongepowered.api.entity.projectile.fireball.Fireball) super.getHandle();
    }

    /**
     * Returns a Pore wrapper for the given handle.
     * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
     *
     * @param handle The Sponge object to wrap.
     * @return A Pore wrapper for the given Sponge object.
     */
    public static PoreFireball of(org.spongepowered.api.entity.projectile.fireball.Fireball handle) {
        return converter.apply(handle);
    }

    //TODO: bridge

    @Override
    public EntityType getType() {
        return EntityType.FIREBALL;
    }

    @Override
    public void setDirection(Vector direction) {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public Vector getDirection() {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public void setYield(float yield) {
        throw new NotImplementedException();
    }

    @Override
    public float getYield() {
        throw new NotImplementedException();
    }

    @Override
    public void setIsIncendiary(boolean isIncendiary) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isIncendiary() {
        throw new NotImplementedException();
    }
}
