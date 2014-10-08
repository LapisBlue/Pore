package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ocelot;

public class PoreOcelot extends PoreTameableAnimal implements Ocelot {

	// TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreOcelot(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreOcelot of(org.spongepowered.api.entity.Entity handle){
		return (PoreOcelot)PoreTameableAnimal.of(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.OCELOT;
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
