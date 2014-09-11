package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.CaveSpider;

public class PoreCaveSpider extends PoreSpider implements CaveSpider {

	// TODO: Bridge

	public PoreCaveSpider(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
	}

}
