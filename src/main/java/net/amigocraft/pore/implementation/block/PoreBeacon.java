package net.amigocraft.pore.implementation.block;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.Beacon;
import org.bukkit.inventory.Inventory;

//TODO: skeleton implementation

//TODO: skeleton implementation

public class PoreBeacon extends PoreBlockState implements Beacon {
	public PoreBeacon(org.spongepowered.api.block.Block spongeBlock) {
		super(spongeBlock);
	}

	@Override
	public Inventory getInventory() {
		throw new NotImplementedException();
	}
}
