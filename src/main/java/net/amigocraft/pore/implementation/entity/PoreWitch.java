package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Witch;

public class PoreWitch extends PoreMonster implements Witch {

    // TODO: Bridge

	public PoreWitch(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
	}

}
