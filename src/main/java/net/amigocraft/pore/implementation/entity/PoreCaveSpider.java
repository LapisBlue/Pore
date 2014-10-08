package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.EntityType;

public class PoreCaveSpider extends PoreSpider implements CaveSpider {

	//TODO: make constructor as specific as possible
	protected PoreCaveSpider(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreCaveSpider of(org.spongepowered.api.entity.Entity handle){
		return (PoreCaveSpider)PoreSpider.of(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.CAVE_SPIDER;
	}

}
