package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.living.monster.Ghast;

public class PoreGhast extends PoreFlying implements org.bukkit.entity.Ghast {

	private static TypeConverter<Ghast, PoreGhast> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Ghast, PoreGhast> getGhastConverter() {
		if (converter == null) {
			converter = new TypeConverter<Ghast, PoreGhast>(){
				@Override
				protected PoreGhast convert(Ghast handle) {
					return new PoreGhast(handle);
				}
			};
		}
		return converter;
	}

	protected PoreGhast(Ghast handle) {
		super(handle);
	}

	@Override
	public Ghast getHandle() {
		return (Ghast)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreGhast of(Ghast handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.GHAST;
	}

}
