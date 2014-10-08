package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.projectiles.ProjectileSource;

public class PoreArrow extends PoreAbstractProjectile implements Arrow {

	// TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreArrow(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreArrow of(org.spongepowered.api.entity.Entity handle){
		return (PoreArrow)PoreAbstractProjectile.of(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.ARROW;
	}

	@Override
	public int getKnockbackStrength() {
		return 0;
	}

	@Override
	public void setKnockbackStrength(int knockbackStrength) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isCritical() {
		return false;
	}

	@Override
	public void setCritical(boolean critical) {
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
		return false;
	}

	@Override
	public void setBounce(boolean doesBounce) {
		throw new NotImplementedException();
	}

}
