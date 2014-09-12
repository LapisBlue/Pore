package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Golem;

public class PoreGolem extends PoreCreature implements Golem {

	// TODO: Bridge

	public PoreGolem(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
	}

}
