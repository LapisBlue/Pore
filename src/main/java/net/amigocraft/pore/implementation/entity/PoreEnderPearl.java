package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.EntityType;

public class PoreEnderPearl extends PoreProjectile implements EnderPearl {

	//TODO: make constructor as specific as possible
	protected PoreEnderPearl(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreEnderPearl of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.ENDER_PEARL;
	}

}
