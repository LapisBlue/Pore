package net.amigocraft.pore.impl.entity;

import com.google.common.collect.ImmutableMap;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.spongepowered.api.entity.living.golem.Golem;
import org.spongepowered.api.entity.living.golem.IronGolem;
import org.spongepowered.api.entity.living.golem.SnowGolem;

public class PoreGolem extends PoreCreature implements org.bukkit.entity.Golem {

	private static TypeConverter<Golem, PoreGolem> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Golem, PoreGolem> getGolemConverter() {
		if (converter == null) {
			converter = new TypeConverter<Golem, PoreGolem>(
					(ImmutableMap)ImmutableMap.builder() // generified for simplicity and readability
							.put(IronGolem.class, PoreIronGolem.getIronGolemConverter())
							.put(SnowGolem.class, PoreSnowman.getSnowmanConverter())
							.build()
			){
				@Override
				protected PoreGolem convert(Golem handle) {
					return new PoreGolem(handle);
				}
			};
		}
		return converter;
	}

	protected PoreGolem(Golem handle) {
		super(handle);
	}

	@Override
	public Golem getHandle() {
		return (Golem)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreGolem of(Golem handle) {
		return converter.apply(handle);
	}

}
