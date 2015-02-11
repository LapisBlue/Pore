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
package blue.lapis.pore.util;

import blue.lapis.pore.Pore;
import blue.lapis.pore.converter.vector.VectorConverter;
import blue.lapis.pore.impl.entity.PoreFireball;
import blue.lapis.pore.impl.entity.PoreProjectile;

import com.google.common.base.Optional;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Fish;
import org.bukkit.entity.LargeFireball;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.ThrownExpBottle;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.util.Vector;
import org.spongepowered.api.Game;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.projectile.source.ProjectileSource;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.entity.ProjectileLaunchEvent;
import org.spongepowered.api.util.event.callback.CallbackList;

import javax.annotation.Nullable;

public class ProjectileUtil {

    @SuppressWarnings("unchecked")
    public static <T extends Projectile> T
    launchProjectile(ProjectileSource source, Class<? extends T> projectile, @Nullable Vector velocity) {
        T entity = null;
        if (projectile.isAssignableFrom(Arrow.class)) {
            entity = (T)PoreFireball.of(source.launchProjectile(
                    org.spongepowered.api.entity.projectile.Arrow.class,
                    VectorConverter.create3f(velocity)
            ));
        } else if (projectile.isAssignableFrom(Egg.class)) {
            entity = (T)PoreFireball.of(source.launchProjectile(
                    org.spongepowered.api.entity.projectile.Egg.class,
                    VectorConverter.create3f(velocity)
            ));
        } else if (projectile.isAssignableFrom(EnderPearl.class)) {
            entity = (T)PoreFireball.of(source.launchProjectile(
                    org.spongepowered.api.entity.projectile.EnderPearl.class,
                    VectorConverter.create3f(velocity)
            ));
        } else if (projectile.isAssignableFrom(Fireball.class)) {
            if (projectile.isAssignableFrom(LargeFireball.class)) {
                entity = (T)PoreFireball.of(source.launchProjectile(
                        org.spongepowered.api.entity.projectile.fireball.LargeFireball.class,
                        VectorConverter.create3f(velocity)
                ));
            } else if (projectile.isAssignableFrom(LargeFireball.class)) {
                entity = (T)PoreFireball.of(source.launchProjectile(
                        org.spongepowered.api.entity.projectile.fireball.SmallFireball.class,
                        VectorConverter.create3f(velocity)
                ));
            } else if (projectile.isAssignableFrom(LargeFireball.class)) {
                entity = (T)PoreFireball.of(source.launchProjectile(
                        org.spongepowered.api.entity.projectile.fireball.WitherSkull.class,
                        VectorConverter.create3f(velocity)
                ));
            } else {
                entity = (T)PoreFireball.of(source.launchProjectile(
                        org.spongepowered.api.entity.projectile.fireball.Fireball.class,
                        VectorConverter.create3f(velocity)
                ));
            }
        } else if (projectile.isAssignableFrom(Fish.class)) {
            entity = (T)PoreFireball.of(source.launchProjectile(
                    org.spongepowered.api.entity.projectile.FishHook.class,
                    VectorConverter.create3f(velocity)
            ));
        } else if (projectile.isAssignableFrom(Snowball.class)) {
            entity = (T)PoreFireball.of(source.launchProjectile(
                    org.spongepowered.api.entity.projectile.Snowball.class,
                    VectorConverter.create3f(velocity)
            ));
        } else if (projectile.isAssignableFrom(ThrownExpBottle.class)) {
            entity = (T)PoreFireball.of(source.launchProjectile(
                    org.spongepowered.api.entity.projectile.ThrownExpBottle.class,
                    VectorConverter.create3f(velocity)
            ));
        } else if (projectile.isAssignableFrom(ThrownPotion.class)) {
            entity = (T)PoreFireball.of(source.launchProjectile(
                    org.spongepowered.api.entity.projectile.ThrownPotion.class,
                    VectorConverter.create3f(velocity)
            ));
        }
        if (entity == null) throw new UnsupportedOperationException();
        final T finalEntity = entity;
        Pore.getGame().getEventManager().post(new ProjectileLaunchEvent() {
            @Override
            public org.spongepowered.api.entity.projectile.Projectile getLaunchedProjectile() {
                throw new UnsupportedOperationException(); // TODO
            }

            @Override
            public Optional<ProjectileSource> getSource() {
                throw new UnsupportedOperationException(); // TODO
            }

            @Override
            public Optional<Cause> getCause() {
                return Optional.of(null); //TODO: cause
            }

            @Override
            public Entity getEntity() {
                return ((PoreProjectile)finalEntity).getHandle(); //TODO: verify this cast is safe
            }

            @Override
            public Game getGame() {
                return Pore.getGame();
            }

            @Override
            public CallbackList getCallbacks() {
                return null; //TODO: not sure exactly of what to return here
            }
        });
        return entity;
    }

}
