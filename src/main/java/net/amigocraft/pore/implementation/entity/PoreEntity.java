package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.UUID;

public class PoreEntity implements Entity {

	private org.spongepowered.api.entity.Entity handle;

	public PoreEntity(org.spongepowered.api.entity.Entity handle) {
		this.handle = handle;
	}

	public org.spongepowered.api.entity.Entity getHandle() {
		return handle;
	}

	// Overrided from Entity
	@Override
	public Location getLocation() {
		throw new NotImplementedException();
	}

	@Override
	public Location getLocation(Location loc) {
		throw new NotImplementedException();
	}

	@Override
	public void setVelocity(Vector velocity) {
		throw new NotImplementedException();
	}

	@Override
	public Vector getVelocity() {
		throw new NotImplementedException();
	}

	@Override
	public boolean isOnGround() {
		return false;
	}

	@Override
	public World getWorld() {
		throw new NotImplementedException();
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
		throw new NotImplementedException();
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
		throw new NotImplementedException();
	}

	@Override
	public void remove() {
		throw new NotImplementedException();
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
		throw new NotImplementedException();
	}

	@Override
	public Entity getPassenger() {
		throw new NotImplementedException();
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
		return getHandle().getUniqueID();
	}

	@Override
	public int getTicksLived() {
		return 0;
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
		return false;
	}

	@Override
	public boolean leaveVehicle() {
		return false;
	}

	@Override
	public Entity getVehicle() {
		throw new NotImplementedException();
	}

	// Overrided from Metadatable
	@Override
	public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
		throw new NotImplementedException();
	}

	@Override
	public List<MetadataValue> getMetadata(String metadataKey) {
		throw new NotImplementedException();
	}

	@Override
	public boolean hasMetadata(String metadataKey) {
		return false;
	}

	@Override
	public void removeMetadata(String metadataKey, Plugin owningPlugin) {
		throw new NotImplementedException();
	}
}
