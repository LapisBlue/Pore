package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.DyeColor;
import org.bukkit.entity.Sheep;

public class PoreSheep extends PoreAnimals implements Sheep {

	// TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreSheep(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreSheep of(org.spongepowered.api.entity.Entity handle){
		return (PoreSheep)PoreAnimals.of(handle);
	}

	@Override
	public boolean isSheared() {
		return false;
	}

	@Override
	public void setSheared(boolean flag) {
		throw new NotImplementedException();
	}

	@Override
	public DyeColor getColor() {
		throw new NotImplementedException();
	}

	@Override
	public void setColor(DyeColor color) {
		throw new NotImplementedException();
	}
}
