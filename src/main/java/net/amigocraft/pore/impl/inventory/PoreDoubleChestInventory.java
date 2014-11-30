package net.amigocraft.pore.impl.inventory;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.DoubleChest;
import org.bukkit.inventory.DoubleChestInventory;
import org.bukkit.inventory.Inventory;

// TODO: bridge

// TODO: bridge

public class PoreDoubleChestInventory extends PoreInventory implements DoubleChestInventory {

	@Override
	public Inventory getLeftSide() {
		throw new NotImplementedException();
	}

	@Override
	public Inventory getRightSide() {
		throw new NotImplementedException();
	}

	@Override
	public DoubleChest getHolder() {
		throw new NotImplementedException();
	}
}