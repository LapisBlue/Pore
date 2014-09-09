package net.amigocraft.pore.implementation.block;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Dropper;
import org.bukkit.inventory.Inventory;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.List;

//TODO: wireframe implementation

public class PoreDropper extends PoreBlockState implements Dropper {
	public PoreDropper(org.spongepowered.api.block.Block spongeBlock) {
		super(spongeBlock);
	}

	@Override
	public void drop() {

	}

	@Override
	public Inventory getInventory() {
		return null;
	}
}
