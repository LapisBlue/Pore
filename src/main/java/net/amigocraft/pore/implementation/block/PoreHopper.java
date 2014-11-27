package net.amigocraft.pore.implementation.block;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.Hopper;
import org.bukkit.inventory.Inventory;
import org.spongepowered.api.block.BlockLoc;

//TODO: skeleton implementation

public class PoreHopper extends PoreBlockState implements Hopper {
	public PoreHopper(BlockLoc spongeBlock) {
		super(spongeBlock);
	}

	@Override
	public Inventory getInventory() {
		throw new NotImplementedException();
	}
}
