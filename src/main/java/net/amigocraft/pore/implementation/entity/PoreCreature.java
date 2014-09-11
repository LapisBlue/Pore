package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Creature;
import org.bukkit.entity.LivingEntity;

public class PoreCreature extends PoreLivingEntity implements Creature {

	//TODO: Bridge

	public PoreCreature(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
	}

	@Override
	public void setTarget(LivingEntity target) {

	}

	@Override
	public LivingEntity getTarget() {
		return null;
	}
}
