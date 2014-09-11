package net.amigocraft.pore.implementation.entity;

import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import org.spongepowered.api.entity.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

//TODO: bridge
public class PoreLivingEntity extends PoreEntity implements LivingEntity {

	private org.spongepowered.api.entity.LivingEntity handle;

	public PoreLivingEntity(org.spongepowered.api.entity.LivingEntity handle) {
		super(handle);
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
		((org.spongepowered.api.entity.LivingEntity)getHandle()).damage(amount);
	}

	@Override
	public void _INVALID_damage(int amount) {
		((org.spongepowered.api.entity.LivingEntity)getHandle()).damage((double)amount);
	}

	@Override
	public void damage(double amount, Entity source) {

	}

	@Override
	public void _INVALID_damage(int amount, Entity source) {

	}

	@Override
	public double getHealth() {
		return ((org.spongepowered.api.entity.LivingEntity)getHandle()).getHealth();
	}

	@Override
	public int _INVALID_getHealth() {
		return (int)((org.spongepowered.api.entity.LivingEntity)getHandle()).getHealth();
	}

	@Override
	public void setHealth(double health) {
		((org.spongepowered.api.entity.LivingEntity)getHandle()).setHealth(health);
	}

	@Override
	public void _INVALID_setHealth(int health) {
		((org.spongepowered.api.entity.LivingEntity)getHandle()).setHealth(health);
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
