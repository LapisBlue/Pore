package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.MushroomCow;

public class PoreMushroomCow extends PoreCow implements MushroomCow {

	//TODO: make constructor as specific as possible
	protected PoreMushroomCow(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreMushroomCow of(org.spongepowered.api.entity.Entity handle){
		return (PoreMushroomCow)PoreCow.of(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.MUSHROOM_COW;
	}

}
