package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EntityType;

public class PoreEgg extends PoreProjectile implements Egg {

	private static TypeConverter<org.spongepowered.api.entity.projectile.Egg, PoreEgg> converter;

	static TypeConverter<org.spongepowered.api.entity.projectile.Egg, PoreEgg> getEggConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.entity.projectile.Egg, PoreEgg>(
					//TODO: children converters
			){
				@Override
				protected PoreEgg convert(org.spongepowered.api.entity.projectile.Egg handle) {
					return new PoreEgg(handle);
				}
			};
		}
		return converter;
	}

	//TODO: bridge

	protected PoreEgg(org.spongepowered.api.entity.projectile.Egg handle) {
		super(handle);
	}

	@Override
	public org.spongepowered.api.entity.projectile.Egg getHandle() {
		return (org.spongepowered.api.entity.projectile.Egg)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreEgg of(org.spongepowered.api.entity.projectile.Egg handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.EGG;
	}

}
