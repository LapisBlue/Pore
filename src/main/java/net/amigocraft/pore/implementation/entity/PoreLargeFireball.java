package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.spongepowered.api.entity.projectile.fireball.LargeFireball;

public class PoreLargeFireball extends PoreFireball implements org.bukkit.entity.LargeFireball {

	private static TypeConverter<LargeFireball, PoreLargeFireball> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<LargeFireball, PoreLargeFireball> getLargeFireballConverter() {
		if (converter == null) {
			converter = new TypeConverter<LargeFireball, PoreLargeFireball>(){
				@Override
				protected PoreLargeFireball convert(LargeFireball handle) {
					return new PoreLargeFireball(handle);
				}
			};
		}
		return converter;
	}

	protected PoreLargeFireball(LargeFireball handle) {
		super(handle);
	}

	@Override
	public LargeFireball getHandle() {
		return (LargeFireball)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreLargeFireball of(LargeFireball handle) {
		return converter.apply(handle);
	}

}
