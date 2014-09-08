package net.amigocraft.pore.implementation.projectiles;

import org.bukkit.block.Block;
import org.bukkit.entity.Projectile;
import org.bukkit.projectiles.BlockProjectileSource;
import org.bukkit.util.Vector;

public class PoreBlockProjectileSource implements BlockProjectileSource {

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> projectile) {
		return null; //TODO Bridge
	}

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> projectile, Vector velocity) {
		return null; //TODO Bridge
	}

	@Override
	public Block getBlock() {
		return null; //TODO Bridge
	}

}
