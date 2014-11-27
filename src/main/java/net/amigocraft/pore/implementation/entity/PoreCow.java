package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.Cow;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.living.animal.Mooshroom;

public class PoreCow extends PoreAnimals implements Cow {

	private static TypeConverter<org.spongepowered.api.entity.living.animal.Cow, PoreCow> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<org.spongepowered.api.entity.living.animal.Cow, PoreCow> getCowConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.entity.living.animal.Cow, PoreCow>(
					Mooshroom.class, PoreMushroomCow.getMushroomCowConverter()
			){
				@Override
				protected PoreCow convert(org.spongepowered.api.entity.living.animal.Cow handle) {
					return new PoreCow(handle);
				}
			};
		}
		return converter;
	}

	protected PoreCow(org.spongepowered.api.entity.living.animal.Cow handle) {
		super(handle);
	}

	@Override
	public org.spongepowered.api.entity.living.animal.Cow getHandle() {
		return (org.spongepowered.api.entity.living.animal.Cow)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreCow of(org.spongepowered.api.entity.living.animal.Cow handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.COW;
	}

}
