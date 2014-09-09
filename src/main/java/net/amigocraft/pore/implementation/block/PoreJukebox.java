package net.amigocraft.pore.implementation.block;

import org.bukkit.Material;
import org.bukkit.block.Jukebox;

//TODO: skeleton implementation

public class PoreJukebox extends PoreBlockState implements Jukebox {
	public PoreJukebox(org.spongepowered.api.block.Block spongeBlock) {
		super(spongeBlock);
	}

	@Override
	public Material getPlaying() {
		return null;
	}

	@Override
	public void setPlaying(Material record) {

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
