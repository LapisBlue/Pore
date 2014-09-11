package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.PigZombie;

public class PorePigZombie extends PoreZombie implements PigZombie {

    // TODO: Bridge

	public PorePigZombie(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
	}

    @Override
    public int getAnger() {
        return 0;
    }

    @Override
    public void setAnger(int level) {

    }

    @Override
    public void setAngry(boolean angry) {

    }

    @Override
    public boolean isAngry() {
        return false;
    }
}
