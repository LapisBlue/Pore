package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Bat;
import org.bukkit.entity.EntityType;

public class PoreBat extends PoreAmbient implements Bat {

	// TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreBat(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreBat of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.BAT;
	}

	@Override
	public boolean isAwake() {
		throw new NotImplementedException();
	}

	@Override
	public void setAwake(boolean state) {
		throw new NotImplementedException();
	}

}
