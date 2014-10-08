package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fish;
import org.bukkit.entity.LivingEntity;
import org.bukkit.projectiles.ProjectileSource;

public class PoreFish extends PoreAbstractProjectile implements Fish {

	// TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreFish(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreFish of(org.spongepowered.api.entity.Entity handle){
		return (PoreFish)PoreAbstractProjectile.of(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.FISHING_HOOK;
	}

	@Override
	public double getBiteChance() {
		return 0;
	}

	@Override
	public void setBiteChance(double chance) throws IllegalArgumentException {
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
