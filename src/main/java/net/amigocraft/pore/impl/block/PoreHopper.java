package net.amigocraft.pore.impl.block;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.Hopper;
import org.bukkit.inventory.Inventory;
import org.spongepowered.api.block.BlockState;

public class PoreHopper extends PoreBlockState implements Hopper {

	private static TypeConverter<BlockState, PoreHopper> converter;

	static TypeConverter<org.spongepowered.api.block.BlockState, PoreHopper> getHopperConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.block.BlockState, PoreHopper>() {
				@Override
				protected PoreHopper convert(org.spongepowered.api.block.BlockState handle) {
					return new PoreHopper(handle);
				}
			};
		}

		return converter;
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreHopper of(org.spongepowered.api.block.BlockState handle) {
		return converter.apply(handle);
	}

	protected PoreHopper(org.spongepowered.api.block.BlockState handle) {
		super(handle);
	}

	@Override
	public Inventory getInventory() {
		throw new NotImplementedException();
	}
}
