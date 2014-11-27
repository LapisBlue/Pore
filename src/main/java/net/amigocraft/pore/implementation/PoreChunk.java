package net.amigocraft.pore.implementation;

import com.google.common.collect.Collections2;
import net.amigocraft.pore.implementation.block.PoreBlock;
import net.amigocraft.pore.implementation.entity.PoreEntity;
import net.amigocraft.pore.util.converter.TypeConverter;
import net.amigocraft.pore.util.PoreWrapper;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;

import java.util.Collection;

//TODO: skeleton implementation

public class PoreChunk extends PoreWrapper<org.spongepowered.api.world.Chunk> implements Chunk {
	private static TypeConverter<org.spongepowered.api.world.Chunk, PoreChunk> converter;

	static TypeConverter<org.spongepowered.api.world.Chunk, PoreChunk> getConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.world.Chunk, PoreChunk>() {
				@Override
				protected PoreChunk convert(org.spongepowered.api.world.Chunk handle) {
					return new PoreChunk(handle);
				}
			};
		}

		return converter;
	}

	protected PoreChunk(org.spongepowered.api.world.Chunk handle){
		super(handle);
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreChunk of(org.spongepowered.api.world.Chunk handle) {
		return getConverter().apply(handle);
	}

	@Override
	public int getX() {
		return getHandle().getPosition().getX();
	}

	@Override
	public int getZ() {
		return getHandle().getPosition().getZ();
	}

	@Override
	public World getWorld() {
		throw new NotImplementedException();
	}

	@Override
	public Block getBlock(int x, int y, int z) {
		return PoreBlock.of(getHandle().getBlock(x, y, z));
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
		Collection<org.spongepowered.api.entity.Entity> entities = getHandle().getEntities();
		return Collections2.transform(entities, PoreEntity.getConverter()).toArray(new Entity[entities.size()]);
	}

	@Override
	public BlockState[] getTileEntities() {
		throw new NotImplementedException();
	}

	@Override
	public boolean isLoaded() {
		return load(true);
	}

	@Override
	public boolean load(boolean generate) {
		return getHandle().loadChunk(generate);
	}

	@Override
	public boolean load() {
		return load(true);
	}

	@Override
	public boolean unload(boolean save, boolean safe) {
		return getHandle().unloadChunk(); //TODO: parameters
	}

	@Override
	public boolean unload(boolean save) {
		return unload(save, false);
	}

	@Override
	public boolean unload() {
		return unload(true);
	}
}
