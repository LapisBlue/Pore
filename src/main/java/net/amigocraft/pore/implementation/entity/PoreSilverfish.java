package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Silverfish;

public class PoreSilverfish extends PoreMonster implements Silverfish {

	//TODO: make constructor as specific as possible
	protected PoreSilverfish(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreSilverfish of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.SILVERFISH;
	}

}
