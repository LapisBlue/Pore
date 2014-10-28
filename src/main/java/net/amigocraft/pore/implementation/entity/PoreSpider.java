package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Spider;

public class PoreSpider extends PoreMonster implements Spider {

	//TODO: make constructor as specific as possible
	protected PoreSpider(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreSpider of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.SPIDER;
	}

}
