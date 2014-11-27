package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.living.monster.Giant;

public class PoreGiant extends PoreMonster implements org.bukkit.entity.Giant {

	private static TypeConverter<Giant, PoreGiant> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Giant, PoreGiant> getGiantConverter() {
		if (converter == null) {
			converter = new TypeConverter<Giant, PoreGiant>(){
				@Override
				protected PoreGiant convert(Giant handle) {
					return new PoreGiant(handle);
				}
			};
		}
		return converter;
	}

	protected PoreGiant(Giant handle) {
		super(handle);
	}

	@Override
	public Giant getHandle() {
		return (Giant)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreGiant of(Giant handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.GIANT;
	}

}
