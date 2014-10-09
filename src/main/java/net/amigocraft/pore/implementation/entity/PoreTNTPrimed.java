package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;

public class PoreTNTPrimed extends PoreEntity implements TNTPrimed {

	// TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreTNTPrimed(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreTNTPrimed of(org.spongepowered.api.entity.Entity handle){
		return (PoreTNTPrimed)PoreEntity.of(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.PRIMED_TNT;
	}

	@Override
	public void setFuseTicks(int fuseTicks) {
		throw new NotImplementedException();
	}

	@Override
	public int getFuseTicks() {
		throw new NotImplementedException();
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
		throw new NotImplementedException();
	}

	@Override
	public void setIsIncendiary(boolean isIncendiary) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isIncendiary() {
		throw new NotImplementedException();
	}
}
