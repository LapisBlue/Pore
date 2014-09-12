package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Flying;

public class PoreFlying extends PoreLivingEntity implements Flying {

	// TODO: Bridge

	public PoreFlying(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
	}
}
