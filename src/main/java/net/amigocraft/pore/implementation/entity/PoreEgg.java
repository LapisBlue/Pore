package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EntityType;

public class PoreEgg extends PoreProjectile implements Egg {

	//TODO: make constructor as specific as possible
	protected PoreEgg(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreEgg of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.EGG;
	}

}
