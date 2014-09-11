package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Projectile;

public abstract class AbstractProjectile extends PoreEntity implements Projectile {

	//TODO: Bridge

	public AbstractProjectile(org.spongepowered.api.entity.Entity handle) { //TODO: accept most specfific type
		super(handle);
	}

}
