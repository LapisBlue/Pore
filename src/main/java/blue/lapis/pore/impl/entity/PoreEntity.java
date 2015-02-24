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

import blue.lapis.pore.Pore;
import blue.lapis.pore.converter.vector.LocationConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;
import blue.lapis.pore.impl.PoreWorld;
import blue.lapis.pore.util.PoreWrapper;

import com.google.common.collect.Lists;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Bukkit;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;
import org.spongepowered.api.Game;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.entity.EntityDismountEvent;
import org.spongepowered.api.event.entity.EntityMountEvent;
import org.spongepowered.api.util.event.callback.CallbackList;

import java.util.List;
import java.util.Set;
import java.util.UUID;

//TODO: Determine if metadata methods should be implemented manually
public class PoreEntity extends PoreWrapper<Entity> implements org.bukkit.entity.Entity {

    public static PoreEntity of(Entity handle) {
        return WrapperConverter.of(PoreEntity.class, handle);
    }

    protected PoreEntity(Entity handle) {
        super(handle);
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
    public boolean teleport(org.bukkit.entity.Entity destination) {
        return this.teleport(destination.getLocation());
    }

    @Override
    public boolean teleport(org.bukkit.entity.Entity destination, PlayerTeleportEvent.TeleportCause cause) {
        return this.teleport(destination.getLocation(), cause);
    }

    @Override
    public List<org.bukkit.entity.Entity> getNearbyEntities(double x, double y, double z) {
        List<org.bukkit.entity.Entity> worldEntities = getWorld().getEntities();
        List<org.bukkit.entity.Entity> nearby = Lists.newArrayList();
        for (org.bukkit.entity.Entity e : worldEntities) {
            Location loc1 = e.getLocation();
            Location loc2 = this.getLocation();
            if (Math.abs(loc1.getX() - loc2.getX()) <= x
                    && Math.abs(loc1.getY() - loc2.getY()) <= y
                    && Math.abs(loc1.getZ() - loc2.getZ()) <= z) {
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
    public void sendMessage(String message) {

    }

    @Override
    public void sendMessage(String[] messages) {

    }

    @Override
    public Server getServer() {
        return Bukkit.getServer();
    }

    @Override
    public String getName() {
        throw new NotImplementedException();
    }

    @Override
    public org.bukkit.entity.Entity getPassenger() {
        return getHandle().getPassenger().isPresent() ? PoreEntity.of(getHandle().getPassenger().get()) : null;
    }

    @Override
    public boolean setPassenger(final org.bukkit.entity.Entity passenger) {
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
                    if (cancel) {
                        mounted.getHandle().setPassenger(null); //TODO: avoid triggering an event
                    } else {
                        mounted.getHandle().setPassenger(((PoreEntity) passenger).getHandle());
                    }
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
                    if (cancel) {
                        dismounted.getHandle().setPassenger(rider); //TODO: avoid triggering an event
                    } else {
                        dismounted.setPassenger(null);
                    }
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
    public org.bukkit.entity.Entity getVehicle() {
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

    @Override
    public boolean isPermissionSet(String name) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isPermissionSet(Permission perm) {
        throw new NotImplementedException();
    }

    @Override
    public boolean hasPermission(String name) {
        throw new NotImplementedException();
    }

    @Override
    public boolean hasPermission(Permission perm) {
        throw new NotImplementedException();
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
        throw new NotImplementedException();
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin) {
        throw new NotImplementedException();
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
        throw new NotImplementedException();
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
        throw new NotImplementedException();
    }

    @Override
    public void removeAttachment(PermissionAttachment attachment) {
        throw new NotImplementedException();
    }

    @Override
    public void recalculatePermissions() {
        throw new NotImplementedException();
    }

    @Override
    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isOp() {
        return false;
    }

    @Override
    public void setOp(boolean value) {

    }
}
