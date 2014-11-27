package net.amigocraft.pore.implementation.entity.minecart;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.minecart.RideableMinecart;
import org.spongepowered.api.entity.vehicle.minecart.MinecartRideable;

public class PoreRideableMinecart extends PoreMinecart implements RideableMinecart {

	private static TypeConverter<MinecartRideable, PoreRideableMinecart> converter;

	@SuppressWarnings("unchecked")
	public static TypeConverter<MinecartRideable, PoreRideableMinecart> getRideableMinecartConverter() {
		if (converter == null) {
			converter = new TypeConverter<MinecartRideable, PoreRideableMinecart>(){
				@Override
				protected PoreRideableMinecart convert(MinecartRideable handle) {
					return new PoreRideableMinecart(handle);
				}
			};
		}
		return converter;
	}

	protected PoreRideableMinecart(MinecartRideable handle) {
		super(handle);
	}

	@Override
	public MinecartRideable getHandle() {
		return (MinecartRideable)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreRideableMinecart of(MinecartRideable handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.MINECART;
	}

}
