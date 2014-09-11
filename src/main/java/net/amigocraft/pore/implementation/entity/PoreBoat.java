package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Boat;

public class PoreBoat extends PoreVehicle implements Boat {

	// TODO: Bridge

	public PoreBoat(org.spongepowered.api.entity.Entity handle) { //TODO: accept most specfific type
		super(handle);
	}

	@Override
	public double getMaxSpeed() {
		return 0;
	}

	@Override
	public void setMaxSpeed(double speed) {

	}

	@Override
	public double getOccupiedDeceleration() {
		return 0;
	}

	@Override
	public void setOccupiedDeceleration(double rate) {

	}

	@Override
	public double getUnoccupiedDeceleration() {
		return 0;
	}

	@Override
	public void setUnoccupiedDeceleration(double rate) {

	}

	@Override
	public boolean getWorkOnLand() {
		return false;
	}

	@Override
	public void setWorkOnLand(boolean workOnLand) {

	}

}
