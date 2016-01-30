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

import static org.spongepowered.api.data.manipulator.catalog.CatalogEntityData.DISPLAY_NAME_DATA;
import static org.spongepowered.api.data.manipulator.catalog.CatalogEntityData.IGNITEABLE_DATA;
import static org.spongepowered.api.data.manipulator.catalog.CatalogEntityData.PASSENGER_DATA;
import static org.spongepowered.api.data.manipulator.catalog.CatalogEntityData.VEHICLE_DATA;

import blue.lapis.pore.converter.vector.LocationConverter;
import blue.lapis.pore.converter.vector.VectorConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;
import blue.lapis.pore.impl.PoreWorld;
import blue.lapis.pore.util.PoreText;
import blue.lapis.pore.util.PoreWrapper;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.NotImplementedException;
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
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.mutable.DisplayNameData;
import org.spongepowered.api.data.manipulator.mutable.entity.IgniteableData;
import org.spongepowered.api.data.manipulator.mutable.entity.PassengerData;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntitySnapshot;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

//TODO: Determine if metadata methods should be implemented manually
public class PoreEntity extends PoreWrapper<Entity> implements org.bukkit.entity.Entity {

    public static PoreEntity of(Entity handle) {
        return WrapperConverter.of(PoreEntity.class, handle);
    }

    public static PoreEntity of(EntitySnapshot snapshot) {
        Optional<UUID> uuid = snapshot.getUniqueId();
        assert uuid.isPresent(); //TODO: not sure if this is right
        Optional<Entity> entity = snapshot.getTransform().get().getExtent().getEntity(uuid.get());
        if (!entity.isPresent()) {
            return null;
        }
        return PoreEntity.of(entity.get());
    }

    protected PoreEntity(Entity handle) {
        super(handle);
    }

    protected <T extends DataManipulator<T, ?>> boolean hasData(Class<T> key) {
        return getHandle().get(key).isPresent();
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
        loc.setWorld(getWorld());
        loc.setX(getHandle().getLocation().getPosition().getX());
        loc.setY(getHandle().getLocation().getPosition().getX());
        loc.setZ(getHandle().getLocation().getPosition().getX());
        loc.setPitch((float) getHandle().getRotation().getX());
        loc.setYaw((float) getHandle().getRotation().getY());
        return loc;
    }

    @Override
    public Vector getVelocity() {
        return getHandle().get(Keys.VELOCITY).map(VectorConverter::createBukkitVector)
                .orElseGet(() -> new Vector(0, 0, 0));
    }

    @Override
    public void setVelocity(Vector velocity) {
        getHandle().offer(Keys.VELOCITY, VectorConverter.create3d(velocity));
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
        if (this.eject()) {
            getHandle().setLocation(LocationConverter.of(location));
            // CraftBukkit apparently does not throw an event when this method is called
            return true;
        }
        return false;
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
        throw new NotImplementedException("TODO");
    }

    @Override
    public int getFireTicks() {
        return hasData(IGNITEABLE_DATA) ? getHandle().get(IGNITEABLE_DATA).get().fireTicks().get() : 0;
    }

    @Override
    public void setFireTicks(int ticks) {
        Optional<IgniteableData> data = getHandle().getOrCreate(IGNITEABLE_DATA);
        if (data.isPresent()) {
            getHandle().offer(data.get().fireTicks().set(ticks));
        } else {
            throw new UnsupportedOperationException("Cannot apply fire ticks to entity with ID " + getEntityId()
                    + " and type " + getType().name());
        }
    }

    @Override
    public int getMaxFireTicks() {
        return hasData(IGNITEABLE_DATA) ? getHandle().get(IGNITEABLE_DATA).get().fireTicks().get() : 0;
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
        //TODO: This isn't implemented in CB for the base entity class. Should we just let it silently fail?
        throw new NotImplementedException("TODO");
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
        throw new NotImplementedException("TODO");
    }

    @Override
    public org.bukkit.entity.Entity getPassenger() {
        return hasData(VEHICLE_DATA) ? PoreEntity.of(getHandle().get(PASSENGER_DATA).get().passenger().get()) : null;
    }

    @Override
    public boolean setPassenger(final org.bukkit.entity.Entity passenger) {
        if (passenger != null) {
            Optional<PassengerData> data = getHandle().getOrCreate(PASSENGER_DATA);
            if (data.isPresent()) {
                getHandle().offer(data.get().passenger().set(((PoreEntity) passenger).getHandle().createSnapshot()));
            } else {
                throw new UnsupportedOperationException("Cannot apply passenger to entity with ID " + getEntityId()
                        + " and type " + getType().name());
            }
        } else {
            getHandle().remove(PASSENGER_DATA);
        }

        return true;
    }

    @Override
    public boolean isEmpty() {
        return hasData(VEHICLE_DATA);
    }

    @Override
    public boolean eject() {
        return setPassenger(null);
    }

    @Override
    public float getFallDistance() {
        return getHandle().get(Keys.FALL_DISTANCE).get();
    }

    @Override
    public void setFallDistance(float distance) {
        getHandle().offer(Keys.FALL_DISTANCE, distance);
    }

    @Override
    public void setLastDamageCause(EntityDamageEvent event) {
        //TODO: Sponge counterpart planned for 1.1
    }

    @Override
    public EntityDamageEvent getLastDamageCause() {
        // TODO: Sponge counterpart planned for 1.1
        return null;
    }

    @Override
    public UUID getUniqueId() {
        return getHandle().getUniqueId();
    }

    @Override
    public int getTicksLived() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setTicksLived(int value) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void playEffect(EntityEffect type) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean isInsideVehicle() {
        return hasData(VEHICLE_DATA);
    }

    @Override
    public boolean leaveVehicle() {
        boolean inVehicle = hasData(VEHICLE_DATA);
        getHandle().remove(VEHICLE_DATA);
        return inVehicle;
    }

    @Override
    public org.bukkit.entity.Entity getVehicle() {
        return isInsideVehicle() ? PoreEntity.of(getHandle().get(VEHICLE_DATA).get().vehicle().get()) : null;
    }

    @Override
    @SuppressWarnings("deprecation")
    public String getCustomName() {
        return hasData(DISPLAY_NAME_DATA)
                ? PoreText.convert(getHandle().get(DISPLAY_NAME_DATA).get().displayName().get())
                : null;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void setCustomName(String name) {
        Optional<DisplayNameData> data = getHandle().getOrCreate(DISPLAY_NAME_DATA);
        if (data.isPresent()) {
            getHandle().offer(data.get().displayName().set(PoreText.convert(name)));
        } else {
            throw new UnsupportedOperationException("Cannot apply display name data to entity with ID " + getEntityId()
                    + " and type " + getType().name());
        }
    }

    @Override
    public boolean isCustomNameVisible() {
        return hasData(DISPLAY_NAME_DATA) && getHandle().get(DISPLAY_NAME_DATA).get().customNameVisible().get();
    }

    @Override
    public void setCustomNameVisible(boolean flag) {
        Optional<DisplayNameData> data = getHandle().getOrCreate(DISPLAY_NAME_DATA);
        if (data.isPresent()) {
            getHandle().offer(data.get().customNameVisible().set(flag));
        } else {
            throw new UnsupportedOperationException("Cannot apply display name data to entity with ID " + getEntityId()
                    + " and type " + getType().name());
        }
    }

    @Override
    public void setMetadata(String s, MetadataValue metadataValue) {
        // TODO
    }

    @Override
    public List<MetadataValue> getMetadata(String s) {
        return ImmutableList.of(); // TODO
    }

    @Override
    public boolean hasMetadata(String s) {
        return false; // TODO
    }

    @Override
    public void removeMetadata(String s, Plugin plugin) {
        // TODO
    }

    @Override
    public boolean isPermissionSet(String name) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean isPermissionSet(Permission perm) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean hasPermission(String name) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean hasPermission(Permission perm) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void removeAttachment(PermissionAttachment attachment) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void recalculatePermissions() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean isOp() {
        return false;
    }

    @Override
    public void setOp(boolean value) {
        // do nothing
    }
}
