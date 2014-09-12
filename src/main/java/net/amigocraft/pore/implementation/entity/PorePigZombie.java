package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
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
		throw new NotImplementedException();
	}

	@Override
	public void setAngry(boolean angry) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isAngry() {
		return false;
	}
}
