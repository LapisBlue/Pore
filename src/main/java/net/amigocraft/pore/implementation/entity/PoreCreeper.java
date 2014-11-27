package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;

public class PoreCreeper extends PoreMonster implements Creeper {

	private static TypeConverter<org.spongepowered.api.entity.living.monster.Creeper, PoreCreeper> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<org.spongepowered.api.entity.living.monster.Creeper, PoreCreeper> getCreeperConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.entity.living.monster.Creeper, PoreCreeper>(){
				@Override
				protected PoreCreeper convert(org.spongepowered.api.entity.living.monster.Creeper handle) {
					return new PoreCreeper(handle);
				}
			};
		}
		return converter;
	}

	protected PoreCreeper(org.spongepowered.api.entity.living.monster.Creeper handle) {
		super(handle);
	}

	@Override
	public org.spongepowered.api.entity.living.monster.Creeper getHandle() {
		return (org.spongepowered.api.entity.living.monster.Creeper)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreCreeper of(org.spongepowered.api.entity.living.monster.Creeper handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.CREEPER;
	}

	@Override
	public boolean isPowered() {
		return getHandle().isPowered();
	}

	@Override
	public void setPowered(boolean value) {
		getHandle().setPowered(value);
	}
}
