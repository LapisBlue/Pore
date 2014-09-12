package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Enderman;
import org.bukkit.material.MaterialData;

public class PoreEnderman extends PoreMonster implements Enderman {

	//TODO: Bridge

	public PoreEnderman(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
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
