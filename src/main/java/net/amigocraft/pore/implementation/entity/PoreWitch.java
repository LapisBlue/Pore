package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Witch;

public class PoreWitch extends PoreMonster implements Witch {

	//TODO: make constructor as specific as possible
	protected PoreWitch(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreWitch of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.WITCH;
	}

}
