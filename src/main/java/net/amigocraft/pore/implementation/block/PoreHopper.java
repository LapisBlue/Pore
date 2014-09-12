package net.amigocraft.pore.implementation.block;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.Hopper;
import org.bukkit.inventory.Inventory;

//TODO: skeleton implementation

//TODO: skeleton implementation

public class PoreHopper extends PoreBlockState implements Hopper {
	public PoreHopper(org.spongepowered.api.block.Block spongeBlock) {
		super(spongeBlock);
	}

	@Override
	public Inventory getInventory() {
		throw new NotImplementedException();
	}
}
