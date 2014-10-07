package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Hanging;

public class PoreHanging extends PoreEntity implements Hanging {

	// TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreHanging(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreHanging of(org.spongepowered.api.entity.Entity handle){
		return (PoreHanging)PoreEntity.of(handle);
	}

	@Override
	public boolean setFacingDirection(BlockFace face, boolean force) {
		return false;
	}

	@Override
	public BlockFace getAttachedFace() {
		throw new NotImplementedException();
	}

	@Override
	public void setFacingDirection(BlockFace face) {
		throw new NotImplementedException();
	}

	@Override
	public BlockFace getFacing() {
		throw new NotImplementedException();
	}
}
