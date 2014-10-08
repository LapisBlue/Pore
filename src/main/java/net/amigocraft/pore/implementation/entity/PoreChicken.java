package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Chicken;
import org.bukkit.entity.EntityType;

public class PoreChicken extends PoreAnimals implements Chicken {

	//TODO: make constructor as specific as possible
	protected PoreChicken(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreChicken of(org.spongepowered.api.entity.Entity handle){
		return (PoreChicken)PoreAnimals.of(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.CHICKEN;
	}

}
