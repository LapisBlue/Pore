package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.living.animal.Pig;

public class PorePig extends PoreAnimals implements org.bukkit.entity.Pig {

	private static TypeConverter<Pig, PorePig> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Pig, PorePig> getPigConverter() {
		if (converter == null) {
			converter = new TypeConverter<Pig, PorePig>(){
				@Override
				protected PorePig convert(Pig handle) {
					return new PorePig(handle);
				}
			};
		}
		return converter;
	}

	protected PorePig(Pig handle) {
		super(handle);
	}

	@Override
	public Pig getHandle() {
		return (Pig)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PorePig of(Pig handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.PIG;
	}

	@Override
	public boolean hasSaddle() {
		return getHandle().isSaddled();
	}

	@Override
	public void setSaddle(boolean saddled) {
		getHandle().setSaddled(saddled);
	}
}
