package net.amigocraft.pore.implementation.block;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Material;
import org.bukkit.block.Jukebox;
import org.spongepowered.api.block.BlockLoc;

//TODO: skeleton implementation

public class PoreJukebox extends PoreBlockState implements Jukebox {
	public PoreJukebox(BlockLoc spongeBlock) {
		super(spongeBlock);
	}

	@Override
	public Material getPlaying() {
		throw new NotImplementedException();
	}

	@Override
	public void setPlaying(Material record) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isPlaying() {
		throw new NotImplementedException();
	}

	@Override
	public boolean eject() {
		throw new NotImplementedException();
	}
}
