package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Snowball;

public class PoreSnowball extends PoreProjectile implements Snowball {

	private static TypeConverter<org.spongepowered.api.entity.projectile.Snowball, PoreSnowball> converter;

	static TypeConverter<org.spongepowered.api.entity.projectile.Snowball, PoreSnowball> getSnowballConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.entity.projectile.Snowball, PoreSnowball>(
					//TODO: children converters
			){
				@Override
				protected PoreSnowball convert(org.spongepowered.api.entity.projectile.Snowball handle) {
					return new PoreSnowball(handle);
				}
			};
		}
		return converter;
	}

	protected PoreSnowball(org.spongepowered.api.entity.projectile.Snowball handle) {
		super(handle);
	}

	@Override
	public org.spongepowered.api.entity.projectile.Snowball getHandle() {
		return (org.spongepowered.api.entity.projectile.Snowball)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreSnowball of(org.spongepowered.api.entity.projectile.Snowball handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.SNOWBALL;
	}

}
