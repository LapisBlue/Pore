package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;
import org.bukkit.projectiles.ProjectileSource;

public class PoreProjectile extends AbstractProjectile implements Projectile {

	//TODO: Bridge

	public PoreProjectile(org.spongepowered.api.entity.Entity handle) { //TODO: accept most specfific type
		super(handle);
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
