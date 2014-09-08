package net.amigocraft.pore.implementation.entity.minecart;

import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.minecart.HopperMinecart;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.UUID;

/**
 * Created by russjr08 on 9/8/14.
 */
public class PoreHopperMinecart implements HopperMinecart {
    // TODO: Bridge

    // Overrided from Minecart
    @Override
    public void _INVALID_setDamage(int damage) {

    }

    @Override
    public void setDamage(double damage) {

    }

    @Override
    public int _INVALID_getDamage() {
        return 0;
    }

    @Override
    public double getDamage() {
        return 0;
    }

    @Override
    public double getMaxSpeed() {
        return 0;
    }

    @Override
    public void setMaxSpeed(double speed) {

    }

    @Override
    public boolean isSlowWhenEmpty() {
        return false;
    }

    @Override
    public void setSlowWhenEmpty(boolean slow) {

    }

    @Override
    public Vector getFlyingVelocityMod() {
        return null;
    }

    @Override
    public void setFlyingVelocityMod(Vector flying) {

    }

    @Override
    public Vector getDerailedVelocityMod() {
        return null;
    }

    @Override
    public void setDerailedVelocityMod(Vector derailed) {

    }

    // Overrided from Vehicle
    @Override
    public Vector getVelocity() {
        return null;
    }

    @Override
    public void setVelocity(Vector vel) {

    }

    // Overrided from Entity
    @Override
    public Location getLocation() {
        return null;
    }

    @Override
    public Location getLocation(Location loc) {
        return null;
    }

    @Override
    public boolean isOnGround() {
        return false;
    }

    @Override
    public World getWorld() {
        return null;
    }

    @Override
    public boolean teleport(Location location) {
        return false;
    }

    @Override
    public boolean teleport(Location location, PlayerTeleportEvent.TeleportCause cause) {
        return false;
    }

    @Override
    public boolean teleport(Entity destination) {
        return false;
    }

    @Override
    public boolean teleport(Entity destination, PlayerTeleportEvent.TeleportCause cause) {
        return false;
    }

    @Override
    public List<Entity> getNearbyEntities(double x, double y, double z) {
        return null;
    }

    @Override
    public int getEntityId() {
        return 0;
    }

    @Override
    public int getFireTicks() {
        return 0;
    }

    @Override
    public int getMaxFireTicks() {
        return 0;
    }

    @Override
    public void setFireTicks(int ticks) {

    }

    @Override
    public void remove() {

    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public Server getServer() {
        return null;
    }

    @Override
    public Entity getPassenger() {
        return null;
    }

    @Override
    public boolean setPassenger(Entity passenger) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean eject() {
        return false;
    }

    @Override
    public float getFallDistance() {
        return 0;
    }

    @Override
    public void setFallDistance(float distance) {

    }

    @Override
    public void setLastDamageCause(EntityDamageEvent event) {

    }

    @Override
    public EntityDamageEvent getLastDamageCause() {
        return null;
    }

    @Override
    public UUID getUniqueId() {
        return null;
    }

    @Override
    public int getTicksLived() {
        return 0;
    }

    @Override
    public void setTicksLived(int value) {

    }

    @Override
    public void playEffect(EntityEffect type) {

    }

    @Override
    public EntityType getType() {
        return null;
    }

    @Override
    public boolean isInsideVehicle() {
        return false;
    }

    @Override
    public boolean leaveVehicle() {
        return false;
    }

    @Override
    public Entity getVehicle() {
        return null;
    }

    // Overrided from InventoryHolder
    @Override
    public Inventory getInventory() {
        return null;
    }

    // Overrided from Metadatable
    @Override
    public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {

    }

    @Override
    public List<MetadataValue> getMetadata(String metadataKey) {
        return null;
    }

    @Override
    public boolean hasMetadata(String metadataKey) {
        return false;
    }

    @Override
    public void removeMetadata(String metadataKey, Plugin owningPlugin) {

    }
}
