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

import blue.lapis.pore.converter.PoreConverter;
import blue.lapis.pore.impl.projectiles.PoreBlockProjectileSource;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.LivingEntity;
import org.bukkit.projectiles.ProjectileSource;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.projectile.Projectile;
import org.spongepowered.api.entity.projectile.source.BlockProjectileSource;

public class PoreProjectile extends PoreEntity implements org.bukkit.entity.Projectile {

    public static PoreProjectile of(Projectile handle) {
        return PoreConverter.of(PoreProjectile.class, handle);
    }

    protected PoreProjectile(Projectile handle) {
        super(handle);
    }

    @Override
    public Projectile getHandle() {
        return (Projectile) super.getHandle();
    }

    @Override
    public LivingEntity _INVALID_getShooter() {
        ProjectileSource shooter = getShooter();
        if (shooter instanceof LivingEntity) {
            return PoreLivingEntity.of((Living) shooter);
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public ProjectileSource getShooter() {
        org.spongepowered.api.entity.projectile.source.ProjectileSource source = getHandle().getShooter();
        if (source instanceof BlockProjectileSource) {
            return PoreBlockProjectileSource.of((BlockProjectileSource) source);
        } else if (source instanceof Living) {
            return PoreLivingEntity.of((Living) source);
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public void _INVALID_setShooter(LivingEntity shooter) {
        Living spongeShooter = ((PoreLivingEntity) shooter).getHandle();
        if (spongeShooter instanceof org.spongepowered.api.entity.projectile.source.ProjectileSource) {
            getHandle().setShooter(
                    (org.spongepowered.api.entity.projectile.source.ProjectileSource) spongeShooter);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public void setShooter(ProjectileSource source) {
        if (source instanceof org.bukkit.projectiles.BlockProjectileSource) {
            getHandle().setShooter(((PoreBlockProjectileSource) source).getHandle());
        } else if (source instanceof LivingEntity) {
            Living spongeSource = ((PoreLivingEntity) source).getHandle();
            if (spongeSource instanceof org.spongepowered.api.entity.projectile.source.ProjectileSource) {
                getHandle().setShooter(
                        (org.spongepowered.api.entity.projectile.source.ProjectileSource) spongeSource);
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public boolean doesBounce() {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public void setBounce(boolean doesBounce) {
        throw new NotImplementedException(); //TODO
    }
}
