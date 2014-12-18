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
import net.amigocraft.pore.Pore;
import net.amigocraft.pore.impl.PoreWorld;
import net.amigocraft.pore.util.PoreWrapper;
import net.amigocraft.pore.util.converter.TypeConverter;
import net.amigocraft.pore.util.converter.vector.LocationConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Bukkit;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;
import org.spongepowered.api.Game;
import org.spongepowered.api.entity.EnderCrystal;
import org.spongepowered.api.entity.ExperienceOrb;
import org.spongepowered.api.entity.FallingBlock;
import org.spongepowered.api.entity.Item;
import org.spongepowered.api.entity.explosive.PrimedTNT;
import org.spongepowered.api.entity.hanging.Hanging;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.complex.ComplexLivingPart;
import org.spongepowered.api.entity.projectile.EyeOfEnder;
import org.spongepowered.api.entity.projectile.Firework;
import org.spongepowered.api.entity.projectile.Projectile;
import org.spongepowered.api.entity.weather.Lightning;
import org.spongepowered.api.entity.weather.WeatherEffect;
import org.spongepowered.api.event.entity.EntityDismountEvent;
import org.spongepowered.api.event.entity.EntityMountEvent;
import org.spongepowered.api.util.event.callback.CallbackList;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//TODO: determine if metadata methods should be implemented manually
public class PoreEntity extends PoreWrapper<org.spongepowered.api.entity.Entity> implements Entity {

    private static TypeConverter<org.spongepowered.api.entity.Entity, PoreEntity> converter;

    @SuppressWarnings("unchecked")
    public static TypeConverter<org.spongepowered.api.entity.Entity, PoreEntity> getConverter() {
        if (converter == null) {
            converter = new TypeConverter<org.spongepowered.api.entity.Entity, PoreEntity>(
                    (ImmutableMap) ImmutableMap.builder()
                            .put(ComplexLivingPart.class, PoreComplexEntityPart.getComplexEntityPartConverter())
                            .put(EnderCrystal.class, PoreEnderCrystal.getEnderCrystalConverter())
                            .put(EyeOfEnder.class, PoreEnderSignal.getEnderSignalConverter())
                            .put(ExperienceOrb.class, PoreExperienceOrb.getExperienceOrbConverter())
                            .put(FallingBlock.class, PoreFallingSand.getFallingSandConverter())
                            .put(Firework.class, PoreFirework.getFireworkConverter())
                            .put(Hanging.class, PoreHanging.getHangingConverter())
                            .put(Item.class, PoreItem.getItemConverter())
                            .put(Lightning.class, PoreLightningStrike.getLightningStrikeConverter())
                            .put(Projectile.class, PoreProjectile.getProjectileConverter())
                            .put(PrimedTNT.class, PoreTNTPrimed.getTNTPrimedConverter())
                                    //.put(Entity.class, PoreVehicle.getVehicleConverter())
                            .put(WeatherEffect.class, PoreWeather.getWeatherConverter())
                            .put(Living.class, PoreLivingEntity.getLivingEntityConverter())
                            .build()
            ) {
                @Override
                protected PoreEntity convert(org.spongepowered.api.entity.Entity handle) {
                    return new PoreEntity(handle);
                }
            };
        }

        return converter;
    }

    protected PoreEntity(org.spongepowered.api.entity.Entity handle) {
        super(handle);
    }

    @Override
    public org.spongepowered.api.entity.Entity getHandle() {
        return super.getHandle();
    }

    /**
     * Returns a Pore wrapper for the given handle.
     * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
     *
     * @param handle The Sponge object to wrap.
     * @return A Pore wrapper for the given Sponge object.
     */
    public static PoreEntity of(org.spongepowered.api.entity.Entity handle) {
        return getConverter().apply(handle);
    }

    @Override
    public EntityType getType() {
        return EntityType.UNKNOWN;
    }

    @Override
    public Location getLocation() {
        return LocationConverter.of(getHandle().getLocation()); //TODO: fix first parameter when possible
    }

    @Override
    public Location getLocation(Location loc) {
        loc.setWorld(null); //TODO: correct parameter when possible
        loc.setX(getHandle().getLocation().getPosition().getX());
        loc.setY(getHandle().getLocation().getPosition().getX());
        loc.setZ(getHandle().getLocation().getPosition().getX());
        loc.setPitch(getHandle().getRotation().getX());
        loc.setYaw(getHandle().getRotation().getY());
        return loc;
    }

    @Override
    public void setVelocity(Vector velocity) {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public Vector getVelocity() {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public boolean isOnGround() {
        return getHandle().isOnGround();
    }

    @Override
    public World getWorld() {
        return PoreWorld.of(getHandle().getWorld());
    }

    @Override
    public boolean teleport(Location location) {
        return this.teleport(location, PlayerTeleportEvent.TeleportCause.PLUGIN);
    }

    @Override
    public boolean teleport(Location location, PlayerTeleportEvent.TeleportCause cause) {
        if (this.getPassenger() != null || this.isDead()) {
            return false;
        }
        this.eject();
        getHandle().setLocation(LocationConverter.of(location));
        // CraftBukkit apparently does not throw an event when this method is called
        return true;
    }

    @Override
    public boolean teleport(Entity destination) {
        return this.teleport(destination.getLocation());
    }

    @Override
    public boolean teleport(Entity destination, PlayerTeleportEvent.TeleportCause cause) {
        return this.teleport(destination.getLocation(), cause);
    }

    @Override
    public List<Entity> getNearbyEntities(double x, double y, double z) {
        List<Entity> worldEntities = getWorld().getEntities();
        List<Entity> nearby = new ArrayList<Entity>();
        for (Entity e : worldEntities) {
            Location loc1 = e.getLocation();
            Location loc2 = this.getLocation();
            if (Math.abs(loc1.getX() - loc2.getX()) <= x &&
                    Math.abs(loc1.getY() - loc2.getY()) <= y &&
                    Math.abs(loc1.getZ() - loc2.getZ()) <= z) {
                nearby.add(e);
            }
        }
        return nearby;
    }

    @Override
    public int getEntityId() { // note to self - this is the ID of the entity in the world, and unrelated to
        // its UUID
        throw new NotImplementedException(); //TODO
    }

    @Override
    public int getFireTicks() {
        return getHandle().getFireTicks();
    }

    @Override
    public int getMaxFireTicks() {
        return getHandle().getFireDelay();
    }

    @Override
    public void setFireTicks(int ticks) {
        getHandle().setFireTicks(ticks);
    }

    @Override
    public void remove() {
        getHandle().remove();
    }

    @Override
    public boolean isDead() {
        return getHandle().isRemoved();
    }

    @Override
    public boolean isValid() {
        return getHandle().isLoaded();
    }

    @Override
    public Server getServer() {
        return Bukkit.getServer();
    }

    @Override
    public Entity getPassenger() {
        return getHandle().getPassenger().isPresent() ? PoreEntity.of(getHandle().getPassenger().get()) : null;
    }

    @Override
    public boolean setPassenger(final Entity passenger) {
        if (!getHandle().getPassenger().isPresent()) {
            getHandle().setPassenger(((PoreEntity) passenger).getHandle());
            final PoreEntity mounted = this;
            Pore.getGame().getEventManager().post(new EntityMountEvent() {

                private boolean cancelled = false;

                @Override
                public org.spongepowered.api.entity.Entity getVehicle() {
                    return mounted.getHandle();
                }

                @Override
                public boolean isCancelled() {
                    return cancelled;
                }

                @Override
                public void setCancelled(boolean cancel) {
                    this.cancelled = cancel;
                    if (cancel)
                        mounted.getHandle().setPassenger(null); //TODO: avoid triggering an event
                    else
                        mounted.getHandle().setPassenger(((PoreEntity) passenger).getHandle());
                        //TODO: avoid triggering event
                }

                @Override
                public org.spongepowered.api.entity.Entity getEntity() {
                    return ((PoreEntity) passenger).getHandle();
                }

                @Override
                public Game getGame() {
                    return Pore.getGame();
                }

                @Override
                public CallbackList getCallbacks() {
                    return null; //TODO: determine what to return here
                }
            });
            return true;
        } else if (passenger == null) {
            getHandle().setPassenger(null);
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return !getHandle().getPassenger().isPresent();
    }

    @Override
    public boolean eject() {
        if (getHandle().getPassenger().isPresent()) {
            final org.spongepowered.api.entity.Entity rider = getHandle().getPassenger().get();
            getHandle().setPassenger(null);
            final PoreEntity dismounted = this;
            Pore.getGame().getEventManager().post(new EntityDismountEvent() {

                private boolean cancelled = false;

                @Override
                public org.spongepowered.api.entity.Entity getDismounted() {
                    return dismounted.getHandle();
                }

                @Override
                public boolean isCancelled() {
                    return cancelled;
                }

                @Override
                public void setCancelled(boolean cancel) {
                    this.cancelled = cancel;
                    if (cancel)
                        dismounted.getHandle().setPassenger(rider); //TODO: avoid triggering an event
                    else
                        dismounted.setPassenger(null);
                }

                @Override
                public org.spongepowered.api.entity.Entity getEntity() {
                    return rider;
                }

                @Override
                public Game getGame() {
                    return Pore.getGame();
                }

                @Override
                public CallbackList getCallbacks() {
                    return null; //TODO: determine what to return here
                }
            });
            return true;
        }
        return false;
    }

    @Override
    public float getFallDistance() {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public void setFallDistance(float distance) {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public void setLastDamageCause(EntityDamageEvent event) {
        throw new NotImplementedException(); //TODO: Sponge counterpart planned for 1.1
    }

    @Override
    public EntityDamageEvent getLastDamageCause() {
        throw new NotImplementedException(); //TODO: Sponge counterpart planned for 1.1
    }

    @Override
    public UUID getUniqueId() {
        return getHandle().getUniqueId();
    }

    @Override
    public int getTicksLived() {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public void setTicksLived(int value) {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public void playEffect(EntityEffect type) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isInsideVehicle() {
        return getHandle().getVehicle().isPresent();
    }

    @Override
    public boolean leaveVehicle() {
        if (getHandle().getVehicle().isPresent()) {
            getHandle().setVehicle(null);
            return true;
        }
        return false;
    }

    @Override
    public Entity getVehicle() {
        return getHandle().getVehicle().isPresent() ? PoreEntity.of(getHandle().getVehicle().get()) : null;
    }

    @Override
    public void setCustomName(String name) {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public String getCustomName() {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public void setCustomNameVisible(boolean flag) {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public boolean isCustomNameVisible() {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public void setMetadata(String s, MetadataValue metadataValue) {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public List<MetadataValue> getMetadata(String s) {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public boolean hasMetadata(String s) {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public void removeMetadata(String s, Plugin plugin) {
        throw new NotImplementedException(); //TODO
    }
}
