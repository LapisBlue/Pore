package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Bat;

public class PoreBat extends PoreAmbient implements Bat {

	// TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreBat(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreBat of(org.spongepowered.api.entity.Entity handle){
		return (PoreBat)PoreAmbient.of(handle);
	}

	@Override
	public boolean isAwake() {
		return false;
	}

	@Override
	public void setAwake(boolean state) {
		throw new NotImplementedException();
	}

}
