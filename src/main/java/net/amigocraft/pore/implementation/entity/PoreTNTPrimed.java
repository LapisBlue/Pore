package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Entity;
import org.bukkit.entity.TNTPrimed;

public class PoreTNTPrimed extends PoreEntity implements TNTPrimed {

    // TODO: Bridge

	public PoreTNTPrimed(org.spongepowered.api.entity.Entity handle) { //TODO: accept most specfific type
		super(handle);
	}

    @Override
    public void setFuseTicks(int fuseTicks) {

    }

    @Override
    public int getFuseTicks() {
        return 0;
    }

    @Override
    public Entity getSource() {
        return null;
    }

    @Override
    public void setYield(float yield) {

    }

    @Override
    public float getYield() {
        return 0;
    }

    @Override
    public void setIsIncendiary(boolean isIncendiary) {

    }

    @Override
    public boolean isIncendiary() {
        return false;
    }
}
