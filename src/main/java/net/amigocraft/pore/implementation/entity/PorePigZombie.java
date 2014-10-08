package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.PigZombie;

public class PorePigZombie extends PoreZombie implements PigZombie {

	// TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PorePigZombie(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PorePigZombie of(org.spongepowered.api.entity.Entity handle){
		return (PorePigZombie)PoreZombie.of(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.PIG_ZOMBIE;
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
