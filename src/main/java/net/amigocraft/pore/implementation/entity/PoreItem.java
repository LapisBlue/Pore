package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

public class PoreItem extends PoreEntity implements Item {

	// TODO: Bridge

	public PoreItem(org.spongepowered.api.entity.Entity handle) { //TODO: accept most specfific type
		super(handle);
	}

	@Override
	public ItemStack getItemStack() {
		throw new NotImplementedException();
	}

	@Override
	public void setItemStack(ItemStack stack) {
		throw new NotImplementedException();
	}

	@Override
	public int getPickupDelay() {
		return 0;
	}

	@Override
	public void setPickupDelay(int delay) {
		throw new NotImplementedException();
	}
}
