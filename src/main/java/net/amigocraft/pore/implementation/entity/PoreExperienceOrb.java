package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;

public class PoreExperienceOrb extends PoreEntity implements ExperienceOrb {

	//TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreExperienceOrb(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreExperienceOrb of(org.spongepowered.api.entity.Entity handle){
		return (PoreExperienceOrb)PoreEntity.of(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.EXPERIENCE_ORB;
	}

	@Override
	public int getExperience() {
		return 0;
	}

	@Override
	public void setExperience(int value) {
		throw new NotImplementedException();
	}
}
