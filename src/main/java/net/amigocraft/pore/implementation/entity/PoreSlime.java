package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Slime;

public class PoreSlime extends PoreLivingEntity implements Slime {

	// TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreSlime(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreSlime of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.SLIME;
	}

	@Override
	public int getSize() {
		throw new NotImplementedException();
	}

	@Override
	public void setSize(int sz) {
		throw new NotImplementedException();
	}
}
