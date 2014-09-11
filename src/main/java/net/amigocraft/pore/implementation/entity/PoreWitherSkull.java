package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.WitherSkull;

public class PoreWitherSkull extends PoreFireball implements WitherSkull {

    // TODO: Bridge

	public PoreWitherSkull(org.spongepowered.api.entity.Entity handle) { //TODO: accept most specfific type
		super(handle);
	}

    @Override
    public void setCharged(boolean charged) {

    }

    @Override
    public boolean isCharged() {
        return false;
    }
}
