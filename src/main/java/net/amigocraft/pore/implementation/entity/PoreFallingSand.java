package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingSand;

public class PoreFallingSand extends PoreEntity implements FallingSand {

	//TODO: make constructor as specific as possible
	protected PoreFallingSand(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreFallingSand of(org.spongepowered.api.entity.Entity handle){
		return (PoreFallingSand)PoreEntity.of(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.FALLING_BLOCK;
	}

	@Override
	public Material getMaterial() {
		throw new NotImplementedException();
	}

	@Override
	public int getBlockId() {
		throw new NotImplementedException();
	}

	@Override
	public byte getBlockData() {
		throw new NotImplementedException();
	}

	@Override
	public boolean getDropItem() {
		throw new NotImplementedException();
	}

	@Override
	public void setDropItem(boolean drop) {
		throw new NotImplementedException();
	}
}
