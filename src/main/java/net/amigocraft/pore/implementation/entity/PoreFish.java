package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Fish;
import org.bukkit.entity.LivingEntity;
import org.bukkit.projectiles.ProjectileSource;

public class PoreFish extends AbstractProjectile implements Fish {

    // TODO: Bridge

	public PoreFish(org.spongepowered.api.entity.Entity handle) { //TODO: accept most specfific type
		super(handle);
	}

    @Override
    public double getBiteChance() {
        return 0;
    }

    @Override
    public void setBiteChance(double chance) throws IllegalArgumentException {

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
