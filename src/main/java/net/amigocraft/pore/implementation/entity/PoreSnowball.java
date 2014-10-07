package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Snowball;

public class PoreSnowball extends PoreProjectile implements Snowball {

	//TODO: make constructor as specific as possible
	protected PoreSnowball(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreSnowball of(org.spongepowered.api.entity.Entity handle){
		return (PoreSnowball)PoreProjectile.of(handle);
	}

}
