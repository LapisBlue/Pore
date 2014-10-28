package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Ageable;

public class PoreAgeable extends PoreCreature implements Ageable {

	//TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreAgeable(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreAgeable of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public int getAge() {
		throw new NotImplementedException();
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
		throw new NotImplementedException();
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
		throw new NotImplementedException();
	}

	@Override
	public boolean canBreed() {
		throw new NotImplementedException();
	}

	@Override
	public void setBreed(boolean breed) {
		throw new NotImplementedException();
	}
}
