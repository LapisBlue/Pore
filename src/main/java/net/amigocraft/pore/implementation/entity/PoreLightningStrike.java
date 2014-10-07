package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.LightningStrike;

public class PoreLightningStrike extends PoreEntity implements LightningStrike {

	// TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreLightningStrike(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreLightningStrike of(org.spongepowered.api.entity.Entity handle){
		return (PoreLightningStrike)PoreEntity.of(handle);
	}

	@Override
	public boolean isEffect() {
		throw new NotImplementedException();
	}
}
