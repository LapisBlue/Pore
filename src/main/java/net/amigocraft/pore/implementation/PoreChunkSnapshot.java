package net.amigocraft.pore.implementation;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.ChunkSnapshot;
import org.bukkit.block.Biome;

//TODO: skeleton implementation

//TODO: skeleton implementation

public class PoreChunkSnapshot implements ChunkSnapshot {

	@Override
	public int getX() {
		return 0;
	}

	@Override
	public int getZ() {
		return 0;
	}

	@Override
	public String getWorldName() {
		throw new NotImplementedException();
	}

	@Override
	public int getBlockTypeId(int x, int y, int z) {
		return 0;
	}

	@Override
	public int getBlockData(int x, int y, int z) {
		return 0;
	}

	@Override
	public int getBlockSkyLight(int x, int y, int z) {
		return 0;
	}

	@Override
	public int getBlockEmittedLight(int x, int y, int z) {
		return 0;
	}

	@Override
	public int getHighestBlockYAt(int x, int z) {
		return 0;
	}

	@Override
	public Biome getBiome(int x, int z) {
		throw new NotImplementedException();
	}

	@Override
	public double getRawBiomeTemperature(int x, int z) {
		return 0;
	}

	@Override
	public double getRawBiomeRainfall(int x, int z) {
		return 0;
	}

	@Override
	public long getCaptureFullTime() {
		return 0;
	}

	@Override
	public boolean isSectionEmpty(int sy) {
		return false;
	}

	//TODO: Placeholder class, may just call PoreChunk's methods
}
