package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.LivingEntity;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.util.Vector;

public class PoreFireball extends PoreAbstractProjectile implements Fireball {

	//TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreFireball(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreFireball of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.FIREBALL;
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
		throw new NotImplementedException();
	}

	@Override
	public void setIsIncendiary(boolean isIncendiary) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isIncendiary() {
		throw new NotImplementedException();
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
