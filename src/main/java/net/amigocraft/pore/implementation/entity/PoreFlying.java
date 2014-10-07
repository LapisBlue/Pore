package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Flying;

public class PoreFlying extends PoreLivingEntity implements Flying {

	//TODO: make constructor as specific as possible
	protected PoreFlying(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreFlying of(org.spongepowered.api.entity.Entity handle){
		return (PoreFlying)PoreLivingEntity.of(handle);
	}
}
