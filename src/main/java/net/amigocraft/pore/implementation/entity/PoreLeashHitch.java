package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.hanging.LeashHitch;

public class PoreLeashHitch extends PoreHanging implements org.bukkit.entity.LeashHitch {

	private static TypeConverter<LeashHitch, PoreLeashHitch> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<LeashHitch, PoreLeashHitch> getLeashHitchConverter() {
		if (converter == null) {
			converter = new TypeConverter<LeashHitch, PoreLeashHitch>(){
				@Override
				protected PoreLeashHitch convert(LeashHitch handle) {
					return new PoreLeashHitch(handle);
				}
			};
		}
		return converter;
	}

	protected PoreLeashHitch(LeashHitch handle) {
		super(handle);
	}

	@Override
	public LeashHitch getHandle() {
		return (LeashHitch)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreLeashHitch of(LeashHitch handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.LEASH_HITCH;
	}

}
