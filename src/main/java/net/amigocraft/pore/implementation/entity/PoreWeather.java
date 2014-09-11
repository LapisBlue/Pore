package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Weather;

public class PoreWeather extends PoreEntity implements Weather {

    // TODO: Bridge

	public PoreWeather(org.spongepowered.api.entity.Entity handle) { //TODO: accept most specfific type
		super(handle);
	}

}
