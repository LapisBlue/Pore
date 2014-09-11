package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Wither;

public class PoreWither extends PoreMonster implements Wither {

    // TODO: Bridge

	public PoreWither(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
	}

}
