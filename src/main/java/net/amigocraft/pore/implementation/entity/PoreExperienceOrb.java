package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.ExperienceOrb;

public class PoreExperienceOrb extends PoreEntity implements ExperienceOrb {

	//TODO: Bridge

	public PoreExperienceOrb(org.spongepowered.api.entity.Entity handle) { //TODO: accept most specfific type
		super(handle);
	}

	@Override
	public int getExperience() {
		return 0;
	}

	@Override
	public void setExperience(int value) {

	}
}
