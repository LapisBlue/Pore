package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.living.monster.Wither;

public class PoreWither extends PoreMonster implements org.bukkit.entity.Wither {

	private static TypeConverter<Wither, PoreWither> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Wither, PoreWither> getWitherConverter() {
		if (converter == null) {
			converter = new TypeConverter<Wither, PoreWither>(){
				@Override
				protected PoreWither convert(Wither handle) {
					return new PoreWither(handle);
				}
			};
		}
		return converter;
	}

	protected PoreWither(Wither handle) {
		super(handle);
	}

	@Override
	public Wither getHandle() {
		return (Wither)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreWither of(Wither handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.WITHER;
	}

}
