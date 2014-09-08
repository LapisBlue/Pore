package net.amigocraft.pore.implementation;

import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;

//TODO: skeleton implementation

public class PoreChunk implements Chunk {

	//TODO: reference Sponge's chunk implementation

	@Override
	public int getX() {
		return 0;
	}

	@Override
	public int getZ() {
		return 0;
	}

	@Override
	public World getWorld() {
		return null;
	}

	@Override
	public Block getBlock(int x, int y, int z) {
		return null;
	}

	@Override
	public ChunkSnapshot getChunkSnapshot() {
		return null;
	}

	@Override
	public ChunkSnapshot getChunkSnapshot(boolean includeMaxblocky, boolean includeBiome, boolean includeBiomeTempRain) {
		return null;
	}

	@Override
	public Entity[] getEntities() {
		return new Entity[0];
	}

	@Override
	public BlockState[] getTileEntities() {
		return new BlockState[0];
	}

	@Override
	public boolean isLoaded() {
		return false;
	}

	@Override
	public boolean load(boolean generate) {
		return false;
	}

	@Override
	public boolean load() {
		return false;
	}

	@Override
	public boolean unload(boolean save, boolean safe) {
		return false;
	}

	@Override
	public boolean unload(boolean save) {
		return false;
	}

	@Override
	public boolean unload() {
		return false;
	}
}
