package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;
import org.bukkit.projectiles.ProjectileSource;

public class PoreProjectile extends PoreAbstractProjectile implements Projectile {

	//TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreProjectile(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreProjectile of(org.spongepowered.api.entity.Entity handle){
		return (PoreProjectile)PoreAbstractProjectile.of(handle);
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
		throw new NotImplementedException();
	}

	@Override
	public void setBounce(boolean doesBounce) {
		throw new NotImplementedException();
	}
}
