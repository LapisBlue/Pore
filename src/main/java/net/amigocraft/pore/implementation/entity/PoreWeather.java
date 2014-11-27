package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Weather;
import org.spongepowered.api.entity.weather.WeatherEffect;

public class PoreWeather extends PoreEntity implements Weather {

	private static TypeConverter<WeatherEffect, PoreWeather> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<WeatherEffect, PoreWeather> getWeatherConverter() {
		if (converter == null) {
			converter = new TypeConverter<WeatherEffect, PoreWeather>(){
				@Override
				protected PoreWeather convert(WeatherEffect handle) {
					return new PoreWeather(handle);
				}
			};
		}
		return converter;
	}

	protected PoreWeather(WeatherEffect handle) {
		super(handle);
	}

	@Override
	public WeatherEffect getHandle() {
		return (WeatherEffect)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreWeather of(WeatherEffect handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.WEATHER;
	}

}
