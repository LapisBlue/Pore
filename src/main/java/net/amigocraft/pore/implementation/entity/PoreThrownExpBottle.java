package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.ThrownExpBottle;

public class PoreThrownExpBottle extends PoreProjectile implements ThrownExpBottle {

	//TODO: make constructor as specific as possible
	protected PoreThrownExpBottle(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreThrownExpBottle of(org.spongepowered.api.entity.Entity handle){
		return (PoreThrownExpBottle)PoreProjectile.of(handle);
	}

}
