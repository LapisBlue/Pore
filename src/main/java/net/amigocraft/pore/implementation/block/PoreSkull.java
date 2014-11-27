package net.amigocraft.pore.implementation.block;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.SkullType;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Skull;
import org.spongepowered.api.block.BlockLoc;

//TODO: skeleton implementation

public class PoreSkull extends PoreBlockState implements Skull {
	public PoreSkull(BlockLoc spongeBlock) {
		super(spongeBlock);
	}

	@Override
	public boolean hasOwner() {
		throw new NotImplementedException();
	}

	@Override
	public String getOwner() {
		throw new NotImplementedException();
	}

	@Override
	public boolean setOwner(String name) {
		throw new NotImplementedException();
	}

	@Override
	public BlockFace getRotation() {
		throw new NotImplementedException();
	}

	@Override
	public void setRotation(BlockFace rotation) {
		throw new NotImplementedException();
	}

	@Override
	public SkullType getSkullType() {
		throw new NotImplementedException();
	}

	@Override
	public void setSkullType(SkullType skullType) {
		throw new NotImplementedException();
	}
}
