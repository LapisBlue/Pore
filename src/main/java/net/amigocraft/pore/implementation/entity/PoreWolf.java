package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.DyeColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Wolf;

public class PoreWolf extends PoreTameableAnimal implements Wolf {

	// TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreWolf(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreWolf of(org.spongepowered.api.entity.Entity handle){
		return (PoreWolf)PoreTameableAnimal.of(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.WOLF;
	}

	@Override
	public boolean isAngry() {
		throw new NotImplementedException();
	}

	@Override
	public void setAngry(boolean angry) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isSitting() {
		throw new NotImplementedException();
	}

	@Override
	public void setSitting(boolean sitting) {
		throw new NotImplementedException();
	}

	@Override
	public DyeColor getCollarColor() {
		throw new NotImplementedException();
	}

	@Override
	public void setCollarColor(DyeColor color) {
		throw new NotImplementedException();
	}
}
