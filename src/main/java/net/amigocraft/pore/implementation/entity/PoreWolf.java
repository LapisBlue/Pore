package net.amigocraft.pore.implementation.entity;

import org.bukkit.DyeColor;
import org.bukkit.entity.Wolf;

public class PoreWolf extends PoreTameableAnimal implements Wolf {

    // TODO: Bridge

	public PoreWolf(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
	}

    @Override
    public boolean isAngry() {
        return false;
    }

    @Override
    public void setAngry(boolean angry) {

    }

    @Override
    public boolean isSitting() {
        return false;
    }

    @Override
    public void setSitting(boolean sitting) {

    }

    @Override
    public DyeColor getCollarColor() {
        return null;
    }

    @Override
    public void setCollarColor(DyeColor color) {

    }
}
