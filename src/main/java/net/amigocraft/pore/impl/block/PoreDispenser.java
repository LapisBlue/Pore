package net.amigocraft.pore.impl.block;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.Dispenser;
import org.bukkit.inventory.Inventory;
import org.bukkit.projectiles.BlockProjectileSource;
import org.spongepowered.api.block.BlockState;

public class PoreDispenser extends PoreBlockState implements Dispenser {

	private static TypeConverter<BlockState, PoreDispenser> converter;

	static TypeConverter<org.spongepowered.api.block.BlockState, PoreDispenser> getDispenserConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.block.BlockState, PoreDispenser>() {
				@Override
				protected PoreDispenser convert(org.spongepowered.api.block.BlockState handle) {
					return new PoreDispenser(handle);
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
	public static PoreDispenser of(org.spongepowered.api.block.BlockState handle) {
		return converter.apply(handle);
	}

	protected PoreDispenser(org.spongepowered.api.block.BlockState handle) {
		super(handle);
	}

	@Override
	public BlockProjectileSource getBlockProjectileSource() {
		throw new NotImplementedException();
	}

	@Override
	public boolean dispense() {
		throw new NotImplementedException();
	}

	@Override
	public Inventory getInventory() {
		throw new NotImplementedException();
	}
}
