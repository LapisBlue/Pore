package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.EntityType;

public class PoreEnderCrystal extends PoreEntity implements EnderCrystal {

	private static TypeConverter<org.spongepowered.api.entity.EnderCrystal, PoreEnderCrystal> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<org.spongepowered.api.entity.EnderCrystal, PoreEnderCrystal> getEnderCrystalConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.entity.EnderCrystal, PoreEnderCrystal>(){
				@Override
				protected PoreEnderCrystal convert(org.spongepowered.api.entity.EnderCrystal handle) {
					return new PoreEnderCrystal(handle);
				}
			};
		}
		return converter;
	}

	protected PoreEnderCrystal(org.spongepowered.api.entity.EnderCrystal handle) {
		super(handle);
	}

	@Override
	public org.spongepowered.api.entity.EnderCrystal getHandle() {
		return (org.spongepowered.api.entity.EnderCrystal)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreEnderCrystal of(org.spongepowered.api.entity.EnderCrystal handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.ENDER_CRYSTAL;
	}

}
