package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Weather;

public class PoreWeather extends PoreEntity implements Weather {

	// TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreWeather(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreWeather of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.WEATHER;
	}

}
