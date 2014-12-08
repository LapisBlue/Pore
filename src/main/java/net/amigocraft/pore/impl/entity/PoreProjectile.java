/*
 * Pore
 * Copyright (c) 2014, Maxim Roncacé <http://bitbucket.org/mproncace>
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
import net.amigocraft.pore.impl.projectiles.PoreBlockProjectileSource;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.LivingEntity;
import org.bukkit.projectiles.ProjectileSource;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.projectile.Arrow;
import org.spongepowered.api.entity.projectile.Egg;
import org.spongepowered.api.entity.projectile.EnderPearl;
import org.spongepowered.api.entity.projectile.FishHook;
import org.spongepowered.api.entity.projectile.Projectile;
import org.spongepowered.api.entity.projectile.Snowball;
import org.spongepowered.api.entity.projectile.ThrownExpBottle;
import org.spongepowered.api.entity.projectile.ThrownPotion;
import org.spongepowered.api.entity.projectile.source.BlockProjectileSource;

public class PoreProjectile extends PoreEntity implements org.bukkit.entity.Projectile {

    private static TypeConverter<Projectile, PoreProjectile> converter;

    @SuppressWarnings("unchecked")
    static TypeConverter<Projectile, PoreProjectile> getProjectileConverter() {
        if (converter == null) {
            converter = new TypeConverter<Projectile, PoreProjectile>(
                    (ImmutableMap) ImmutableMap.builder()
                            .put(Arrow.class, PoreArrow.getArrowConverter())
                            .put(Egg.class, PoreEgg.getEggConverter())
                            .put(EnderPearl.class, PoreEnderPearl.getEnderPearlConverter())
                            .put(Fireball.class, PoreFireball.getFireballConverter())
                            .put(FishHook.class, PoreFish.getFishConverter())
                            .put(Snowball.class, PoreSnowball.getSnowballConverter())
                            .put(ThrownExpBottle.class, PoreThrownExpBottle.getThrownExpBottleConverter())
                            .put(ThrownPotion.class, PoreThrownPotion.getThrownPotionConverter())
                            .build()
            ) {
                @Override
                protected PoreProjectile convert(Projectile handle) {
                    return new PoreProjectile(handle);
                }
            };
        }

        return converter;
    }

    protected PoreProjectile(Projectile handle) {
        super(handle);
    }

    @Override
    public Projectile getHandle() {
        return (Projectile) super.getHandle();
    }

    /**
     * Returns a Pore wrapper for the given handle.
     * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
     *
     * @param handle The Sponge object to wrap.
     * @return A Pore wrapper for the given Sponge object.
     */
    public static PoreProjectile of(Projectile handle) {
        return converter.apply(handle);
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
