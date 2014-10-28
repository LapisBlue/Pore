package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.ComplexLivingEntity;

public abstract class PoreComplexLivingEntity extends PoreLivingEntity implements ComplexLivingEntity {

	//TODO: make constructor as specific as possible
	protected PoreComplexLivingEntity(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreComplexLivingEntity of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

}
