package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Giant;

public class PoreGiant extends PoreMonster implements Giant {

	// TODO: Bridge

	public PoreGiant(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
	}

}
