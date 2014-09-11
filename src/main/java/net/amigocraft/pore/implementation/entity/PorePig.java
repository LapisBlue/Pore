package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Pig;

public class PorePig extends PoreAnimals implements Pig {

    // TODO: Bridge

	public PorePig(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
	}

    @Override
    public boolean hasSaddle() {
        return false;
    }

    @Override
    public void setSaddle(boolean saddled) {

    }
}
