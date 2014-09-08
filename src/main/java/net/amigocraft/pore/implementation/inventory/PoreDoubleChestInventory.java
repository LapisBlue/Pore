package net.amigocraft.pore.implementation.inventory;

import org.bukkit.block.DoubleChest;
import org.bukkit.inventory.DoubleChestInventory;
import org.bukkit.inventory.Inventory;

// TODO: bridge

public class PoreDoubleChestInventory extends PoreInventory implements DoubleChestInventory {

	@Override
	public Inventory getLeftSide() {
		return null;
	}

	@Override
	public Inventory getRightSide() {
		return null;
	}

	@Override
	public DoubleChest getHolder() {
		return null;
	}
}