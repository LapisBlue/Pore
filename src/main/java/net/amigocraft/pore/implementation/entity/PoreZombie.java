package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Zombie;

public class PoreZombie extends PoreMonster implements Zombie {

	// TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreZombie(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreZombie of(org.spongepowered.api.entity.Entity handle){
		return (PoreZombie)PoreMonster.of(handle);
	}

	@Override
	public boolean isBaby() {
		return false;
	}

	@Override
	public void setBaby(boolean flag) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isVillager() {
		return false;
	}

	@Override
	public void setVillager(boolean flag) {
		throw new NotImplementedException();
	}
}
