package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.EntityType;

public class PoreEnderCrystal extends PoreEntity implements EnderCrystal {

	//TODO: make constructor as specific as possible
	protected PoreEnderCrystal(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreEnderCrystal of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.ENDER_CRYSTAL;
	}

}
