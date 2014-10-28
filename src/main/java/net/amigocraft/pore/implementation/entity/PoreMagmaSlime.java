package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.MagmaCube;

public class PoreMagmaSlime extends PoreSlime implements MagmaCube {

	//TODO: make constructor as specific as possible
	protected PoreMagmaSlime(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreMagmaSlime of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.MAGMA_CUBE;
	}

}
