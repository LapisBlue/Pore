package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Ambient;
import org.spongepowered.api.entity.LivingEntity;

public class PoreAmbient extends PoreLivingEntity implements Ambient {

	//TODO: make constructor as specific as possible
	protected PoreAmbient(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreAmbient of(org.spongepowered.api.entity.Entity handle){
		return (PoreAmbient)PoreLivingEntity.of(handle);
	}

}
