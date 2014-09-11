package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.projectiles.ProjectileSource;

public class PoreArrow extends AbstractProjectile implements Arrow {

	// TODO: Bridge

	public PoreArrow(org.spongepowered.api.entity.Entity handle) { //TODO: accept most specfific type
		super(handle);
	}

	@Override
	public int getKnockbackStrength() {
		return 0;
	}

	@Override
	public void setKnockbackStrength(int knockbackStrength) {

	}

	@Override
	public boolean isCritical() {
		return false;
	}

	@Override
	public void setCritical(boolean critical) {

	}

	@Override
	public LivingEntity _INVALID_getShooter() {
		return null;
	}

	@Override
	public ProjectileSource getShooter() {
		return null;
	}

	@Override
	public void _INVALID_setShooter(LivingEntity shooter) {

	}

	@Override
	public void setShooter(ProjectileSource source) {

	}

	@Override
	public boolean doesBounce() {
		return false;
	}

	@Override
	public void setBounce(boolean doesBounce) {

	}

}
