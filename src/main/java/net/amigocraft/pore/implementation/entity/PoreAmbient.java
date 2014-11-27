package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.Ambient;
import org.spongepowered.api.entity.living.Bat;
import org.spongepowered.api.entity.living.Living;

public class PoreAmbient extends PoreLivingEntity implements Ambient {

	private static TypeConverter<Living, PoreAmbient> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Living, PoreAmbient> getAmbientConverter() {
		if (converter == null) {
			converter = new TypeConverter<Living, PoreAmbient>(
					Bat.class, PoreBat.getBatConverter()
			){
				@Override
				protected PoreAmbient convert(Living handle) {
					return new PoreAmbient(handle);
				}
			};
		}
		return converter;
	}

	//TODO: bridge

	protected PoreAmbient(Living handle) {
		super(handle);
	}

	@Override
	public Living getHandle() {
		return (Living)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreAmbient of(org.spongepowered.api.entity.living.Ageable handle) {
		return converter.apply(handle);
	}

}
