package net.amigocraft.pore.implementation.entity.minecart;

import org.bukkit.entity.minecart.ExplosiveMinecart;

public class PoreExplosiveMinecart extends PoreMinecart implements ExplosiveMinecart {

	//TODO: make constructor as specific as possible
	protected PoreExplosiveMinecart(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreExplosiveMinecart of(org.spongepowered.api.entity.Entity handle){
		return (PoreExplosiveMinecart)PoreMinecart.of(handle);
	}

}
