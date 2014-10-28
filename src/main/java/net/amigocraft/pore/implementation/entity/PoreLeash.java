package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LeashHitch;

public class PoreLeash extends PoreHanging implements LeashHitch {

	//TODO: make constructor as specific as possible
	protected PoreLeash(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreLeash of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.LEASH_HITCH;
	}

}
