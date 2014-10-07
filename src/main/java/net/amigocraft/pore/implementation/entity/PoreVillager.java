package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Villager;

public class PoreVillager extends PoreAgeable implements Villager {

	// TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreVillager(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreVillager of(org.spongepowered.api.entity.Entity handle){
		return (PoreVillager)PoreAgeable.of(handle);
	}

	@Override
	public Profession getProfession() {
		throw new NotImplementedException();
	}

	@Override
	public void setProfession(Profession profession) {
		throw new NotImplementedException();
	}
}
