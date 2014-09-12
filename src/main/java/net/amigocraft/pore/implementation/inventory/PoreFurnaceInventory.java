package net.amigocraft.pore.implementation.inventory;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.Furnace;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.ItemStack;

// TODO: bridge

// TODO: bridge

public class PoreFurnaceInventory extends PoreInventory implements FurnaceInventory {

	@Override
	public ItemStack getResult() {
		throw new NotImplementedException();
	}

	@Override
	public ItemStack getFuel() {
		throw new NotImplementedException();
	}

	@Override
	public ItemStack getSmelting() {
		throw new NotImplementedException();
	}

	@Override
	public void setFuel(ItemStack stack) {
		throw new NotImplementedException();
	}

	@Override
	public void setResult(ItemStack stack) {
		throw new NotImplementedException();
	}

	@Override
	public void setSmelting(ItemStack stack) {
		throw new NotImplementedException();
	}

	@Override
	public Furnace getHolder() {
		throw new NotImplementedException();
	}
}