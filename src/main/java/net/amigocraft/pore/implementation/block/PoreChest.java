package net.amigocraft.pore.implementation.block;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.spongepowered.api.block.BlockLoc;

//TODO: skeleton implementation

public class PoreChest extends PoreBlockState implements Chest {
	public PoreChest(BlockLoc spongeBlock) {
		super(spongeBlock);
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
