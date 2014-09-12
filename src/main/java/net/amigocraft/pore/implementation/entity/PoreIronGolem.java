package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.IronGolem;

public class PoreIronGolem extends PoreGolem implements IronGolem {

	// TODO: Bridge

	public PoreIronGolem(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
	}

	@Override
	public boolean isPlayerCreated() {
		return false;
	}

	@Override
	public void setPlayerCreated(boolean playerCreated) {
		throw new NotImplementedException();
	}
}
