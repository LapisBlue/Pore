package net.amigocraft.pore.implementation.entity.minecart;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.minecart.StorageMinecart;
import org.bukkit.inventory.Inventory;
import org.spongepowered.api.entity.vehicle.minecart.MinecartChest;

public class PoreStorageMinecart extends PoreMinecart implements StorageMinecart {

	private static TypeConverter<MinecartChest, PoreStorageMinecart> converter;

	@SuppressWarnings("unchecked")
	public static TypeConverter<MinecartChest, PoreStorageMinecart> getStorageMinecartConverter() {
		if (converter == null) {
			converter = new TypeConverter<MinecartChest, PoreStorageMinecart>(){
				@Override
				protected PoreStorageMinecart convert(MinecartChest handle) {
					return new PoreStorageMinecart(handle);
				}
			};
		}
		return converter;
	}

	protected PoreStorageMinecart(MinecartChest handle) {
		super(handle);
	}

	@Override
	public MinecartChest getHandle() {
		return (MinecartChest)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreStorageMinecart of(MinecartChest handle) {
		return converter.apply(handle);
	}

	//TODO: bridge

	@Override
	public EntityType getType(){
		return EntityType.MINECART_CHEST;
	}

	@Override
	public Inventory getInventory() {
		throw new NotImplementedException();
	}

}
