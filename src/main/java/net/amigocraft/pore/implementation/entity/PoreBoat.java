package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.Boat;
import org.bukkit.entity.EntityType;

public class PoreBoat extends PoreVehicle implements Boat {

	private static TypeConverter<org.spongepowered.api.entity.vehicle.Boat, PoreBoat> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<org.spongepowered.api.entity.vehicle.Boat, PoreBoat> getBoatConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.entity.vehicle.Boat, PoreBoat>(){
				@Override
				protected PoreBoat convert(org.spongepowered.api.entity.vehicle.Boat handle) {
					return new PoreBoat(handle);
				}
			};
		}
		return converter;
	}

	protected PoreBoat(org.spongepowered.api.entity.vehicle.Boat handle) {
		super(handle);
	}

	@Override
	public org.spongepowered.api.entity.vehicle.Boat getHandle() {
		return (org.spongepowered.api.entity.vehicle.Boat)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreBoat of(org.spongepowered.api.entity.vehicle.Boat handle) {
		return converter.apply(handle);
	}

	//TODO: bridge

	@Override
	public EntityType getType(){
		return EntityType.BOAT;
	}

	@Override
	public double getMaxSpeed() {
		return getHandle().getMaxSpeed();
	}

	@Override
	public void setMaxSpeed(double speed) {
		getHandle().setMaxSpeed(speed);
	}

	@Override
	public double getOccupiedDeceleration() {
		return getHandle().getOccupiedDeceleration();
	}

	@Override
	public void setOccupiedDeceleration(double rate) {
		getHandle().setOccupiedDeceleration(rate);
	}

	@Override
	public double getUnoccupiedDeceleration() {
		return getHandle().getUnoccupiedDeceleration();
	}

	@Override
	public void setUnoccupiedDeceleration(double rate) {
		getHandle().setUnoccupiedDeceleration(rate);
	}

	@Override
	public boolean getWorkOnLand() {
		return getHandle().canMoveOnLand();
	}

	@Override
	public void setWorkOnLand(boolean workOnLand) {
		getHandle().setMoveOnLand(workOnLand);
	}

}
