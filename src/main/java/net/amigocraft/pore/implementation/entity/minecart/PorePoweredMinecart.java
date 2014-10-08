package net.amigocraft.pore.implementation.entity.minecart;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.minecart.PoweredMinecart;

public class PorePoweredMinecart extends PoreMinecart implements PoweredMinecart {

	//TODO: make constructor as specific as possible
	protected PorePoweredMinecart(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PorePoweredMinecart of(org.spongepowered.api.entity.Entity handle){
		return (PorePoweredMinecart) PoreMinecart.of(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.MINECART_FURNACE;
	}

}
