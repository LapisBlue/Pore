package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Ageable;

public class PoreAgeable extends PoreCreature implements Ageable {

	//TODO: Bridge

	@Override
	public int getAge() {
		return 0;
	}

	@Override
	public void setAge(int age) {

	}

	@Override
	public void setAgeLock(boolean lock) {

	}

	@Override
	public boolean getAgeLock() {
		return false;
	}

	@Override
	public void setBaby() {

	}

	@Override
	public void setAdult() {

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

	}
}
