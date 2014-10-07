package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Golem;

public class PoreGolem extends PoreCreature implements Golem {

	//TODO: make constructor as specific as possible
	protected PoreGolem(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreGolem of(org.spongepowered.api.entity.Entity handle){
		return (PoreGolem)PoreCreature.of(handle);
	}

}
