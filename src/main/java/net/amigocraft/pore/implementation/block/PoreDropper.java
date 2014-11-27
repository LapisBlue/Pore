package net.amigocraft.pore.implementation.block;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.Dropper;
import org.bukkit.inventory.Inventory;
import org.spongepowered.api.block.BlockLoc;

//TODO: wireframe implementation

public class PoreDropper extends PoreBlockState implements Dropper {
	public PoreDropper(BlockLoc spongeBlock) {
		super(spongeBlock);
	}

	@Override
	public void drop() {
		throw new NotImplementedException();
	}

	@Override
	public Inventory getInventory() {
		throw new NotImplementedException();
	}
}
