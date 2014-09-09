package net.amigocraft.pore.implementation.block;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.List;

//TODO: skeleton implementation

public class PoreSign extends PoreBlockState implements Sign {

	@Override
	public String[] getLines() {
		return new String[0];
	}

	@Override
	public String getLine(int index) throws IndexOutOfBoundsException {
		return null;
	}

	@Override
	public void setLine(int index, String line) throws IndexOutOfBoundsException {

	}
}
