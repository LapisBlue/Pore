package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.SmallFireball;

public class PoreSmallFireball extends PoreFireball implements SmallFireball {

	//TODO: make constructor as specific as possible
	protected PoreSmallFireball(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreSmallFireball of(org.spongepowered.api.entity.Entity handle){
		return (PoreSmallFireball)PoreFireball.of(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.SMALL_FIREBALL;
	}

}
