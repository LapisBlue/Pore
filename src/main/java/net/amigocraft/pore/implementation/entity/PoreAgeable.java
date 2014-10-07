package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Ageable;
import org.spongepowered.api.entity.LivingEntity;

public class PoreAgeable extends PoreCreature implements Ageable {

	//TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreAgeable(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreAgeable of(org.spongepowered.api.entity.Entity handle){
		return (PoreAgeable)PoreLivingEntity.of(handle);
	}

	@Override
	public int getAge() {
		return 0;
	}

	@Override
	public void setAge(int age) {
		throw new NotImplementedException();
	}

	@Override
	public void setAgeLock(boolean lock) {
		throw new NotImplementedException();
	}

	@Override
	public boolean getAgeLock() {
		return false;
	}

	@Override
	public void setBaby() {
		throw new NotImplementedException();
	}

	@Override
	public void setAdult() {
		throw new NotImplementedException();
	}

	@Override
	public boolean isAdult() {
		return false;
	}

	@Override
	public boolean canBreed() {
		return false;
	}

	@Override
	public void setBreed(boolean breed) {
		throw new NotImplementedException();
	}
}
