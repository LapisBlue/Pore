package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.MushroomCow;
import org.spongepowered.api.entity.living.animal.Mooshroom;

public class PoreMushroomCow extends PoreCow implements MushroomCow {

	private static TypeConverter<Mooshroom, PoreMushroomCow> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Mooshroom, PoreMushroomCow> getMushroomCowConverter() {
		if (converter == null) {
			converter = new TypeConverter<Mooshroom, PoreMushroomCow>(){
				@Override
				protected PoreMushroomCow convert(Mooshroom handle) {
					return new PoreMushroomCow(handle);
				}
			};
		}
		return converter;
	}

	protected PoreMushroomCow(Mooshroom handle) {
		super(handle);
	}

	@Override
	public Mooshroom getHandle() {
		return (Mooshroom)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreMushroomCow of(Mooshroom handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.MUSHROOM_COW;
	}

}
