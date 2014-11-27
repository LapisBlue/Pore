package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.DyeColorConverter;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.DyeColor;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.living.animal.Wolf;

public class PoreWolf extends PoreTameable implements org.bukkit.entity.Wolf {

	private static TypeConverter<Wolf, PoreWolf> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Wolf, PoreWolf> getWolfConverter() {
		if (converter == null) {
			converter = new TypeConverter<Wolf, PoreWolf>(){
				@Override
				protected PoreWolf convert(Wolf handle) {
					return new PoreWolf(handle);
				}
			};
		}
		return converter;
	}

	protected PoreWolf(Wolf handle) {
		super(handle);
	}

	@Override
	public Wolf getHandle() {
		return (Wolf)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreWolf of(Wolf handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.WOLF;
	}

	@Override
	public boolean isAngry() {
		throw new NotImplementedException(); //TODO
	}

	@Override
	public void setAngry(boolean angry) {
		throw new NotImplementedException(); //TODO
	}

	@Override
	public boolean isSitting() {
		return getHandle().isSitting();
	}

	@Override
	public void setSitting(boolean sitting) {
		getHandle().setSitting(sitting);
	}

	@Override
	public DyeColor getCollarColor() {
		return DyeColorConverter.of(getHandle().getColor());
	}

	@Override
	public void setCollarColor(DyeColor color) {
		getHandle().setColor(DyeColorConverter.of(color));
	}
}
