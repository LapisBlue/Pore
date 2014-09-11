package net.amigocraft.pore.implementation.entity;

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

	}

	@Override
	public Vector getDirection() {
		return null;
	}

	@Override
	public void setYield(float yield) {

	}

	@Override
	public float getYield() {
		return 0;
	}

	@Override
	public void setIsIncendiary(boolean isIncendiary) {

	}

	@Override
	public boolean isIncendiary() {
		return false;
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
