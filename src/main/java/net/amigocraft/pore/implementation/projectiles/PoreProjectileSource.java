package net.amigocraft.pore.implementation.projectiles;

import org.bukkit.entity.Projectile;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.util.Vector;

//TODO: Bridge

public class PoreProjectileSource implements ProjectileSource {

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> projectile) {
		return null;
	}

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> projectile, Vector velocity) {
		return null;
	}

}
