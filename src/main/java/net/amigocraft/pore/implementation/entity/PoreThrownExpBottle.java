package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ThrownExpBottle;

public class PoreThrownExpBottle extends PoreProjectile implements ThrownExpBottle {

	//TODO: make constructor as specific as possible
	protected PoreThrownExpBottle(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreThrownExpBottle of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.THROWN_EXP_BOTTLE;
	}

}
