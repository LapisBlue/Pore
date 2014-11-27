package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.living.monster.MagmaCube;
import org.spongepowered.api.entity.living.monster.Slime;

public class PoreSlime extends PoreLivingEntity implements org.bukkit.entity.Slime {

	private static TypeConverter<Slime, PoreSlime> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Slime, PoreSlime> getSlimeConverter() {
		if (converter == null) {
			converter = new TypeConverter<Slime, PoreSlime>(
					MagmaCube.class, PoreMagmaCube.getMagmaCubeConverter()
			){
				@Override
				protected PoreSlime convert(Slime handle) {
					return new PoreSlime(handle);
				}
			};
		}
		return converter;
	}

	protected PoreSlime(Slime handle) {
		super(handle);
	}

	@Override
	public Slime getHandle() {
		return (Slime)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreSlime of(Slime handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.SLIME;
	}

	@Override
	public int getSize() {
		return getHandle().getSize();
	}

	@Override
	public void setSize(int sz) {
		getHandle().setSize(sz);
	}
}
