package net.amigocraft.pore.implementation.entity.minecart;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.minecart.ExplosiveMinecart;
import org.spongepowered.api.entity.vehicle.minecart.MinecartTNT;

public class PoreExplosiveMinecart extends PoreMinecart implements ExplosiveMinecart {

	private static TypeConverter<MinecartTNT, PoreExplosiveMinecart> converter;

	@SuppressWarnings("unchecked")
	public static TypeConverter<MinecartTNT, PoreExplosiveMinecart> getExplosiveMinecartConverter() {
		if (converter == null) {
			converter = new TypeConverter<MinecartTNT, PoreExplosiveMinecart>(){
				@Override
				protected PoreExplosiveMinecart convert(MinecartTNT handle) {
					return new PoreExplosiveMinecart(handle);
				}
			};
		}
		return converter;
	}

	protected PoreExplosiveMinecart(MinecartTNT handle) {
		super(handle);
	}

	@Override
	public MinecartTNT getHandle() {
		return (MinecartTNT)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreExplosiveMinecart of(MinecartTNT handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.MINECART_TNT;
	}

}
