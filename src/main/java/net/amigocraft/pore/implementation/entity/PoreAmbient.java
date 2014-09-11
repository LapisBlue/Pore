package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Ambient;

public class PoreAmbient extends PoreLivingEntity implements Ambient {

	//TODO: Bridge

	public PoreAmbient(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
	}

}
