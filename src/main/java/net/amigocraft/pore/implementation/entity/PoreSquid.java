package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.living.animal.Squid;

public class PoreSquid extends PoreWaterMob implements org.bukkit.entity.Squid {

	private static TypeConverter<Squid, PoreSquid> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Squid, PoreSquid> getSquidConverter() {
		if (converter == null) {
			converter = new TypeConverter<Squid, PoreSquid>(){
				@Override
				protected PoreSquid convert(Squid handle) {
					return new PoreSquid(handle);
				}
			};
		}
		return converter;
	}

	protected PoreSquid(Squid handle) {
		super(handle);
	}

	@Override
	public Squid getHandle() {
		return (Squid)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreSquid of(Squid handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.SQUID;
	}

}
