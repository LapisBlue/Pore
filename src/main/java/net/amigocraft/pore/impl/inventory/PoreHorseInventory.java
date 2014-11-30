package net.amigocraft.pore.impl.inventory;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.inventory.HorseInventory;
import org.bukkit.inventory.ItemStack;

// TODO: bridge

// TODO: bridge

public class PoreHorseInventory extends PoreInventory implements HorseInventory {

	@Override
	public ItemStack getSaddle() {
		throw new NotImplementedException();
	}

	@Override
	public ItemStack getArmor() {
		throw new NotImplementedException();
	}

	@Override
	public void setSaddle(ItemStack stack) {
		throw new NotImplementedException();
	}

	@Override
	public void setArmor(ItemStack stack) {
		throw new NotImplementedException();
	}
}