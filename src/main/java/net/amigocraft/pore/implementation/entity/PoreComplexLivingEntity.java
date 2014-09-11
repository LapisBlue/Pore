package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.ComplexLivingEntity;

public abstract class PoreComplexLivingEntity extends PoreLivingEntity implements ComplexLivingEntity {

	//TODO: Bridge

	public PoreComplexLivingEntity(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
	}

}
