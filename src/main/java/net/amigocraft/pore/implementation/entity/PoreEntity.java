package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.implementation.PoreWorld;
import net.amigocraft.pore.implementation.metadata.PoreMetadatable;
import net.amigocraft.pore.util.BukkitVectorFactory;
import net.amigocraft.pore.util.LocationFactory;
import net.amigocraft.pore.util.Vector3dFactory;
import net.amigocraft.pore.util.Vector3fFactory;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;
import org.spongepowered.api.component.attribute.Flammable;
import org.spongepowered.api.component.attribute.Movable;
import org.spongepowered.api.math.Vector3d;
import org.spongepowered.api.util.Identifiable;

import java.util.List;
import java.util.UUID;
import java.util.WeakHashMap;

public class PoreEntity extends PoreMetadatable implements Entity { //TODO: determine if metadata methods should be implemented manually

	private org.spongepowered.api.entity.Entity handle;

	public PoreEntity(org.spongepowered.api.entity.Entity handle) {
		this.handle = handle;
	}

	public org.spongepowered.api.entity.Entity getHandle() {
		return handle;
	}

	@Override
	public Location getLocation() {
		return LocationFactory.fromVector3d(null, this.getHandle().getPosition()); //TODO: fix first parameter when possible
	}

	@Override
	public Location getLocation(Location loc) {
		loc.setWorld(null); //TODO: correct parameter when possible
		loc.setX(this.getHandle().getPosition().getX());
		loc.setY(this.getHandle().getPosition().getX());
		loc.setZ(this.getHandle().getPosition().getX());
		loc.setPitch(this.getHandle().getVectorRotation().getX());
		loc.setYaw(this.getHandle().getVectorRotation().getY());
		return loc;
	}

	@Override
	public void setVelocity(Vector velocity) {
		if (this.getHandle() instanceof Movable){
			((Movable)this.getHandle()).setVelocity(Vector3fFactory.fromBukkitVector(velocity));
		}
		else {
			throw new UnsupportedOperationException("setVelocity called on an entity which is not movable"); // TODO: figure out the proper exception to throw
		}
	}

	@Override
	public Vector getVelocity() {
		if (this.getHandle() instanceof Movable){
			return BukkitVectorFactory.fromVector3f(((Movable)this.getHandle()).getVelocity());
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
		this.getHandle().setPosition(Vector3dFactory.fromLocation(location));
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
		throw new NotImplementedException();
	}

	@Override
	public int getMaxFireTicks() {
		throw new NotImplementedException();
	}

	@Override
	public void setFireTicks(int ticks) {
		if (this.getHandle() instanceof Flammable){
			((Flammable)this.getHandle()).setDuration(ticks);
		}
		else {
			throw new UnsupportedOperationException("setFireTicks called on non-flammable entity!");
		}
	}

	@Override
	public void remove() {
		this.getHandle().remove();
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
		throw new NotImplementedException();
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
		return ((Identifiable)getHandle()).getUniqueId(); //TODO: is this the right way to do this?
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
		throw new NotImplementedException();
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
