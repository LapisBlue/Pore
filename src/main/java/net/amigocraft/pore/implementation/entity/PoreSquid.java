package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Squid;

public class PoreSquid extends PoreWaterMob implements Squid {

	//TODO: make constructor as specific as possible
	protected PoreSquid(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreSquid of(org.spongepowered.api.entity.Entity handle){
		return (PoreSquid)PoreWaterMob.of(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.SQUID;
	}

}
