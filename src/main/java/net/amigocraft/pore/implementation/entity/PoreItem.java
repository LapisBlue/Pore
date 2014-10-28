package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

public class PoreItem extends PoreEntity implements Item {

	// TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreItem(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreItem of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.DROPPED_ITEM;
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
		throw new NotImplementedException();
	}

	@Override
	public void setPickupDelay(int delay) {
		throw new NotImplementedException();
	}
}
