package net.amigocraft.pore.impl.block;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.spongepowered.api.block.BlockState;

public class PoreChest extends PoreBlockState implements Chest {

	private static TypeConverter<BlockState, PoreChest> converter;

	static TypeConverter<org.spongepowered.api.block.BlockState, PoreChest> getChestConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.block.BlockState, PoreChest>() {
				@Override
				protected PoreChest convert(org.spongepowered.api.block.BlockState handle) {
					return new PoreChest(handle);
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
	public static PoreChest of(org.spongepowered.api.block.BlockState handle) {
		return converter.apply(handle);
	}

	protected PoreChest(org.spongepowered.api.block.BlockState handle) {
		super(handle);
	}

	@Override
	public Inventory getBlockInventory() {
		throw new NotImplementedException();
	}

	@Override
	public Inventory getInventory() {
		throw new NotImplementedException();
	}
}
