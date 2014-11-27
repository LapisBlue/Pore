package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.projectile.ThrownExpBottle;

public class PoreThrownExpBottle extends PoreProjectile implements org.bukkit.entity.ThrownExpBottle {

	private static TypeConverter<ThrownExpBottle, PoreThrownExpBottle> converter;

	static TypeConverter<ThrownExpBottle, PoreThrownExpBottle> getThrownExpBottleConverter() {
		if (converter == null) {
			converter = new TypeConverter<ThrownExpBottle, PoreThrownExpBottle>(){
				@Override
				protected PoreThrownExpBottle convert(ThrownExpBottle handle){
					return new PoreThrownExpBottle(handle);
				}
			};
		}
		return converter;
	}

	protected PoreThrownExpBottle(ThrownExpBottle handle) {
		super(handle);
	}

	@Override
	public ThrownExpBottle getHandle() {
		return (ThrownExpBottle)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreThrownExpBottle of(ThrownExpBottle handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.THROWN_EXP_BOTTLE;
	}

}
