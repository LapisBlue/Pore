package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.Main;
import net.amigocraft.pore.implementation.metadata.PoreMetadatable;
import net.amigocraft.pore.util.*;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.*;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.util.Vector;
import org.spongepowered.api.component.attribute.Flammable;
import org.spongepowered.api.component.attribute.Movable;
import org.spongepowered.api.util.Identifiable;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class PoreEntity extends PoreMetadatable implements Entity { //TODO: determine if metadata methods should be implemented manually

	protected org.spongepowered.api.entity.Entity handle;

	private static CsvMap typeMap = new CsvMap();

	static {
		try {
			typeMap.load(PoreEntity.class.getResourceAsStream("s2b-map.csv"), "s2b-map.csv");
		}
		catch (IOException ex){
			ex.printStackTrace();
			Main.logger.fatal("Failed to load entity class mappings!");
		}
	}

	private static final Cache<org.spongepowered.api.entity.Entity, PoreEntity> CACHE = new Cache<org.spongepowered.api.entity.Entity, PoreEntity>() {
		@Override
		protected PoreEntity construct(org.spongepowered.api.entity.Entity spongeObject) {
			try {
				return (PoreEntity)Class.forName(typeMap.get(spongeObject.getClass().getCanonicalName().replace(".", "/")))
						.getMethod("of", org.spongepowered.api.entity.Entity.class).invoke(spongeObject);
			}
			catch (Exception ex) {
				PoreEntity wrapper = new PoreEntity(spongeObject);
				return wrapper;
			}
		}
	};

	protected PoreEntity(org.spongepowered.api.entity.Entity handle) {
		this.handle = handle;
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreEntity of(org.spongepowered.api.entity.Entity handle) {
		return CACHE.get(handle);
	}

	@Override
	public Location getLocation() {
		return LocationFactory.fromVector3d(null, handle.getPosition()); //TODO: fix first parameter when possible
	}

	@Override
	public Location getLocation(Location loc) {
		loc.setWorld(null); //TODO: correct parameter when possible
		loc.setX(handle.getPosition().getX());
		loc.setY(handle.getPosition().getX());
		loc.setZ(handle.getPosition().getX());
		loc.setPitch(handle.getVectorRotation().getX());
		loc.setYaw(handle.getVectorRotation().getY());
		return loc;
	}

	@Override
	public void setVelocity(Vector velocity) {
		if (handle instanceof Movable){
			((Movable)handle).setVelocity(Vector3fFactory.fromBukkitVector(velocity));
		}
		else {
			throw new UnsupportedOperationException("setVelocity called on an entity which is not movable"); // TODO: figure out the proper exception to throw
		}
	}

	@Override
	public Vector getVelocity() {
		if (handle instanceof Movable){
			return BukkitVectorFactory.fromVector3f(((Movable)handle).getVelocity());
		}
		else {
			throw new UnsupportedOperationException("getVelocity called on an entity which is not movable"); // TODO: figure out the proper exception to throw
		}
	}

	@Override
	public boolean isOnGround() {
		throw new NotImplementedException();
	}

	@Override
	public World getWorld() {
		throw new NotImplementedException();
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
		handle.setPosition(Vector3dFactory.fromLocation(location));
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
		throw new NotImplementedException();
	}

	@Override
	public int getEntityId() { // note to self - this is unique to Bukkit and not the same as a unique ID
		throw new NotImplementedException();
	}

	@Override
	public int getFireTicks() {
		if (handle instanceof Flammable){
			return ((Flammable)handle).getDuration();
		}
		else {
			throw new UnsupportedOperationException("getFireTicks called on non-flammable entity");
		}
	}

	@Override
	public int getMaxFireTicks() {
		throw new NotImplementedException();
	}

	@Override
	public void setFireTicks(int ticks) {
		if (handle instanceof Flammable){
			((Flammable)handle).setDuration(ticks);
		}
		else {
			throw new UnsupportedOperationException("setFireTicks called on non-flammable entity");
		}
	}

	@Override
	public void remove() {
		handle.remove();
	}

	@Override
	public boolean isDead() {
		throw new NotImplementedException(); //TODO: determine how to implement this for non-living entities
	}

	@Override
	public boolean isValid() {
		throw new NotImplementedException();
	}

	@Override
	public Server getServer() {
		return Bukkit.getServer();
	}

	@Override
	public Entity getPassenger() {
		throw new NotImplementedException();
	}

	@Override
	public boolean setPassenger(Entity passenger) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isEmpty() {
		throw new NotImplementedException();
	}

	@Override
	public boolean eject() {
		throw new NotImplementedException();
	}

	@Override
	public float getFallDistance() {
		throw new NotImplementedException();
	}

	@Override
	public void setFallDistance(float distance) {
		throw new NotImplementedException();
	}

	@Override
	public void setLastDamageCause(EntityDamageEvent event) {
		throw new NotImplementedException();
	}

	@Override
	public EntityDamageEvent getLastDamageCause() {
		throw new NotImplementedException();
	}

	@Override
	public UUID getUniqueId() {
		return ((Identifiable)handle).getUniqueId(); //TODO: is this the right way to do this?
	}

	@Override
	public int getTicksLived() {
		throw new NotImplementedException();
	}

	@Override
	public void setTicksLived(int value) {
		throw new NotImplementedException();
	}

	@Override
	public void playEffect(EntityEffect type) {
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType() {
		return EntityType.UNKNOWN; // this will almost always be overridden
	}

	@Override
	public boolean isInsideVehicle() {
		throw new NotImplementedException();
	}

	@Override
	public boolean leaveVehicle() {
		throw new NotImplementedException();
	}

	@Override
	public Entity getVehicle() {
		throw new NotImplementedException();
	}

}
