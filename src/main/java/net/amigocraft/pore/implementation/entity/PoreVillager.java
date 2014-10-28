package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;

public class PoreVillager extends PoreAgeable implements Villager {

	// TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreVillager(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreVillager of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.VILLAGER;
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
