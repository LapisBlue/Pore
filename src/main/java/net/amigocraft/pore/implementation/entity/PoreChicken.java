package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Chicken;

public class PoreChicken extends PoreAnimals implements Chicken {

	//TODO: Bridge

	public PoreChicken(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
	}

}
