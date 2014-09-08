package net.amigocraft.pore.implementation.block;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BrewingStand;
import org.bukkit.inventory.BrewerInventory;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.List;

//TODO: skeleton implementation

public class PoreBrewingStand extends PoreBlockState implements BrewingStand {

	@Override
	public int getBrewingTime(){
		return 0;
	}

	@Override
	public void setBrewingTime(int brewTime){

	}

	@Override
	public BrewerInventory getInventory(){
		return null;
	}
}
