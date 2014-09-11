package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Egg;

public class PoreEgg extends PoreProjectile implements Egg {

	//TODO: Bridge

	public PoreEgg(org.spongepowered.api.entity.Entity handle) { //TODO: accept most specfific type
		super(handle);
	}

}
