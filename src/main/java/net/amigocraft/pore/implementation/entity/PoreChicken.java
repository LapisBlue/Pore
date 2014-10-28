package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.EntityType;

public class PoreChicken extends PoreAnimals implements Chicken {

	//TODO: make constructor as specific as possible
	protected PoreChicken(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreChicken of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.CHICKEN;
	}

}
