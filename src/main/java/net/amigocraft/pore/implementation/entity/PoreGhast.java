package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Ghast;

public class PoreGhast extends PoreFlying implements Ghast {

    // TODO: Bridge

	public PoreGhast(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
	}

}
