package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Projectile;

public abstract class PoreAbstractProjectile extends PoreEntity implements Projectile {

	//TODO: make constructor as specific as possible
	protected PoreAbstractProjectile(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreAbstractProjectile of(org.spongepowered.api.entity.Entity handle){
		return (PoreAbstractProjectile)PoreEntity.of(handle);
	}

}
