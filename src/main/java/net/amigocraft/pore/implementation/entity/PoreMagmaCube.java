package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.living.monster.MagmaCube;

public class PoreMagmaCube extends PoreSlime implements org.bukkit.entity.MagmaCube {

	private static TypeConverter<MagmaCube, PoreMagmaCube> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<MagmaCube, PoreMagmaCube> getMagmaCubeConverter() {
		if (converter == null) {
			converter = new TypeConverter<MagmaCube, PoreMagmaCube>(){
				@Override
				protected PoreMagmaCube convert(MagmaCube handle) {
					return new PoreMagmaCube(handle);
				}
			};
		}
		return converter;
	}

	protected PoreMagmaCube(MagmaCube handle) {
		super(handle);
	}

	@Override
	public MagmaCube getHandle() {
		return (MagmaCube)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreMagmaCube of(MagmaCube handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.MAGMA_CUBE;
	}

}
