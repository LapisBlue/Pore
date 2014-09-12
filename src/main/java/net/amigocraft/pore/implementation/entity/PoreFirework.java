package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

public class PoreFirework extends PoreEntity implements Firework {

	// TODO: Bridge

	public PoreFirework(org.spongepowered.api.entity.Entity handle) { //TODO: accept most specfific type
		super(handle);
	}

	@Override
	public FireworkMeta getFireworkMeta() {
		throw new NotImplementedException();
	}

	@Override
	public void setFireworkMeta(FireworkMeta meta) {
		throw new NotImplementedException();
	}

	@Override
	public void detonate() {
		throw new NotImplementedException();
	}
}
