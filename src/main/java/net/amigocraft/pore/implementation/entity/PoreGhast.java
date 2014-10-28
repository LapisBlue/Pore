package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ghast;

public class PoreGhast extends PoreFlying implements Ghast {

	//TODO: make constructor as specific as possible
	protected PoreGhast(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreGhast of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.GHAST;
	}

}
