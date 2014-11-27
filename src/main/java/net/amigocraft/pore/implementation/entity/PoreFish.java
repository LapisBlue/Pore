package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fish;
import org.spongepowered.api.entity.projectile.FishHook;

public class PoreFish extends PoreProjectile implements Fish {

	private static TypeConverter<FishHook, PoreFish> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<FishHook, PoreFish> getFishConverter() {
		if (converter == null) {
			converter = new TypeConverter<FishHook, PoreFish>(){
				@Override
				protected PoreFish convert(FishHook handle) {
					return new PoreFish(handle);
				}
			};
		}
		return converter;
	}

	protected PoreFish(FishHook handle) {
		super(handle);
	}

	@Override
	public FishHook getHandle() {
		return (FishHook)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreFish of(FishHook handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.FISHING_HOOK;
	}

	@Override
	public double getBiteChance() {
		throw new NotImplementedException();
	}

	@Override
	public void setBiteChance(double chance) throws IllegalArgumentException {
		throw new NotImplementedException();
	}
}
