package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Vehicle;

public abstract class PoreVehicle extends PoreEntity implements Vehicle {

	//TODO: make constructor as specific as possible
	protected PoreVehicle(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreVehicle of(org.spongepowered.api.entity.Entity handle){
		return (PoreVehicle)PoreEntity.of(handle);
	}

}
