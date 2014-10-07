package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Chicken;

public class PoreChicken extends PoreAnimals implements Chicken {

	//TODO: make constructor as specific as possible
	protected PoreChicken(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreChicken of(org.spongepowered.api.entity.Entity handle){
		return (PoreChicken)PoreAnimals.of(handle);
	}

}
