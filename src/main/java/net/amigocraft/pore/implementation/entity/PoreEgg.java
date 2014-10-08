package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Egg;
import org.bukkit.entity.EntityType;

public class PoreEgg extends PoreProjectile implements Egg {

	//TODO: make constructor as specific as possible
	protected PoreEgg(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreEgg of(org.spongepowered.api.entity.Entity handle){
		return (PoreEgg)PoreProjectile.of(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.EGG;
	}

}
