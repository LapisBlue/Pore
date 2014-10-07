package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Wither;

public class PoreWither extends PoreMonster implements Wither {

	//TODO: make constructor as specific as possible
	protected PoreWither(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreWither of(org.spongepowered.api.entity.Entity handle){
		return (PoreWither)PoreMonster.of(handle);
	}

}
