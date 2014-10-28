package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.SmallFireball;

public class PoreSmallFireball extends PoreFireball implements SmallFireball {

	//TODO: make constructor as specific as possible
	protected PoreSmallFireball(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreSmallFireball of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.SMALL_FIREBALL;
	}

}
