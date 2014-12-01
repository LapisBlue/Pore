package net.amigocraft.pore.impl.block;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.Furnace;
import org.bukkit.inventory.FurnaceInventory;
import org.spongepowered.api.block.BlockState;

public class PoreFurnace extends PoreBlockState implements Furnace {

	private static TypeConverter<BlockState, PoreFurnace> converter;

	static TypeConverter<org.spongepowered.api.block.BlockState, PoreFurnace> getFurnaceConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.block.BlockState, PoreFurnace>() {
				@Override
				protected PoreFurnace convert(org.spongepowered.api.block.BlockState handle) {
					return new PoreFurnace(handle);
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
	public static PoreFurnace of(org.spongepowered.api.block.BlockState handle) {
		return converter.apply(handle);
	}

	protected PoreFurnace(org.spongepowered.api.block.BlockState handle) {
		super(handle);
	}

	@Override
	public short getBurnTime() {
		throw new NotImplementedException();
	}

	@Override
	public void setBurnTime(short burnTime) {
		throw new NotImplementedException();
	}

	@Override
	public short getCookTime() {
		throw new NotImplementedException();
	}

	@Override
	public void setCookTime(short cookTime) {
		throw new NotImplementedException();
	}

	@Override
	public FurnaceInventory getInventory() {
		throw new NotImplementedException();
	}
}
