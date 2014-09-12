package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Villager;

public class PoreVillager extends PoreAgeable implements Villager {

	// TODO: Bridge

	public PoreVillager(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
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
