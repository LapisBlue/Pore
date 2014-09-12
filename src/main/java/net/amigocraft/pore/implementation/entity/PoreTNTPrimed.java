package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Entity;
import org.bukkit.entity.TNTPrimed;

public class PoreTNTPrimed extends PoreEntity implements TNTPrimed {

	// TODO: Bridge

	public PoreTNTPrimed(org.spongepowered.api.entity.Entity handle) { //TODO: accept most specfific type
		super(handle);
	}

	@Override
	public void setFuseTicks(int fuseTicks) {
		throw new NotImplementedException();
	}

	@Override
	public int getFuseTicks() {
		return 0;
	}

	@Override
	public Entity getSource() {
		throw new NotImplementedException();
	}

	@Override
	public void setYield(float yield) {
		throw new NotImplementedException();
	}

	@Override
	public float getYield() {
		return 0;
	}

	@Override
	public void setIsIncendiary(boolean isIncendiary) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isIncendiary() {
		return false;
	}
}
