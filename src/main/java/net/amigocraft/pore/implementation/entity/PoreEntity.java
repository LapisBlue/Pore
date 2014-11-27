package net.amigocraft.pore.implementation.entity;

import com.google.common.collect.ImmutableMap;
import net.amigocraft.pore.implementation.PoreWorld;
import net.amigocraft.pore.util.*;
import net.amigocraft.pore.util.converter.vector.LocationFactory;
import net.amigocraft.pore.util.converter.TypeConverter;
import net.amigocraft.pore.util.converter.vector.Vector3dFactory;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;
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
					(ImmutableMap)ImmutableMap.builder()
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
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreEntity of(org.spongepowered.api.entity.Entity handle) {
		return getConverter().apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.UNKNOWN;
	}

	@Override
	public Location getLocation() {
		return LocationFactory.fromVector3d(null, getHandle().getPosition()); //TODO: fix first parameter when possible
	}

	@Override
	public Location getLocation(Location loc) {
		loc.setWorld(null); //TODO: correct parameter when possible
		loc.setX(getHandle().getPosition().getX());
		loc.setY(getHandle().getPosition().getX());
		loc.setZ(getHandle().getPosition().getX());
		loc.setPitch(getHandle().getVectorRotation().getX());
		loc.setYaw(getHandle().getVectorRotation().getY());
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
		if (this.getPassenger() != null || this.isDead()){
			return false;
		}
		this.eject();
		getHandle().teleport(Vector3dFactory.fromLocation(location), ((PoreWorld)location.getWorld()).getHandle());
		// Craftbukkit apparently does not throw an event when this method is called
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
		for (Entity e : worldEntities){
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
	public int getEntityId() { // note to self - this is the ID of the entity in the world, and unrelated to its UUID
		throw new NotImplementedException(); //TODO
	}

	@Override
	public int getFireTicks() {
		return getHandle().getFireTicks();
	}

	@Override
	public int getMaxFireTicks() {
		return getHandle().getMaxFireTicks();
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
		return getHandle().isDead();
	}

	@Override
	public boolean isValid() {
		return getHandle().isValid();
	}

	@Override
	public Server getServer() {
		return Bukkit.getServer();
	}

	@Override
	public Entity getPassenger() {
		return PoreEntity.of(getHandle().getRider().get());
	}

	@Override
	public boolean setPassenger(Entity passenger) {
		if (getHandle().getRider().get() == null) {
			((PoreEntity)passenger).getHandle().mount(getHandle());
			return true;
		}
		else if (passenger == null){
			getHandle().eject();
			return true;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return getHandle().getRider().get() == null;
	}

	@Override
	public boolean eject() {
		if (getHandle().getRider().get() != null) {
			getHandle().eject();
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
		return getHandle().getRiding().get() != null;
	}

	@Override
	public boolean leaveVehicle() {
		if (getHandle().getRiding().get() != null) {
			getHandle().dismount();
			return true;
		}
		return false;
	}

	@Override
	public Entity getVehicle() {
		return PoreEntity.of(getHandle().getRiding().get());
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
