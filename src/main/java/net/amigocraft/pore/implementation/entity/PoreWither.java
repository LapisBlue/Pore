package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Wither;

public class PoreWither extends PoreMonster implements Wither {

	//TODO: make constructor as specific as possible
	protected PoreWither(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreWither of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.WITHER;
	}

}
