package net.amigocraft.pore.implementation.entity;

import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.UUID;

/**
 * Created by russjr08 on 9/8/14.
 */
public abstract class PoreLivingEntity extends PoreEntity implements LivingEntity {
    // TODO: Bridge

    // Overrided from LivingEntity

    @Override
    public Location getLocation() {
        return super.getLocation();
    }

    @Override
    public Location getLocation(Location loc) {
        return super.getLocation(loc);
    }

    @Override
    public void setVelocity(Vector velocity) {
        super.setVelocity(velocity);
    }

    @Override
    public Vector getVelocity() {
        return super.getVelocity();
    }

    @Override
    public boolean isOnGround() {
        return super.isOnGround();
    }

    @Override
    public World getWorld() {
        return super.getWorld();
    }

    @Override
    public boolean teleport(Location location) {
        return super.teleport(location);
    }

    @Override
    public boolean teleport(Location location, PlayerTeleportEvent.TeleportCause cause) {
        return super.teleport(location, cause);
    }

    @Override
    public boolean teleport(Entity destination) {
        return super.teleport(destination);
    }

    @Override
    public boolean teleport(Entity destination, PlayerTeleportEvent.TeleportCause cause) {
        return super.teleport(destination, cause);
    }

    @Override
    public List<Entity> getNearbyEntities(double x, double y, double z) {
        return super.getNearbyEntities(x, y, z);
    }

    @Override
    public int getEntityId() {
        return super.getEntityId();
    }

    @Override
    public int getFireTicks() {
        return super.getFireTicks();
    }

    @Override
    public int getMaxFireTicks() {
        return super.getMaxFireTicks();
    }

    @Override
    public void setFireTicks(int ticks) {
        super.setFireTicks(ticks);
    }

    @Override
    public void remove() {
        super.remove();
    }

    @Override
    public boolean isDead() {
        return super.isDead();
    }

    @Override
    public boolean isValid() {
        return super.isValid();
    }

    @Override
    public Server getServer() {
        return super.getServer();
    }

    @Override
    public Entity getPassenger() {
        return super.getPassenger();
    }

    @Override
    public boolean setPassenger(Entity passenger) {
        return super.setPassenger(passenger);
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public boolean eject() {
        return super.eject();
    }

    @Override
    public float getFallDistance() {
        return super.getFallDistance();
    }

    @Override
    public void setFallDistance(float distance) {
        super.setFallDistance(distance);
    }

    @Override
    public void setLastDamageCause(EntityDamageEvent event) {
        super.setLastDamageCause(event);
    }

    @Override
    public EntityDamageEvent getLastDamageCause() {
        return super.getLastDamageCause();
    }

    @Override
    public UUID getUniqueId() {
        return super.getUniqueId();
    }

    @Override
    public int getTicksLived() {
        return super.getTicksLived();
    }

    @Override
    public void setTicksLived(int value) {
        super.setTicksLived(value);
    }

    @Override
    public void playEffect(EntityEffect type) {
        super.playEffect(type);
    }

    @Override
    public EntityType getType() {
        return super.getType();
    }

    @Override
    public boolean isInsideVehicle() {
        return super.isInsideVehicle();
    }

    @Override
    public boolean leaveVehicle() {
        return super.leaveVehicle();
    }

    @Override
    public Entity getVehicle() {
        return super.getVehicle();
    }

    @Override
    public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
        super.setMetadata(metadataKey, newMetadataValue);
    }

    @Override
    public List<MetadataValue> getMetadata(String metadataKey) {
        return super.getMetadata(metadataKey);
    }

    @Override
    public boolean hasMetadata(String metadataKey) {
        return super.hasMetadata(metadataKey);
    }

    @Override
    public void removeMetadata(String metadataKey, Plugin owningPlugin) {
        super.removeMetadata(metadataKey, owningPlugin);
    }
}
