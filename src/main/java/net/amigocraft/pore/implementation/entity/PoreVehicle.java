package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Vehicle;

public abstract class PoreVehicle extends PoreEntity implements Vehicle {

	//TODO: Bridge

	public PoreVehicle(org.spongepowered.api.entity.Entity handle) { //TODO: accept most specfific type
		super(handle);
	}

}
