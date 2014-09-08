package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Creature;
import org.bukkit.entity.LivingEntity;

public class PoreCreature extends PoreLivingEntity implements Creature {

	//TODO: Bridge

	// Implemented from Creature

	@Override
	public void setTarget(LivingEntity target) {

	}

	@Override
	public LivingEntity getTarget() {
		return null;
	}
}
