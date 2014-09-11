package net.amigocraft.pore.implementation.entity;

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
        return null;
    }

    @Override
    public void setItem(ItemStack item) {

    }

    @Override
    public Rotation getRotation() {
        return null;
    }

    @Override
    public void setRotation(Rotation rotation) throws IllegalArgumentException {

    }
}
