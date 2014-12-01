package net.amigocraft.pore.impl.block;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.BrewingStand;
import org.bukkit.inventory.BrewerInventory;
import org.spongepowered.api.block.BlockState;

public class PoreBrewingStand extends PoreBlockState implements BrewingStand {

	private static TypeConverter<BlockState, PoreBrewingStand> converter;

	static TypeConverter<org.spongepowered.api.block.BlockState, PoreBrewingStand> getBrewingStandConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.block.BlockState, PoreBrewingStand>() {
				@Override
				protected PoreBrewingStand convert(org.spongepowered.api.block.BlockState handle) {
					return new PoreBrewingStand(handle);
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
	public static PoreBrewingStand of(org.spongepowered.api.block.BlockState handle) {
		return converter.apply(handle);
	}

	protected PoreBrewingStand(org.spongepowered.api.block.BlockState handle) {
		super(handle);
	}

	@Override
	public int getBrewingTime() {
		throw new NotImplementedException();
	}

	@Override
	public void setBrewingTime(int brewTime) {
		throw new NotImplementedException();
	}

	@Override
	public BrewerInventory getInventory() {
		throw new NotImplementedException();
	}
}
