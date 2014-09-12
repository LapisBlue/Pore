package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.WaterMob;

public class PoreWaterMob extends PoreCreature implements WaterMob {

	// TODO: Bridge

	public PoreWaterMob(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
	}

}
