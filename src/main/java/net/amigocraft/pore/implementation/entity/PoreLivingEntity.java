package net.amigocraft.pore.implementation.entity;

import com.google.common.collect.ImmutableMap;
import net.amigocraft.pore.util.ProjectileUtil;
import net.amigocraft.pore.util.converter.PotionEffectTypeConverter;
import net.amigocraft.pore.util.converter.TypeConverter;
import net.amigocraft.pore.util.converter.vector.LocationFactory;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.ThrownExpBottle;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import org.spongepowered.api.entity.living.Agent;
import org.spongepowered.api.entity.living.Human;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.complex.ComplexLiving;
import org.spongepowered.api.entity.projectile.*;
import org.spongepowered.api.entity.projectile.source.ProjectileSource;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class PoreLivingEntity extends PoreEntity implements LivingEntity {
	private static TypeConverter<Living, PoreLivingEntity> converter;

	@SuppressWarnings("unchecked")
	public static TypeConverter<Living, PoreLivingEntity> getLivingEntityConverter() {
		if (converter == null) {
			converter = new TypeConverter<Living, PoreLivingEntity>(
					(ImmutableMap)ImmutableMap.builder()
							//.put(Living.class, PoreAmbient.getAmbientConverter())
							.put(ComplexLiving.class, PoreComplexLivingEntity.getComplexLivingEntityConverter())
							//.put(Living.class, PoreFlying.getFlyingConverter())
							.put(Human.class, PoreHumanEntity.getHumanEntityConverter())
							.put(Slime.class, PoreSlime.getSlimeConverter())
							.put(Agent.class, PoreCreature.getCreatureConverter())
							.build()
			) {
				@Override
				protected PoreLivingEntity convert(Living handle) {
					return new PoreLivingEntity(handle);
				}
			};
		}

		return converter;
	}

	protected PoreLivingEntity(org.spongepowered.api.entity.living.Living handle) {
		super(handle);
	}

	@Override
	public Living getHandle() {
		return (Living) super.getHandle();
	}

	public static PoreLivingEntity of(Living handle) {
		return getLivingEntityConverter().apply(handle);
	}

	@Override
	public double getEyeHeight() {
		return getHandle().getEyeHeight();
	}

	@Override
	public double getEyeHeight(boolean ignoreSneaking) {
		return getEyeHeight(); // oddly enough, Craftbukkit does the exact same thing
	}

	@Override
	public Location getEyeLocation() {
		return LocationFactory.fromVector3f(getHandle().getWorld(), getHandle().getEyeLocation());
	}

	@Override
	public List<Block> getLineOfSight(HashSet<Byte> transparent, int maxDistance) {
		throw new NotImplementedException(); //TODO
	}

	@Override
	public Block getTargetBlock(HashSet<Byte> transparent, int maxDistance) {
		throw new NotImplementedException(); //TODO
	}

	@Override
	public List<Block> getLastTwoTargetBlocks(HashSet<Byte> transparent, int maxDistance) {
		throw new NotImplementedException(); //TODO
	}

	@Override
	public Egg throwEgg() {
		if (getHandle() instanceof ProjectileSource){
			return PoreEgg.of(
					((ProjectileSource)getHandle()).launchProjectile(
							org.spongepowered.api.entity.projectile.Egg.class
					)
			);
		}
		return null; //TODO: should an UnsupportedOperationException be thrown?
	}

	@Override
	public Snowball throwSnowball() {
		if (getHandle() instanceof ProjectileSource){
			return PoreSnowball.of(
					((ProjectileSource)getHandle()).launchProjectile(
							org.spongepowered.api.entity.projectile.Snowball.class
					)
			);
		}
		return null; //TODO: should an UnsupportedOperationException be thrown?
	}

	@Override
	public Arrow shootArrow() {
		if (getHandle() instanceof ProjectileSource){
			return PoreArrow.of(
					((ProjectileSource)getHandle()).launchProjectile(
							org.spongepowered.api.entity.projectile.Arrow.class
					)
			);
		}
		return null; //TODO: should an UnsupportedOperationException be thrown?
	}

	@Override
	public int getRemainingAir() {
		return getHandle().getRemainingAir();
	}

	@Override
	public void setRemainingAir(int ticks) {
		getHandle().setRemainingAir(ticks);
	}

	@Override
	public int getMaximumAir() {
		return getHandle().getMaxAir();
	}

	@Override
	public void setMaximumAir(int ticks) {
		getHandle().setMaxAir(ticks);
	}

	@Override
	public int getMaximumNoDamageTicks() {
		return getHandle().getMaxInvulnerabilityTicks();
	}

	@Override
	public void setMaximumNoDamageTicks(int ticks) {
		getHandle().setMaxInvulnerabilityTicks(ticks);
	}

	@Override
	public double getLastDamage() {
		return getHandle().getLasDamage();
	}

	@Override
	public int _INVALID_getLastDamage() {
		return (int)this.getLastDamage();
	}

	@Override
	public void setLastDamage(double damage) {
		getHandle().setLastDamage(damage);
	}

	@Override
	public void _INVALID_setLastDamage(int damage) {
		this.setLastDamage((double)damage);
	}

	@Override
	public int getNoDamageTicks() {
		return getHandle().getInvulnerabilityTicks();
	}

	@Override
	public void setNoDamageTicks(int ticks) {
		getHandle().setInvulnerabilityTicks(ticks);
	}

	@Override
	public Player getKiller() {
		throw new NotImplementedException(); //TODO
	}

	@Override
	public boolean addPotionEffect(PotionEffect effect) {
		throw new NotImplementedException(); //TODO: Sponge doesn't seem to have a builder at the moment
	}

	@Override
	public boolean addPotionEffect(PotionEffect effect, boolean force) {
		throw new NotImplementedException(); //TODO
	}

	@Override
	public boolean addPotionEffects(Collection<PotionEffect> effects) {
		throw new NotImplementedException(); //TODO
	}

	@Override
	public boolean hasPotionEffect(PotionEffectType type) {
		for (org.spongepowered.api.potion.PotionEffect effect : getHandle().getPotionEffects()){
			if (effect.getType().equals(PotionEffectTypeConverter.of(type))){
				return true;
			}
		}
		return false;
	}

	@Override
	public void removePotionEffect(PotionEffectType type) {
		for (org.spongepowered.api.potion.PotionEffect effect : getHandle().getPotionEffects()){
			if (effect.getType().equals(PotionEffectTypeConverter.of(type))){
				getHandle().getPotionEffects().remove(effect);
				return;
			}
		}
	}

	@Override
	public Collection<PotionEffect> getActivePotionEffects() {
		throw new NotImplementedException(); //TODO
	}

	@Override
	public boolean hasLineOfSight(Entity other) {
		throw new NotImplementedException(); //TODO
	}

	@Override
	public boolean getRemoveWhenFarAway() {
		throw new NotImplementedException(); //TODO
	}

	@Override
	public void setRemoveWhenFarAway(boolean remove) {
		throw new NotImplementedException(); //TODO
	}

	@Override
	public EntityEquipment getEquipment() {
		throw new NotImplementedException(); //TODO
	}

	@Override
	public void setCanPickupItems(boolean pickup) {
		getHandle().setCanPickupItems(pickup);
	}

	@Override
	public boolean getCanPickupItems() {
		return getHandle().getCanPickupItems();
	}

	@Override
	public void setCustomName(String name) {
		getHandle().setCustomName(name);
	}

	@Override
	public String getCustomName() {
		return getHandle().getCustomName();
	}

	@Override
	public void setCustomNameVisible(boolean flag) {
		getHandle().setCustomNameVisible(flag);
	}

	@Override
	public boolean isCustomNameVisible() {
		return getHandle().isCustomNameVisible();
	}

	@Override
	public boolean isLeashed() {
		return getHandle().isLeashed();
	}

	@Override
	public Entity getLeashHolder() throws IllegalStateException {
		return PoreEntity.of(getHandle().getLeashHolder().get());
	}

	@Override
	public boolean setLeashHolder(Entity holder) {
		if (!(this instanceof Bat) && !(this instanceof EnderDragon) &&
				!(this instanceof Witch) && !(this instanceof Wither)) {
			getHandle().setLeashHolder(((PoreEntity)holder).getHandle());
			return true;
		}
		return false;
	}

	@Override
	public void damage(double amount) {
		getHandle().damage(amount);
	}

	@Override
	public void _INVALID_damage(int amount) {
		getHandle().damage((double)amount);
	}

	@Override
	public void damage(double amount, Entity source) {
		damage(amount); //TODO
	}

	@Override
	public void _INVALID_damage(int amount, Entity source) {
		damage(amount); //TODO
	}

	@Override
	public double getHealth() {
		return getHandle().getHealth();
	}

	@Override
	public int _INVALID_getHealth() {
		return (int)getHandle().getHealth();
	}

	@Override
	public void setHealth(double health) {
		getHandle().setHealth(health);
	}

	@Override
	public void _INVALID_setHealth(int health) {
		getHandle().setHealth(health);
	}

	@Override
	public double getMaxHealth() {
		return getHandle().getMaxHealth();
	}

	@Override
	public int _INVALID_getMaxHealth() {
		return (int)getMaxHealth();
	}

	@Override
	public void setMaxHealth(double health) {
		getHandle().setMaxHealth(health);
	}

	@Override
	public void _INVALID_setMaxHealth(int health) {
		setMaxHealth((double)health);
	}

	@Override
	public void resetMaxHealth() {
		throw new NotImplementedException();
	}

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> projectile) {
		return launchProjectile(projectile, null);
	}

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> projectile, Vector velocity) {
		if (getHandle() instanceof ProjectileSource){
			return ProjectileUtil.launchProjectile((ProjectileSource)getHandle(), projectile, velocity);
		}
		throw new UnsupportedOperationException();
	}
}
