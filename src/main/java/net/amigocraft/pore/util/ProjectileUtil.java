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
package net.amigocraft.pore.util;

import net.amigocraft.pore.impl.entity.PoreFireball;
import net.amigocraft.pore.util.converter.vector.VectorConverter;
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
import org.spongepowered.api.entity.projectile.source.ProjectileSource;

import javax.annotation.Nullable;

public class ProjectileUtil {

    @SuppressWarnings("unchecked")
    public static <T extends Projectile> T
    launchProjectile(ProjectileSource source, Class<? extends T> projectile, @Nullable Vector velocity) {
        if (projectile.isAssignableFrom(Arrow.class)) {
            return (T) PoreFireball.of(source.launchProjectile(
                    org.spongepowered.api.entity.projectile.Arrow.class,
                    VectorConverter.create3f(velocity)
            ));
        } else if (projectile.isAssignableFrom(Egg.class)) {
            return (T) PoreFireball.of(source.launchProjectile(
                    org.spongepowered.api.entity.projectile.Egg.class,
                    VectorConverter.create3f(velocity)
            ));
        } else if (projectile.isAssignableFrom(EnderPearl.class)) {
            return (T) PoreFireball.of(source.launchProjectile(
                    org.spongepowered.api.entity.projectile.EnderPearl.class,
                    VectorConverter.create3f(velocity)
            ));
        } else if (projectile.isAssignableFrom(Fireball.class)) {
            if (projectile.isAssignableFrom(LargeFireball.class)) {
                return (T) PoreFireball.of(source.launchProjectile(
                        org.spongepowered.api.entity.projectile.fireball.LargeFireball.class,
                        VectorConverter.create3f(velocity)
                ));
            } else if (projectile.isAssignableFrom(LargeFireball.class)) {
                return (T) PoreFireball.of(source.launchProjectile(
                        org.spongepowered.api.entity.projectile.fireball.SmallFireball.class,
                        VectorConverter.create3f(velocity)
                ));
            } else if (projectile.isAssignableFrom(LargeFireball.class)) {
                return (T) PoreFireball.of(source.launchProjectile(
                        org.spongepowered.api.entity.projectile.fireball.WitherSkull.class,
                        VectorConverter.create3f(velocity)
                ));
            } else {
                return (T) PoreFireball.of(source.launchProjectile(
                        org.spongepowered.api.entity.projectile.fireball.Fireball.class,
                        VectorConverter.create3f(velocity)
                ));
            }
        } else if (projectile.isAssignableFrom(Fish.class)) {
            return (T) PoreFireball.of(source.launchProjectile(
                    org.spongepowered.api.entity.projectile.FishHook.class,
                    VectorConverter.create3f(velocity)
            ));
        } else if (projectile.isAssignableFrom(Snowball.class)) {
            return (T) PoreFireball.of(source.launchProjectile(
                    org.spongepowered.api.entity.projectile.Snowball.class,
                    VectorConverter.create3f(velocity)
            ));
        } else if (projectile.isAssignableFrom(ThrownExpBottle.class)) {
            return (T) PoreFireball.of(source.launchProjectile(
                    org.spongepowered.api.entity.projectile.ThrownExpBottle.class,
                    VectorConverter.create3f(velocity)
            ));
        } else if (projectile.isAssignableFrom(ThrownPotion.class)) {
            return (T) PoreFireball.of(source.launchProjectile(
                    org.spongepowered.api.entity.projectile.ThrownPotion.class,
                    VectorConverter.create3f(velocity)
            ));
        }
        throw new UnsupportedOperationException();
    }

}
