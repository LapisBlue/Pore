package net.amigocraft.pore.implementation.block;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.List;

//TODO: skeleton implementation

public class PoreChest extends PoreBlockState implements Chest {

	@Override
	public Inventory getBlockInventory() {
		return null;
	}

	@Override
	public Inventory getInventory() {
		return null;
	}
}
