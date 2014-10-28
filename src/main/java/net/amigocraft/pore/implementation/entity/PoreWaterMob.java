package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.WaterMob;

public class PoreWaterMob extends PoreCreature implements WaterMob {

	//TODO: make constructor as specific as possible
	protected PoreWaterMob(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreWaterMob of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

}
