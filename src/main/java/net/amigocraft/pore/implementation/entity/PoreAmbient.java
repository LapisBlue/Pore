package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Ambient;

public class PoreAmbient extends PoreLivingEntity implements Ambient {

	//TODO: make constructor as specific as possible
	protected PoreAmbient(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreAmbient of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

}
