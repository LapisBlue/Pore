package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

public class PoreFirework extends PoreEntity implements Firework {

	// TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreFirework(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreFirework of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.FIREWORK;
	}

	@Override
	public FireworkMeta getFireworkMeta() {
		throw new NotImplementedException();
	}

	@Override
	public void setFireworkMeta(FireworkMeta meta) {
		throw new NotImplementedException();
	}

	@Override
	public void detonate() {
		throw new NotImplementedException();
	}
}
