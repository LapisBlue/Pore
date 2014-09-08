package net.amigocraft.pore.implementation.block;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Jukebox;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.List;

//TODO: skeleton implementation

public class PoreJukebox extends PoreBlockState implements Jukebox {

	@Override
	public Material getPlaying(){
		return null;
	}

	@Override
	public void setPlaying(Material record){

	}

	@Override
	public boolean isPlaying(){
		return false;
	}

	@Override
	public boolean eject(){
		return false;
	}
}
