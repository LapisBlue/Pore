package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Creeper;

public class PoreCreeper extends PoreMonster implements Creeper {

	//TODO: Bridge

	public PoreCreeper(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
	}

	@Override
	public boolean isPowered() {
		return false;
	}

	@Override
	public void setPowered(boolean value) {
		throw new NotImplementedException();
	}
}
