package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Blaze;

public class PoreBlaze extends PoreMonster implements Blaze {

	// TODO: Bridge

	public PoreBlaze(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
	}

}
