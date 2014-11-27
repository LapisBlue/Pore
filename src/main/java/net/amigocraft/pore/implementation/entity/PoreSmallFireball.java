package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.projectile.fireball.SmallFireball;

public class PoreSmallFireball extends PoreFireball implements org.bukkit.entity.SmallFireball {

	private static TypeConverter<SmallFireball, PoreSmallFireball> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<SmallFireball, PoreSmallFireball> getSmallFireballConverter() {
		if (converter == null) {
			converter = new TypeConverter<SmallFireball, PoreSmallFireball>(){
				@Override
				protected PoreSmallFireball convert(SmallFireball handle) {
					return new PoreSmallFireball(handle);
				}
			};
		}
		return converter;
	}

	protected PoreSmallFireball(SmallFireball handle) {
		super(handle);
	}

	@Override
	public SmallFireball getHandle() {
		return (SmallFireball)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreSmallFireball of(SmallFireball handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.SMALL_FIREBALL;
	}

}
