package net.amigocraft.pore.implementation.block;

import org.bukkit.block.Beacon;
import org.bukkit.inventory.Inventory;

//TODO: skeleton implementation

public class PoreBeacon extends PoreBlockState implements Beacon {
	public PoreBeacon(org.spongepowered.api.block.Block spongeBlock) {
		super(spongeBlock);
	}

	@Override
	public Inventory getInventory() {
		return null;
	}
}
