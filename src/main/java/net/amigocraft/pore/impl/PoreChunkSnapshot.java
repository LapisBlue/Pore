package net.amigocraft.pore.impl;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.ChunkSnapshot;
import org.bukkit.block.Biome;

//TODO: skeleton implementation

//TODO: skeleton implementation

public class PoreChunkSnapshot implements ChunkSnapshot {

	@Override
	public int getX() {
		throw new NotImplementedException();
	}

	@Override
	public int getZ() {
		throw new NotImplementedException();
	}

	@Override
	public String getWorldName() {
		throw new NotImplementedException();
	}

	@Override
	public int getBlockTypeId(int x, int y, int z) {
		throw new NotImplementedException();
	}

	@Override
	public int getBlockData(int x, int y, int z) {
		throw new NotImplementedException();
	}

	@Override
	public int getBlockSkyLight(int x, int y, int z) {
		throw new NotImplementedException();
	}

	@Override
	public int getBlockEmittedLight(int x, int y, int z) {
		throw new NotImplementedException();
	}

	@Override
	public int getHighestBlockYAt(int x, int z) {
		throw new NotImplementedException();
	}

	@Override
	public Biome getBiome(int x, int z) {
		throw new NotImplementedException();
	}

	@Override
	public double getRawBiomeTemperature(int x, int z) {
		throw new NotImplementedException();
	}

	@Override
	public double getRawBiomeRainfall(int x, int z) {
		throw new NotImplementedException();
	}

	@Override
	public long getCaptureFullTime() {
		throw new NotImplementedException();
	}

	@Override
	public boolean isSectionEmpty(int sy) {
		throw new NotImplementedException();
	}

	//TODO: Placeholder class, may just call PoreChunk's methods
}
