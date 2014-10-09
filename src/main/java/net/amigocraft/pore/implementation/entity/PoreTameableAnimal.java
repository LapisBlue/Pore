package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Tameable;

public class PoreTameableAnimal extends PoreAnimals implements Tameable, Creature {

	// TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreTameableAnimal(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreTameableAnimal of(org.spongepowered.api.entity.Entity handle){
		return (PoreTameableAnimal)PoreAnimals.of(handle);
	}

	@Override
	public boolean isTamed() {
		throw new NotImplementedException();
	}

	@Override
	public void setTamed(boolean tame) {
		throw new NotImplementedException();
	}

	@Override
	public AnimalTamer getOwner() {
		throw new NotImplementedException();
	}

	@Override
	public void setOwner(AnimalTamer tamer) {
		throw new NotImplementedException();
	}
}
