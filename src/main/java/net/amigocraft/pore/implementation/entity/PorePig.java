package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pig;

public class PorePig extends PoreAnimals implements Pig {

	// TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PorePig(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PorePig of(org.spongepowered.api.entity.Entity handle){
		return (PorePig)PoreAnimals.of(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.PIG;
	}

	@Override
	public boolean hasSaddle() {
		throw new NotImplementedException();
	}

	@Override
	public void setSaddle(boolean saddled) {
		throw new NotImplementedException();
	}
}
