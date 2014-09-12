package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.LightningStrike;

public class PoreLightningStrike extends PoreEntity implements LightningStrike {

	// TODO: Bridge

	public PoreLightningStrike(org.spongepowered.api.entity.Entity handle) { //TODO: accept most specfific type
		super(handle);
	}

	@Override
	public boolean isEffect() {
		return false;
	}
}
