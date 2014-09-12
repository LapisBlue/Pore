package net.amigocraft.pore.implementation.projectiles;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.Block;
import org.bukkit.entity.Projectile;
import org.bukkit.projectiles.BlockProjectileSource;
import org.bukkit.util.Vector;

// TODO: Bridge

// TODO: Bridge

public class PoreBlockProjectileSource implements BlockProjectileSource {

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> projectile) {
		throw new NotImplementedException();
	}

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> projectile, Vector velocity) {
		throw new NotImplementedException();
	}

	@Override
	public Block getBlock() {
		throw new NotImplementedException();
	}

}
