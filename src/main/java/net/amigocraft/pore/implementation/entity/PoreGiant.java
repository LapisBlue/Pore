package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Giant;

public class PoreGiant extends PoreMonster implements Giant {

	//TODO: make constructor as specific as possible
	protected PoreGiant(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreGiant of(org.spongepowered.api.entity.Entity handle){
		return (PoreGiant)PoreMonster.of(handle);
	}

}
