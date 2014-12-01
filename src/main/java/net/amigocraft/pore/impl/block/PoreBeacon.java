package net.amigocraft.pore.impl.block;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.Beacon;
import org.bukkit.inventory.Inventory;
import org.spongepowered.api.block.BlockState;

public class PoreBeacon extends PoreBlockState implements Beacon {

	private static TypeConverter<BlockState, PoreBeacon> converter;

	static TypeConverter<org.spongepowered.api.block.BlockState, PoreBeacon> getBeaconConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.block.BlockState, PoreBeacon>() {
				@Override
				protected PoreBeacon convert(org.spongepowered.api.block.BlockState handle) {
					return new PoreBeacon(handle);
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
	public static PoreBeacon of(org.spongepowered.api.block.BlockState handle) {
		return converter.apply(handle);
	}

	protected PoreBeacon(org.spongepowered.api.block.BlockState handle) {
		super(handle);
	}

	@Override
	public Inventory getInventory(){
		throw new NotImplementedException();
	}
}
