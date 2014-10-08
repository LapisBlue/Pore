package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Spider;

public class PoreSpider extends PoreMonster implements Spider {

	//TODO: make constructor as specific as possible
	protected PoreSpider(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreSpider of(org.spongepowered.api.entity.Entity handle){
		return (PoreSpider)PoreMonster.of(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.SPIDER;
	}

}
