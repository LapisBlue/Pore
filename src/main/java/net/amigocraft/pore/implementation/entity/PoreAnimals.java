package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Animals;

public class PoreAnimals extends PoreAgeable implements Animals {

	//TODO: Bridge

	public PoreAnimals(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
	}

}
