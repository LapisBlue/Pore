package net.amigocraft.pore.implementation.entity.minecart;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.minecart.PoweredMinecart;
import org.spongepowered.api.entity.vehicle.minecart.Minecart;
import org.spongepowered.api.entity.vehicle.minecart.MinecartFurnace;

public class PorePoweredMinecart extends PoreMinecart implements PoweredMinecart {

	private static TypeConverter<MinecartFurnace, PorePoweredMinecart> converter;

	@SuppressWarnings("unchecked")
	public static TypeConverter<MinecartFurnace, PorePoweredMinecart> getPoweredMinecartConverter() {
		if (converter == null) {
			converter = new TypeConverter<MinecartFurnace, PorePoweredMinecart>(){
				@Override
				protected PorePoweredMinecart convert(MinecartFurnace handle) {
					return new PorePoweredMinecart(handle);
				}
			};
		}
		return converter;
	}

	protected PorePoweredMinecart(MinecartFurnace handle) {
		super(handle);
	}

	@Override
	public Minecart getHandle() {
		return (Minecart)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PorePoweredMinecart of(MinecartFurnace handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.MINECART_FURNACE;
	}

}
