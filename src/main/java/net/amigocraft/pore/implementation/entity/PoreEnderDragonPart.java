package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.EnderDragonPart;
import org.bukkit.entity.Entity;

public class PoreEnderDragonPart extends PoreComplexEntityPart implements EnderDragonPart {

	//TODO: Bridge

	public PoreEnderDragonPart(org.spongepowered.api.entity.Entity handle) { //TODO: accept most specfific type
		super(handle);
	}

	@Override
	public void damage(double amount) {

	}

	@Override
	public void _INVALID_damage(int amount) {

	}

	@Override
	public void damage(double amount, Entity source) {

	}

	@Override
	public void _INVALID_damage(int amount, Entity source) {

	}

	@Override
	public double getHealth() {
		return 0;
	}

	@Override
	public int _INVALID_getHealth() {
		return 0;
	}

	@Override
	public void setHealth(double health) {

	}

	@Override
	public void _INVALID_setHealth(int health) {

	}

	@Override
	public double getMaxHealth() {
		return 0;
	}

	@Override
	public int _INVALID_getMaxHealth() {
		return 0;
	}

	@Override
	public void setMaxHealth(double health) {

	}

	@Override
	public void _INVALID_setMaxHealth(int health) {

	}

	@Override
	public void resetMaxHealth() {

	}
}
