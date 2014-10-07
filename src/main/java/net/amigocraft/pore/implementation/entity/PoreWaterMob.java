package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.WaterMob;

public class PoreWaterMob extends PoreCreature implements WaterMob {

	//TODO: make constructor as specific as possible
	protected PoreWaterMob(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreWaterMob of(org.spongepowered.api.entity.Entity handle){
		return (PoreWaterMob)PoreCreature.of(handle);
	}

}
