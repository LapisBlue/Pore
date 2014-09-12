package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
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
		throw new NotImplementedException();
	}

	@Override
	public ProjectileSource getShooter() {
		throw new NotImplementedException();
	}

	@Override
	public void _INVALID_setShooter(LivingEntity shooter) {
		throw new NotImplementedException();
	}

	@Override
	public void setShooter(ProjectileSource source) {
		throw new NotImplementedException();
	}

	@Override
	public boolean doesBounce() {
		return false;
	}

	@Override
	public void setBounce(boolean doesBounce) {
		throw new NotImplementedException();
	}
}
