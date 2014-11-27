package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

public class PoreFirework extends PoreEntity implements Firework {

	private static TypeConverter<org.spongepowered.api.entity.projectile.Firework, PoreFirework> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<org.spongepowered.api.entity.projectile.Firework, PoreFirework> getFireworkConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.entity.projectile.Firework, PoreFirework>(){
				@Override
				protected PoreFirework convert(org.spongepowered.api.entity.projectile.Firework handle) {
					return new PoreFirework(handle);
				}
			};
		}
		return converter;
	}

	protected PoreFirework(org.spongepowered.api.entity.projectile.Firework handle) {
		super(handle);
	}

	@Override
	public org.spongepowered.api.entity.projectile.Firework getHandle() {
		return (org.spongepowered.api.entity.projectile.Firework)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreFirework of(org.spongepowered.api.entity.projectile.Firework handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.FIREWORK;
	}

	@Override
	public FireworkMeta getFireworkMeta() {
		throw new NotImplementedException(); //TODO
	}

	@Override
	public void setFireworkMeta(FireworkMeta meta) {
		throw new NotImplementedException(); //TODO
	}

	@Override
	public void detonate() {
		getHandle().detonate();
	}
}
