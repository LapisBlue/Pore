package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Blaze;
import org.bukkit.entity.EntityType;

public class PoreBlaze extends PoreMonster implements Blaze {

	//TODO: make constructor as specific as possible
	protected PoreBlaze(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreBlaze of(org.spongepowered.api.entity.Entity handle){
		return (PoreBlaze)PoreMonster.of(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.BLAZE;
	}

}
