package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Rotation;
import org.bukkit.entity.ItemFrame;
import org.bukkit.inventory.ItemStack;

public class PoreItemFrame extends PoreHanging implements ItemFrame {

	// TODO: Bridge

	public PoreItemFrame(org.spongepowered.api.entity.Entity handle) { //TODO: accept most specfific type
		super(handle);
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
