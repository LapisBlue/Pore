package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Spider;

public class PoreSpider extends PoreMonster implements Spider {

	//TODO: Bridge

	public PoreSpider(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
	}

}
