package net.amigocraft.pore.implementation.inventory;

import org.bukkit.block.Furnace;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.ItemStack;

// TODO: bridge

public class PoreFurnaceInventory extends PoreInventory implements FurnaceInventory {

	@Override
	public ItemStack getResult() {
		return null;
	}

	@Override
	public ItemStack getFuel() {
		return null;
	}

	@Override
	public ItemStack getSmelting() {
		return null;
	}

	@Override
	public void setFuel(ItemStack stack) {

	}

	@Override
	public void setResult(ItemStack stack) {

	}

	@Override
	public void setSmelting(ItemStack stack) {

	}

	@Override
	public Furnace getHolder() {
		return null;
	}
}