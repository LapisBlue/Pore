package net.amigocraft.pore.implementation.entity;

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

    }

    @Override
    public DyeColor getColor() {
        return null;
    }

    @Override
    public void setColor(DyeColor color) {

    }
}
