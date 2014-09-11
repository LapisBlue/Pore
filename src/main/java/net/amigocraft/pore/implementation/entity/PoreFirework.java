package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

public class PoreFirework extends PoreEntity implements Firework {

    // TODO: Bridge

	public PoreFirework(org.spongepowered.api.entity.Entity handle) { //TODO: accept most specfific type
		super(handle);
	}

    @Override
    public FireworkMeta getFireworkMeta() {
        return null;
    }

    @Override
    public void setFireworkMeta(FireworkMeta meta) {

    }

    @Override
    public void detonate() {

    }
}
