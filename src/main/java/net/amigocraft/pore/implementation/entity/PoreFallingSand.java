package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Material;
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
	public Material getMaterial() {
		throw new NotImplementedException();
	}

	@Override
	public int getBlockId() {
		return 0;
	}

	@Override
	public byte getBlockData() {
		return 0;
	}

	@Override
	public boolean getDropItem() {
		return false;
	}

	@Override
	public void setDropItem(boolean drop) {
		throw new NotImplementedException();
	}
}
