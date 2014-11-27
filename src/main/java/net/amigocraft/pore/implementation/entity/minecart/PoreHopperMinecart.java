package net.amigocraft.pore.implementation.entity.minecart;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.minecart.HopperMinecart;
import org.bukkit.inventory.Inventory;
import org.spongepowered.api.entity.vehicle.minecart.MinecartHopper;

public class PoreHopperMinecart extends PoreMinecart implements HopperMinecart {

	private static TypeConverter<MinecartHopper, PoreHopperMinecart> converter;

	@SuppressWarnings("unchecked")
	public static TypeConverter<MinecartHopper, PoreHopperMinecart> getHopperMinecartConverter() {
		if (converter == null) {
			converter = new TypeConverter<MinecartHopper, PoreHopperMinecart>(){
				@Override
				protected PoreHopperMinecart convert(MinecartHopper handle) {
					return new PoreHopperMinecart(handle);
				}
			};
		}
		return converter;
	}

	protected PoreHopperMinecart(MinecartHopper handle) {
		super(handle);
	}

	@Override
	public MinecartHopper getHandle() {
		return (MinecartHopper)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreHopperMinecart of(MinecartHopper handle) {
		return converter.apply(handle);
	}

	//TODO: bridge

	@Override
	public EntityType getType(){
		return EntityType.MINECART_HOPPER;
	}

	@Override
	public Inventory getInventory() {
		throw new NotImplementedException();
	}

}
