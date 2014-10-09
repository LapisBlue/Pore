package net.amigocraft.pore.implementation.inventory;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

// TODO: bridge
public class PoreCraftingInventory extends PoreInventory implements CraftingInventory {

	@Override
	public ItemStack getResult() {
		throw new NotImplementedException();
	}

	@Override
	public ItemStack[] getMatrix() {
		throw new NotImplementedException();
	}

	@Override
	public void setResult(ItemStack newResult) {
		throw new NotImplementedException();
	}

	@Override
	public void setMatrix(ItemStack[] contents) {
		throw new NotImplementedException();
	}

	@Override
	public Recipe getRecipe() {
		throw new NotImplementedException();
	}
}