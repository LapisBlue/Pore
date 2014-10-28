package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Squid;

public class PoreSquid extends PoreWaterMob implements Squid {

	//TODO: make constructor as specific as possible
	protected PoreSquid(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreSquid of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.SQUID;
	}

}
