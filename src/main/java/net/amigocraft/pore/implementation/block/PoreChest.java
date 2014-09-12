package net.amigocraft.pore.implementation.block;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;

//TODO: skeleton implementation

//TODO: skeleton implementation

public class PoreChest extends PoreBlockState implements Chest {
	public PoreChest(org.spongepowered.api.block.Block spongeBlock) {
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
