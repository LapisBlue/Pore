package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Squid;

public class PoreSquid extends PoreWaterMob implements Squid {

    // TODO: Bridge

	public PoreSquid(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
	}

}
