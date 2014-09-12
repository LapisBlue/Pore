package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Hanging;

public class PoreHanging extends PoreEntity implements Hanging {

	// TODO: Bridge

	public PoreHanging(org.spongepowered.api.entity.Entity handle) { //TODO: accept most specfific type
		super(handle);
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
