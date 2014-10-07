package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Ghast;

public class PoreGhast extends PoreFlying implements Ghast {

	//TODO: make constructor as specific as possible
	protected PoreGhast(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreGhast of(org.spongepowered.api.entity.Entity handle){
		return (PoreGhast)PoreFlying.of(handle);
	}

}
