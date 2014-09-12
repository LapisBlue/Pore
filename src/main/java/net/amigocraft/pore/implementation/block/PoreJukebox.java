package net.amigocraft.pore.implementation.block;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Material;
import org.bukkit.block.Jukebox;

//TODO: skeleton implementation

//TODO: skeleton implementation

public class PoreJukebox extends PoreBlockState implements Jukebox {
	public PoreJukebox(org.spongepowered.api.block.Block spongeBlock) {
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
		return false;
	}

	@Override
	public boolean eject() {
		return false;
	}
}
