package net.amigocraft.pore.implementation.entity;

import com.google.common.collect.ImmutableMap;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.living.golem.SnowGolem;

public class PoreSnowman extends PoreGolem implements org.bukkit.entity.Snowman {

	private static TypeConverter<SnowGolem, PoreSnowman> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<SnowGolem, PoreSnowman> getSnowmanConverter() {
		if (converter == null) {
			converter = new TypeConverter<SnowGolem, PoreSnowman>(
					(ImmutableMap)ImmutableMap.builder() // generified for simplicity and readability
							.build()
			){
				@Override
				protected PoreSnowman convert(SnowGolem handle) {
					return new PoreSnowman(handle);
				}
			};
		}
		return converter;
	}

	protected PoreSnowman(SnowGolem handle) {
		super(handle);
	}

	@Override
	public SnowGolem getHandle() {
		return (SnowGolem)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreSnowman of(SnowGolem handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.SNOWMAN;
	}
}
