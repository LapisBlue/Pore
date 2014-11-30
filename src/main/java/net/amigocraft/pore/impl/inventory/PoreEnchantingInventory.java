package net.amigocraft.pore.impl.inventory;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.inventory.EnchantingInventory;
import org.bukkit.inventory.ItemStack;

// TODO: bridge
public class PoreEnchantingInventory extends PoreInventory implements EnchantingInventory {

	@Override
	public void setItem(ItemStack item) {
		throw new NotImplementedException();
	}

	@Override
	public ItemStack getItem() {
		throw new NotImplementedException();
	}
}