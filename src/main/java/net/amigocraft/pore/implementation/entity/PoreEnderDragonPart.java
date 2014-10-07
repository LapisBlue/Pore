package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EnderDragonPart;
import org.bukkit.entity.Entity;

public class PoreEnderDragonPart extends PoreComplexEntityPart implements EnderDragonPart {

	//TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreEnderDragonPart(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreEnderDragonPart of(org.spongepowered.api.entity.Entity handle){
		return (PoreEnderDragonPart)PoreComplexEntityPart.of(handle);
	}

	@Override
	public void damage(double amount) {
		throw new NotImplementedException();
	}

	@Override
	public void _INVALID_damage(int amount) {
		throw new NotImplementedException();
	}

	@Override
	public void damage(double amount, Entity source) {
		throw new NotImplementedException();
	}

	@Override
	public void _INVALID_damage(int amount, Entity source) {
		throw new NotImplementedException();
	}

	@Override
	public double getHealth() {
		throw new NotImplementedException();
	}

	@Override
	public int _INVALID_getHealth() {
		throw new NotImplementedException();
	}

	@Override
	public void setHealth(double health) {
		throw new NotImplementedException();
	}

	@Override
	public void _INVALID_setHealth(int health) {
		throw new NotImplementedException();
	}

	@Override
	public double getMaxHealth() {
		throw new NotImplementedException();
	}

	@Override
	public int _INVALID_getMaxHealth() {
		throw new NotImplementedException();
	}

	@Override
	public void setMaxHealth(double health) {
		throw new NotImplementedException();
	}

	@Override
	public void _INVALID_setMaxHealth(int health) {
		throw new NotImplementedException();
	}

	@Override
	public void resetMaxHealth() {
		throw new NotImplementedException();
	}
}
