package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LightningStrike;
import org.spongepowered.api.entity.weather.Lightning;

public class PoreLightningStrike extends PoreEntity implements LightningStrike {

	private static TypeConverter<Lightning, PoreLightningStrike> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Lightning, PoreLightningStrike> getLightningStrikeConverter() {
		if (converter == null) {
			converter = new TypeConverter<Lightning, PoreLightningStrike>(){
				@Override
				protected PoreLightningStrike convert(Lightning handle) {
					return new PoreLightningStrike(handle);
				}
			};
		}
		return converter;
	}

	protected PoreLightningStrike(Lightning handle) {
		super(handle);
	}

	@Override
	public Lightning getHandle() {
		return (Lightning)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreLightningStrike of(Lightning handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.LIGHTNING;
	}

	@Override
	public boolean isEffect() {
		return getHandle().isEffect();
	}
}
