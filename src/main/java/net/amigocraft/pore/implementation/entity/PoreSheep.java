package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.DyeColor;
import org.bukkit.entity.Sheep;

public class PoreSheep extends PoreAnimals implements Sheep {

	// TODO: Bridge

	public PoreSheep(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
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
