package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EnderSignal;
import org.bukkit.entity.EntityType;

public class PoreEnderSignal extends PoreEntity implements EnderSignal {

	//TODO: make constructor as specific as possible
	protected PoreEnderSignal(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreEnderSignal of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.ENDER_SIGNAL;
	}

}
