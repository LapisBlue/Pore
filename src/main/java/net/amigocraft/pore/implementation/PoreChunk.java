package net.amigocraft.pore.implementation;

import net.amigocraft.pore.implementation.block.PoreBlock;
import net.amigocraft.pore.implementation.entity.PoreEntity;
import net.amigocraft.pore.util.Cache;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;

import java.util.ArrayList;
import java.util.List;

//TODO: skeleton implementation

public class PoreChunk implements Chunk {

	protected org.spongepowered.api.world.Chunk handle;

	private static final Cache<org.spongepowered.api.world.Chunk, PoreChunk> CACHE = new Cache<org.spongepowered.api.world.Chunk, PoreChunk>() {
		@Override
		protected PoreChunk construct(org.spongepowered.api.world.Chunk spongeObject) {
			PoreChunk wrapper = new PoreChunk(spongeObject);
			return wrapper;
		}
	};

	protected PoreChunk(org.spongepowered.api.world.Chunk handle){
		this.handle = handle;
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreChunk of(org.spongepowered.api.world.Chunk handle) {
		return CACHE.get(handle);
	}

	@Override
	public int getX() {
		return handle.getPosition().getX();
	}

	@Override
	public int getZ() {
		return handle.getPosition().getZ();
	}

	@Override
	public World getWorld() {
		throw new NotImplementedException();
	}

	@Override
	public Block getBlock(int x, int y, int z) {
		return PoreBlock.of(handle.getBlock(x, y, z));
	}

	@Override
	public ChunkSnapshot getChunkSnapshot() {
		throw new NotImplementedException();
	}

	@Override
	public ChunkSnapshot getChunkSnapshot(boolean includeMaxblocky, boolean includeBiome, boolean includeBiomeTempRain) {
		throw new NotImplementedException();
	}

	@Override
	public Entity[] getEntities() {
		List<Entity> entities = new ArrayList<Entity>();
		for (org.spongepowered.api.entity.Entity e : handle.getEntities()){
			entities.add(PoreEntity.of(e));
		}
		return entities.toArray(new Entity[entities.size()]);
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
