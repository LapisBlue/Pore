package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

//TODO: bridge

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
		throw new NotImplementedException();
	}

	@Override
	public List<Block> getLineOfSight(HashSet<Byte> transparent, int maxDistance) {
		throw new NotImplementedException();
	}

	@Override
	public Block getTargetBlock(HashSet<Byte> transparent, int maxDistance) {
		throw new NotImplementedException();
	}

	@Override
	public List<Block> getLastTwoTargetBlocks(HashSet<Byte> transparent, int maxDistance) {
		throw new NotImplementedException();
	}

	@Override
	public Egg throwEgg() {
		throw new NotImplementedException();
	}

	@Override
	public Snowball throwSnowball() {
		throw new NotImplementedException();
	}

	@Override
	public Arrow shootArrow() {
		throw new NotImplementedException();
	}

	@Override
	public int getRemainingAir() {
		return 0;
	}

	@Override
	public void setRemainingAir(int ticks) {
		throw new NotImplementedException();
	}

	@Override
	public int getMaximumAir() {
		return 0;
	}

	@Override
	public void setMaximumAir(int ticks) {
		throw new NotImplementedException();
	}

	@Override
	public int getMaximumNoDamageTicks() {
		return 0;
	}

	@Override
	public void setMaximumNoDamageTicks(int ticks) {
		throw new NotImplementedException();
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
		throw new NotImplementedException();
	}

	@Override
	public void _INVALID_setLastDamage(int damage) {
		throw new NotImplementedException();
	}

	@Override
	public int getNoDamageTicks() {
		return 0;
	}

	@Override
	public void setNoDamageTicks(int ticks) {
		throw new NotImplementedException();
	}

	@Override
	public Player getKiller() {
		throw new NotImplementedException();
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
		throw new NotImplementedException();
	}

	@Override
	public Collection<PotionEffect> getActivePotionEffects() {
		throw new NotImplementedException();
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
		throw new NotImplementedException();
	}

	@Override
	public EntityEquipment getEquipment() {
		throw new NotImplementedException();
	}

	@Override
	public void setCanPickupItems(boolean pickup) {
		throw new NotImplementedException();
	}

	@Override
	public boolean getCanPickupItems() {
		return false;
	}

	@Override
	public void setCustomName(String name) {
		throw new NotImplementedException();
	}

	@Override
	public String getCustomName() {
		throw new NotImplementedException();
	}

	@Override
	public void setCustomNameVisible(boolean flag) {
		throw new NotImplementedException();
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
		throw new NotImplementedException();
	}

	@Override
	public boolean setLeashHolder(Entity holder) {
		return false;
	}

	// Overrided from Damageable

	@Override
	public void damage(double amount) {
		((org.spongepowered.api.entity.LivingEntity) getHandle()).damage(amount);
	}

	@Override
	public void _INVALID_damage(int amount) {
		((org.spongepowered.api.entity.LivingEntity) getHandle()).damage((double) amount);
	}

	@Override
	public void damage(double amount, Entity source) {
		throw new NotImplementedException();
	}

	@Override
	public void _INVALID_damage(int amount, Entity source) {
		throw new NotImplementedException();
	}

	@Override
	public double getHealth() {
		return ((org.spongepowered.api.entity.LivingEntity) getHandle()).getHealth();
	}

	@Override
	public int _INVALID_getHealth() {
		return (int) ((org.spongepowered.api.entity.LivingEntity) getHandle()).getHealth();
	}

	@Override
	public void setHealth(double health) {
		((org.spongepowered.api.entity.LivingEntity) getHandle()).setHealth(health);
	}

	@Override
	public void _INVALID_setHealth(int health) {
		((org.spongepowered.api.entity.LivingEntity) getHandle()).setHealth(health);
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
		throw new NotImplementedException();
	}

	@Override
	public void _INVALID_setMaxHealth(int health) {
		throw new NotImplementedException();
	}

	@Override
	public void resetMaxHealth() {
		throw new NotImplementedException();
	}

	// Overrided from ProjectileSource
	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> projectile) {
		throw new NotImplementedException();
	}

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> projectile, Vector velocity) {
		throw new NotImplementedException();
	}
}
