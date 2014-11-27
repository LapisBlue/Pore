package net.amigocraft.pore.implementation.block;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.Beacon;
import org.bukkit.inventory.Inventory;
import org.spongepowered.api.block.BlockLoc;

//TODO: skeleton implementation

public class PoreBeacon extends PoreBlockState implements Beacon {
	public PoreBeacon(BlockLoc spongeBlock) {
		super(spongeBlock);
	}

	@Override
	public Inventory getInventory() {
		throw new NotImplementedException();
	}
}
