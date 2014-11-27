package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;

public class PoreArrow extends PoreProjectile implements Arrow {

	private static TypeConverter<org.spongepowered.api.entity.projectile.Arrow, PoreArrow> converter;

	static TypeConverter<org.spongepowered.api.entity.projectile.Arrow, PoreArrow> getArrowConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.entity.projectile.Arrow, PoreArrow>(){
				@Override
				protected PoreArrow convert(org.spongepowered.api.entity.projectile.Arrow handle) {
					return new PoreArrow(handle);
				}
			};
		}
		return converter;
	}

	//TODO: bridge

	protected PoreArrow(org.spongepowered.api.entity.projectile.Arrow handle) {
		super(handle);
	}

	@Override
	public org.spongepowered.api.entity.projectile.Arrow getHandle() {
		return (org.spongepowered.api.entity.projectile.Arrow)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreArrow of(org.spongepowered.api.entity.projectile.Arrow handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.ARROW;
	}

	@Override
	public int getKnockbackStrength() {
		return getHandle().getKnockbackStrength();
	}

	@Override
	public void setKnockbackStrength(int knockbackStrength) {
		getHandle().setKnockbackStrength(knockbackStrength);
	}

	@Override
	public boolean isCritical() {
		return getHandle().isCritical();
	}

	@Override
	public void setCritical(boolean critical) {
		getHandle().setCritical(critical);
	}

	@Override
	public boolean doesBounce() {
		throw new NotImplementedException();
	}

	@Override
	public void setBounce(boolean doesBounce) {
		throw new NotImplementedException();
	}

}
