package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.Bat;
import org.bukkit.entity.EntityType;

public class PoreBat extends PoreAmbient implements Bat {

	private static TypeConverter<org.spongepowered.api.entity.living.Bat, PoreBat> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<org.spongepowered.api.entity.living.Bat, PoreBat> getBatConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.entity.living.Bat, PoreBat>(){
				@Override
				protected PoreBat convert(org.spongepowered.api.entity.living.Bat handle) {
					return new PoreBat(handle);
				}
			};
		}
		return converter;
	}

	protected PoreBat(org.spongepowered.api.entity.living.Bat handle) {
		super(handle);
	}

	@Override
	public org.spongepowered.api.entity.living.Bat getHandle() {
		return (org.spongepowered.api.entity.living.Bat)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreBat of(org.spongepowered.api.entity.living.Bat handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.BAT;
	}

	@Override
	public boolean isAwake() {
		return getHandle().isAwake();
	}

	@Override
	public void setAwake(boolean state) {
		getHandle().setAwake(state);
	}

}
