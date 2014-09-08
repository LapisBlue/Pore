package net.amigocraft.pore.implementation.block;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Furnace;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.List;

//TODO: skeleton implementation

public class PoreFurnace extends PoreBlockState implements Furnace {

	@Override
	public short getBurnTime(){
		return 0;
	}

	@Override
	public void setBurnTime(short burnTime){

	}

	@Override
	public short getCookTime(){
		return 0;
	}

	@Override
	public void setCookTime(short cookTime){

	}

	@Override
	public FurnaceInventory getInventory(){
		return null;
	}
}
