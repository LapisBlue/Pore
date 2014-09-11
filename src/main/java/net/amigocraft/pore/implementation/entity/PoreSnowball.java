package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Snowball;

public class PoreSnowball extends PoreProjectile implements Snowball {

    // TODO: Bridge

	public PoreSnowball(org.spongepowered.api.entity.Entity handle) { //TODO: accept most specfific type
		super(handle);
	}

}
