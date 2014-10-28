package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.EntityType;

public class PoreBlaze extends PoreMonster implements Blaze {

	//TODO: make constructor as specific as possible
	protected PoreBlaze(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreBlaze of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.BLAZE;
	}

}
