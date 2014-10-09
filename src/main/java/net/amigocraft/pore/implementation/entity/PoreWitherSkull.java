package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.WitherSkull;

public class PoreWitherSkull extends PoreFireball implements WitherSkull {

	//TODO: make constructor as specific as possible
	protected PoreWitherSkull(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreWitherSkull of(org.spongepowered.api.entity.Entity handle){
		return (PoreWitherSkull)PoreFireball.of(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.WITHER_SKULL;
	}

	@Override
	public void setCharged(boolean charged) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isCharged() {
		throw new NotImplementedException();
	}
}
