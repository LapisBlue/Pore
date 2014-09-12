package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Ocelot;

public class PoreOcelot extends PoreTameableAnimal implements Ocelot {

	// TODO: Bridge

	public PoreOcelot(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
	}

	@Override
	public Type getCatType() {
		throw new NotImplementedException();
	}

	@Override
	public void setCatType(Type type) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isSitting() {
		return false;
	}

	@Override
	public void setSitting(boolean sitting) {
		throw new NotImplementedException();
	}
}
