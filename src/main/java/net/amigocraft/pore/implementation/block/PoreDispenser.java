package net.amigocraft.pore.implementation.block;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Dispenser;
import org.bukkit.inventory.Inventory;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.projectiles.BlockProjectileSource;

import java.util.List;

//TODO: skeleton implementation

public class PoreDispenser extends PoreBlockState implements Dispenser {

	@Override
	public BlockProjectileSource getBlockProjectileSource(){
		return null;
	}

	@Override
	public boolean dispense(){
		return false;
	}

	@Override
	public Inventory getInventory(){
		return null;
	}
}
