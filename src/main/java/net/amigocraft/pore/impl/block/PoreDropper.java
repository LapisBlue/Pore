package net.amigocraft.pore.impl.block;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.Dropper;
import org.bukkit.inventory.Inventory;
import org.spongepowered.api.block.BlockState;

public class PoreDropper extends PoreBlockState implements Dropper {

	private static TypeConverter<BlockState, PoreDropper> converter;

	static TypeConverter<org.spongepowered.api.block.BlockState, PoreDropper> getDropperConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.block.BlockState, PoreDropper>() {
				@Override
				protected PoreDropper convert(org.spongepowered.api.block.BlockState handle) {
					return new PoreDropper(handle);
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
	public static PoreDropper of(org.spongepowered.api.block.BlockState handle) {
		return converter.apply(handle);
	}

	protected PoreDropper(org.spongepowered.api.block.BlockState handle) {
		super(handle);
	}

	@Override
	public void drop() {
		throw new NotImplementedException();
	}

	@Override
	public Inventory getInventory() {
		throw new NotImplementedException();
	}
}
