package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.projectile.fireball.WitherSkull;

public class PoreWitherSkull extends PoreFireball implements org.bukkit.entity.WitherSkull {

	private static TypeConverter<WitherSkull, PoreWitherSkull> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<WitherSkull, PoreWitherSkull> getWitherSkullConverter() {
		if (converter == null) {
			converter = new TypeConverter<WitherSkull, PoreWitherSkull>(){
				@Override
				protected PoreWitherSkull convert(WitherSkull handle) {
					return new PoreWitherSkull(handle);
				}
			};
		}
		return converter;
	}

	protected PoreWitherSkull(WitherSkull handle) {
		super(handle);
	}

	@Override
	public WitherSkull getHandle() {
		return (WitherSkull)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreWitherSkull of(WitherSkull handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.WITHER_SKULL;
	}

	@Override
	public void setCharged(boolean charged) {
		throw new NotImplementedException(); //TODO
	}

	@Override
	public boolean isCharged() {
		throw new NotImplementedException(); //TODO
	}
}
