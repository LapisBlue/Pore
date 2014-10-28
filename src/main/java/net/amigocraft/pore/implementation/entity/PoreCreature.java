package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Creature;
import org.bukkit.entity.LivingEntity;

public class PoreCreature extends PoreLivingEntity implements Creature {

	//TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreCreature(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreCreature of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public void setTarget(LivingEntity target) {
		throw new NotImplementedException();
	}

	@Override
	public LivingEntity getTarget() {
		throw new NotImplementedException();
	}
}
