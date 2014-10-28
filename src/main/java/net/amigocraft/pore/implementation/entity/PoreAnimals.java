package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Animals;

public class PoreAnimals extends PoreAgeable implements Animals {

	//TODO: make constructor as specific as possible
	protected PoreAnimals(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreAnimals of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

}
