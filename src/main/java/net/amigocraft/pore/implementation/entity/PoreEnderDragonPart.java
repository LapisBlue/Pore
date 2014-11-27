package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.EnderDragonPart;
import org.bukkit.entity.Entity;

public class PoreEnderDragonPart extends PoreComplexEntityPart implements EnderDragonPart {

	private static TypeConverter<org.spongepowered.api.entity.living.complex.EnderDragonPart, PoreEnderDragonPart> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<org.spongepowered.api.entity.living.complex.EnderDragonPart, PoreEnderDragonPart>
	getEnderDragonPartConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.entity.living.complex.EnderDragonPart, PoreEnderDragonPart>(){
				@Override
				protected PoreEnderDragonPart convert(org.spongepowered.api.entity.living.complex.EnderDragonPart handle) {
					return new PoreEnderDragonPart(handle);
				}
			};
		}
		return converter;
	}

	protected PoreEnderDragonPart(org.spongepowered.api.entity.living.complex.EnderDragonPart handle) {
		super(handle);
	}

	@Override
	public org.spongepowered.api.entity.living.complex.EnderDragonPart getHandle() {
		return (org.spongepowered.api.entity.living.complex.EnderDragonPart)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreEnderDragonPart of(org.spongepowered.api.entity.living.complex.EnderDragonPart handle) {
		return converter.apply(handle);
	}

	public EnderDragon getParent(){
		return PoreEnderDragon.of(getHandle().getParent());
	}

	@Override
	public void damage(double amount) {
		getParent().damage(amount);
	}

	@Override
	public void _INVALID_damage(int amount) {
		this.damage((double)amount);
	}

	@Override
	public void damage(double amount, Entity source) {
		getParent().damage(amount, source);
	}

	@Override
	public void _INVALID_damage(int amount, Entity source) {
		this.damage((double)amount, source);
	}

	@Override
	public double getHealth() {
		return getParent().getHealth();
	}

	@Override
	public int _INVALID_getHealth() {
		return (int)getHealth();
	}

	@Override
	public void setHealth(double health) {
		getParent().setHealth(health);
	}

	@Override
	public void _INVALID_setHealth(int health) {
		this.setHealth((double)health);
	}

	@Override
	public double getMaxHealth() {
		throw new NotImplementedException();
	}

	@Override
	public int _INVALID_getMaxHealth() {
		return (int)this.getMaxHealth();
	}

	@Override
	public void setMaxHealth(double health) {
		getParent().setMaxHealth(health);
	}

	@Override
	public void _INVALID_setMaxHealth(int health) {
		this.setMaxHealth((double)health);
	}

	@Override
	public void resetMaxHealth() {
		getParent().resetMaxHealth();
	}
}
