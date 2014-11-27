package net.amigocraft.pore.implementation.entity;

import com.google.common.collect.ImmutableMap;
import net.amigocraft.pore.implementation.entity.minecart.PoreMinecart;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.Vehicle;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.vehicle.Boat;
import org.spongepowered.api.entity.vehicle.minecart.Minecart;

public class PoreVehicle extends PoreEntity implements Vehicle {

	// Vehicle has no corresponding interface in Sponge and defines no methods

	private static TypeConverter<Entity, PoreVehicle> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Entity, PoreVehicle> getVehicleConverter() {
		if (converter == null) {
			converter = new TypeConverter<Entity, PoreVehicle>(
					(ImmutableMap)ImmutableMap.builder()
							.put(Boat.class, PoreBoat.getBoatConverter())
							.put(Minecart.class, PoreMinecart.getMinecartConverter())
							.build()
			){
				@Override
				protected PoreVehicle convert(Entity handle) {
					return new PoreVehicle(handle);
				}
			};
		}
		return converter;
	}

	protected PoreVehicle(Entity handle) {
		super(handle);
	}

	@Override
	public Entity getHandle() {
		return (Entity)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreVehicle of(Entity handle) {
		return converter.apply(handle);
	}

}
