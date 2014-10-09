package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Boat;
import org.bukkit.entity.EntityType;

public class PoreBoat extends PoreVehicle implements Boat {

	// TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreBoat(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreBoat of(org.spongepowered.api.entity.Entity handle){
		return (PoreBoat)PoreVehicle.of(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.BOAT;
	}

	@Override
	public double getMaxSpeed() {
		throw new NotImplementedException();
	}

	@Override
	public void setMaxSpeed(double speed) {
		throw new NotImplementedException();
	}

	@Override
	public double getOccupiedDeceleration() {
		throw new NotImplementedException();
	}

	@Override
	public void setOccupiedDeceleration(double rate) {
		throw new NotImplementedException();
	}

	@Override
	public double getUnoccupiedDeceleration() {
		throw new NotImplementedException();
	}

	@Override
	public void setUnoccupiedDeceleration(double rate) {
		throw new NotImplementedException();
	}

	@Override
	public boolean getWorkOnLand() {
		throw new NotImplementedException();
	}

	@Override
	public void setWorkOnLand(boolean workOnLand) {
		throw new NotImplementedException();
	}

}
