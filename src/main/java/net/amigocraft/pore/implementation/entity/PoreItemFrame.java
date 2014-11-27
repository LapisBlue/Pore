package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.ItemStackConverter;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Rotation;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.spongepowered.api.entity.hanging.ItemFrame;

public class PoreItemFrame extends PoreHanging implements org.bukkit.entity.ItemFrame {

	private static TypeConverter<ItemFrame, PoreItemFrame> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<ItemFrame, PoreItemFrame> getItemFrameConverter() {
		if (converter == null) {
			converter = new TypeConverter<ItemFrame, PoreItemFrame>(){
				@Override
				protected PoreItemFrame convert(ItemFrame handle) {
					return new PoreItemFrame(handle);
				}
			};
		}
		return converter;
	}

	protected PoreItemFrame(ItemFrame handle) {
		super(handle);
	}

	@Override
	public ItemFrame getHandle() {
		return (ItemFrame)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreItemFrame of(ItemFrame handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.ITEM_FRAME;
	}

	@Override
	public ItemStack getItem() {
		return ItemStackConverter.of(getHandle().getItem().get());
	}

	@Override
	public void setItem(ItemStack item) {
		getHandle().setItem(ItemStackConverter.of(item));
	}

	@Override
	public Rotation getRotation() {
		throw new NotImplementedException(); //TODO
	}

	@Override
	public void setRotation(Rotation rotation) throws IllegalArgumentException {
		throw new NotImplementedException(); //TODO
	}
}
