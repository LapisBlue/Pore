package net.amigocraft.pore.implementation.entity.minecart;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.minecart.HopperMinecart;
import org.bukkit.inventory.Inventory;

public class PoreHopperMinecart extends PoreMinecart implements HopperMinecart {

	// TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreHopperMinecart(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreHopperMinecart of(org.spongepowered.api.entity.Entity handle){
		return (PoreHopperMinecart)PoreMinecart.of(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.MINECART_HOPPER;
	}

	@Override
	public Inventory getInventory() {
		throw new NotImplementedException();
	}

}
