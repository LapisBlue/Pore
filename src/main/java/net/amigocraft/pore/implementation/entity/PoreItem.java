package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.ItemStackConverter;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.spongepowered.api.entity.Item;

public class PoreItem extends PoreEntity implements org.bukkit.entity.Item {

	private static TypeConverter<Item, PoreItem> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Item, PoreItem> getItemConverter() {
		if (converter == null) {
			converter = new TypeConverter<Item, PoreItem>(){
				@Override
				protected PoreItem convert(Item handle) {
					return new PoreItem(handle);
				}
			};
		}
		return converter;
	}

	protected PoreItem(Item handle) {
		super(handle);
	}

	@Override
	public Item getHandle() {
		return (Item)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreItem of(Item handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.DROPPED_ITEM;
	}

	@Override
	public ItemStack getItemStack() {
		return ItemStackConverter.of(getHandle().getItemStack());
	}

	@Override
	public void setItemStack(ItemStack stack) {
		throw new NotImplementedException(); //TODO
	}

	@Override
	public int getPickupDelay() {
		throw new NotImplementedException(); //TODO
	}

	@Override
	public void setPickupDelay(int delay) {
		throw new NotImplementedException(); //TODO
	}
}
