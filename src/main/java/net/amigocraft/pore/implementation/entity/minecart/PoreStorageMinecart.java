package net.amigocraft.pore.implementation.entity.minecart;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.minecart.StorageMinecart;
import org.bukkit.inventory.Inventory;

public class PoreStorageMinecart extends PoreMinecart implements StorageMinecart {

	// TODO: Bridge

	public PoreStorageMinecart(org.spongepowered.api.entity.Entity handle) { //TODO: accept most specfific type
		super(handle);
	}

	@Override
	public Inventory getInventory() {
		throw new NotImplementedException();
	}

}
