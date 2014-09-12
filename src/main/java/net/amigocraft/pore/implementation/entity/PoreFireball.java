package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.LivingEntity;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.util.Vector;

public class PoreFireball extends AbstractProjectile implements Fireball {

	//TODO: Bridge

	public PoreFireball(org.spongepowered.api.entity.Entity handle) { //TODO: accept most specfific type
		super(handle);
	}

	@Override
	public void setDirection(Vector direction) {
		throw new NotImplementedException();
	}

	@Override
	public Vector getDirection() {
		throw new NotImplementedException();
	}

	@Override
	public void setYield(float yield) {
		throw new NotImplementedException();
	}

	@Override
	public float getYield() {
		return 0;
	}

	@Override
	public void setIsIncendiary(boolean isIncendiary) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isIncendiary() {
		return false;
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
