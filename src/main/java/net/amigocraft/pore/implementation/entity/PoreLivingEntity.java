package net.amigocraft.pore.implementation.entity;

import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;



public class PoreLivingEntity extends PoreEntity implements LivingEntity {
    // TODO: Bridge

    // Overrided from Entity

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

    // Overrided from LivingEntity


    @Override
    public double getEyeHeight() {
        return 0;
    }

    @Override
    public double getEyeHeight(boolean ignoreSneaking) {
        return 0;
    }

    @Override
    public Location getEyeLocation() {
        return null;
    }

    @Override
    public List<Block> getLineOfSight(HashSet<Byte> transparent, int maxDistance) {
        return null;
    }

    @Override
    public Block getTargetBlock(HashSet<Byte> transparent, int maxDistance) {
        return null;
    }

    @Override
    public List<Block> getLastTwoTargetBlocks(HashSet<Byte> transparent, int maxDistance) {
        return null;
    }

    @Override
    public Egg throwEgg() {
        return null;
    }

    @Override
    public Snowball throwSnowball() {
        return null;
    }

    @Override
    public Arrow shootArrow() {
        return null;
    }

    @Override
    public int getRemainingAir() {
        return 0;
    }

    @Override
    public void setRemainingAir(int ticks) {

    }

    @Override
    public int getMaximumAir() {
        return 0;
    }

    @Override
    public void setMaximumAir(int ticks) {

    }

    @Override
    public int getMaximumNoDamageTicks() {
        return 0;
    }

    @Override
    public void setMaximumNoDamageTicks(int ticks) {

    }

    @Override
    public double getLastDamage() {
        return 0;
    }

    @Override
    public int _INVALID_getLastDamage() {
        return 0;
    }

    @Override
    public void setLastDamage(double damage) {

    }

    @Override
    public void _INVALID_setLastDamage(int damage) {

    }

    @Override
    public int getNoDamageTicks() {
        return 0;
    }

    @Override
    public void setNoDamageTicks(int ticks) {

    }

    @Override
    public Player getKiller() {
        return null;
    }

    @Override
    public boolean addPotionEffect(PotionEffect effect) {
        return false;
    }

    @Override
    public boolean addPotionEffect(PotionEffect effect, boolean force) {
        return false;
    }

    @Override
    public boolean addPotionEffects(Collection<PotionEffect> effects) {
        return false;
    }

    @Override
    public boolean hasPotionEffect(PotionEffectType type) {
        return false;
    }

    @Override
    public void removePotionEffect(PotionEffectType type) {

    }

    @Override
    public Collection<PotionEffect> getActivePotionEffects() {
        return null;
    }

    @Override
    public boolean hasLineOfSight(Entity other) {
        return false;
    }

    @Override
    public boolean getRemoveWhenFarAway() {
        return false;
    }

    @Override
    public void setRemoveWhenFarAway(boolean remove) {

    }

    @Override
    public EntityEquipment getEquipment() {
        return null;
    }

    @Override
    public void setCanPickupItems(boolean pickup) {

    }

    @Override
    public boolean getCanPickupItems() {
        return false;
    }

    @Override
    public void setCustomName(String name) {

    }

    @Override
    public String getCustomName() {
        return null;
    }

    @Override
    public void setCustomNameVisible(boolean flag) {

    }

    @Override
    public boolean isCustomNameVisible() {
        return false;
    }

    @Override
    public boolean isLeashed() {
        return false;
    }

    @Override
    public Entity getLeashHolder() throws IllegalStateException {
        return null;
    }

    @Override
    public boolean setLeashHolder(Entity holder) {
        return false;
    }

    // Overrided from Damageable

    @Override
    public void damage(double amount) {

    }

    @Override
    public void _INVALID_damage(int amount) {

    }

    @Override
    public void damage(double amount, Entity source) {

    }

    @Override
    public void _INVALID_damage(int amount, Entity source) {

    }

    @Override
    public double getHealth() {
        return 0;
    }

    @Override
    public int _INVALID_getHealth() {
        return 0;
    }

    @Override
    public void setHealth(double health) {

    }

    @Override
    public void _INVALID_setHealth(int health) {

    }

    @Override
    public double getMaxHealth() {
        return 0;
    }

    @Override
    public int _INVALID_getMaxHealth() {
        return 0;
    }

    @Override
    public void setMaxHealth(double health) {

    }

    @Override
    public void _INVALID_setMaxHealth(int health) {

    }

    @Override
    public void resetMaxHealth() {

    }

    // Overrided from ProjectileSource
    @Override
    public <T extends Projectile> T launchProjectile(Class<? extends T> projectile) {
        return null;
    }

    @Override
    public <T extends Projectile> T launchProjectile(Class<? extends T> projectile, Vector velocity) {
        return null;
    }
}
