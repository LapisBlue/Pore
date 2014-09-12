package net.amigocraft.pore.implementation.entity.minecart;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.minecart.HopperMinecart;
import org.bukkit.inventory.Inventory;

public class PoreHopperMinecart extends PoreMinecart implements HopperMinecart {

	// TODO: Bridge

	public PoreHopperMinecart(org.spongepowered.api.entity.Entity handle) { //TODO: accept most specfific type
		super(handle);
	}

	@Override
	public Inventory getInventory() {
		throw new NotImplementedException();
	}

}
