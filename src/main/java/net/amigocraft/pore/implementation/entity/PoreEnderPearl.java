package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.EntityType;

public class PoreEnderPearl extends PoreProjectile implements EnderPearl {

	private static TypeConverter<org.spongepowered.api.entity.projectile.EnderPearl, PoreEnderPearl> converter;

	static TypeConverter<org.spongepowered.api.entity.projectile.EnderPearl, PoreEnderPearl> getEnderPearlConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.entity.projectile.EnderPearl, PoreEnderPearl>(
					//TODO: children converters
			){
				@Override
				protected PoreEnderPearl convert(org.spongepowered.api.entity.projectile.EnderPearl handle) {
					return new PoreEnderPearl(handle);
				}
			};
		}
		return converter;
	}

	//TODO: bridge

	protected PoreEnderPearl(org.spongepowered.api.entity.projectile.EnderPearl handle) {
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
	public static PoreEnderPearl of(org.spongepowered.api.entity.projectile.EnderPearl handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.ENDER_PEARL;
	}

}
