package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Silverfish;

public class PoreSilverfish extends PoreMonster implements Silverfish {

	//TODO: make constructor as specific as possible
	protected PoreSilverfish(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreSilverfish of(org.spongepowered.api.entity.Entity handle){
		return (PoreSilverfish)PoreMonster.of(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.SILVERFISH;
	}

}
