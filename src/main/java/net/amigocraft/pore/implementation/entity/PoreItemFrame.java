package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Rotation;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.inventory.ItemStack;

public class PoreItemFrame extends PoreHanging implements ItemFrame {

	// TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreItemFrame(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreItemFrame of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.ITEM_FRAME;
	}

	@Override
	public ItemStack getItem() {
		throw new NotImplementedException();
	}

	@Override
	public void setItem(ItemStack item) {
		throw new NotImplementedException();
	}

	@Override
	public Rotation getRotation() {
		throw new NotImplementedException();
	}

	@Override
	public void setRotation(Rotation rotation) throws IllegalArgumentException {
		throw new NotImplementedException();
	}
}
