package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Animals;

public class PoreAnimals extends PoreAgeable implements Animals {

	//TODO: make constructor as specific as possible
	protected PoreAnimals(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreAnimals of(org.spongepowered.api.entity.Entity handle){
		return (PoreAnimals)PoreAgeable.of(handle);
	}

}
