package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.EntityType;

public class PoreBlaze extends PoreMonster implements Blaze {

	private static TypeConverter<org.spongepowered.api.entity.living.monster.Blaze, PoreBlaze> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<org.spongepowered.api.entity.living.monster.Blaze, PoreBlaze> getBlazeConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.entity.living.monster.Blaze, PoreBlaze>(){
				@Override
				protected PoreBlaze convert(org.spongepowered.api.entity.living.monster.Blaze handle) {
					return new PoreBlaze(handle);
				}
			};
		}
		return converter;
	}

	protected PoreBlaze(org.spongepowered.api.entity.living.monster.Blaze handle) {
		super(handle);
	}

	@Override
	public org.spongepowered.api.entity.living.monster.Blaze getHandle() {
		return (org.spongepowered.api.entity.living.monster.Blaze)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreBlaze of(org.spongepowered.api.entity.living.monster.Blaze handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.BLAZE;
	}

}
