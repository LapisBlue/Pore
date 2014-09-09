package net.amigocraft.pore.implementation.inventory;

// TODO: bridge

import org.bukkit.block.BrewingStand;
import org.bukkit.inventory.BrewerInventory;
import org.bukkit.inventory.ItemStack;

public class PoreBrewerInventory extends PoreInventory implements BrewerInventory {

	@Override
	public ItemStack getIngredient() {
		return null;
	}

	@Override
	public void setIngredient(ItemStack ingredient) {

	}

	@Override
	public BrewingStand getHolder() {
		return null;
	}
}