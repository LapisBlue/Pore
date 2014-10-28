package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.EntityType;
import org.bukkit.material.MaterialData;

public class PoreEnderman extends PoreMonster implements Enderman {

	//TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreEnderman(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreEnderman of(org.spongepowered.api.entity.LivingEntity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.ENDERMAN;
	}

	@Override
	public MaterialData getCarriedMaterial() {
		throw new NotImplementedException();
	}

	@Override
	public void setCarriedMaterial(MaterialData material) {
		throw new NotImplementedException();
	}
}
