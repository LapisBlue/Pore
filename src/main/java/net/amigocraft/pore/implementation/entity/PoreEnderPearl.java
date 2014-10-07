package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.EnderPearl;

public class PoreEnderPearl extends PoreProjectile implements EnderPearl {

	//TODO: make constructor as specific as possible
	protected PoreEnderPearl(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreEnderPearl of(org.spongepowered.api.entity.Entity handle){
		return (PoreEnderPearl)PoreProjectile.of(handle);
	}

}
