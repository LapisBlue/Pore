package net.amigocraft.pore.impl.inventory;

// TODO: bridge

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.BrewingStand;
import org.bukkit.inventory.BrewerInventory;
import org.bukkit.inventory.ItemStack;

public class PoreBrewerInventory extends PoreInventory implements BrewerInventory {

	@Override
	public ItemStack getIngredient() {
		throw new NotImplementedException();
	}

	@Override
	public void setIngredient(ItemStack ingredient) {
		throw new NotImplementedException();
	}

	@Override
	public BrewingStand getHolder() {
		throw new NotImplementedException();
	}
}