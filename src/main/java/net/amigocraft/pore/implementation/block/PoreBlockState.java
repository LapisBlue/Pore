package net.amigocraft.pore.implementation.block;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.spongepowered.api.block.BlockLoc;

import java.util.List;

public class PoreBlockState implements BlockState {
	private BlockLoc handle;

	public PoreBlockState(BlockLoc spongeBlock) {
		this.handle = spongeBlock;
	}

	@Override
	public Block getBlock() {
		return PoreBlock.of(handle);
	}

	@Override
	public MaterialData getData() {
		throw new NotImplementedException();
	}

	@Override
	public Material getType() {
		throw new NotImplementedException();
	}

	@Override
	public int getTypeId() {
		throw new NotImplementedException();
	}

	@Override
	public byte getLightLevel() {
		throw new NotImplementedException();
	}

	@Override
	public World getWorld() {
		throw new NotImplementedException();
	}

	@Override
	public int getX() {
		throw new NotImplementedException();
	}

	@Override
	public int getY() {
		throw new NotImplementedException();
	}

	@Override
	public int getZ() {
		throw new NotImplementedException();
	}

	@Override
	public Location getLocation() {
		throw new NotImplementedException();
	}

	@Override
	public Location getLocation(Location loc) {
		throw new NotImplementedException();
	}

	@Override
	public Chunk getChunk() {
		throw new NotImplementedException();
	}

	@Override
	public void setData(MaterialData data) {
		throw new NotImplementedException();
	}

	@Override
	public void setType(Material type) {
		throw new NotImplementedException();
	}

	@Override
	public boolean setTypeId(int type) {
		throw new NotImplementedException();
	}

	@Override
	public boolean update() {
		throw new NotImplementedException();
	}

	@Override
	public boolean update(boolean force) {
		throw new NotImplementedException();
	}

	@Override
	public boolean update(boolean force, boolean applyPhysics) {
		throw new NotImplementedException();
	}

	@Override
	public byte getRawData() {
		throw new NotImplementedException();
	}

	@Override
	public void setRawData(byte data) {
		throw new NotImplementedException();
	}

	@Override
	public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
		throw new NotImplementedException();
	}

	@Override
	public List<MetadataValue> getMetadata(String metadataKey) {
		throw new NotImplementedException();
	}

	@Override
	public boolean hasMetadata(String metadataKey) {
		throw new NotImplementedException();
	}

	@Override
	public void removeMetadata(String metadataKey, Plugin owningPlugin) {
		throw new NotImplementedException();
	}
}
