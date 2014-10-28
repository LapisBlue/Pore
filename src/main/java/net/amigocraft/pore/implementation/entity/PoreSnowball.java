package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Snowball;

public class PoreSnowball extends PoreProjectile implements Snowball {

	//TODO: make constructor as specific as possible
	protected PoreSnowball(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreSnowball of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.SNOWBALL;
	}

}
