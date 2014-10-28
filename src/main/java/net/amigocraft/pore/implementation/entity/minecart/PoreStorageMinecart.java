package net.amigocraft.pore.implementation.entity.minecart;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.minecart.StorageMinecart;
import org.bukkit.inventory.Inventory;

public class PoreStorageMinecart extends PoreMinecart implements StorageMinecart {

	// TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreStorageMinecart(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreStorageMinecart of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.MINECART_CHEST;
	}

	@Override
	public Inventory getInventory() {
		throw new NotImplementedException();
	}

}
