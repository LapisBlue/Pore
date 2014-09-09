package net.amigocraft.pore.implementation.block;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class PoreBlockState implements BlockState {
	private org.spongepowered.api.block.Block handle;
	
	public PoreBlockState(org.spongepowered.api.block.Block spongeBlock) {
		this.handle = spongeBlock;
	}

	@Override
	public Block getBlock() {
		return new PoreBlock(handle);
	}

	@Override
	public MaterialData getData() {
		return null;
	}

	@Override
	public Material getType() {
		return null;
	}

	@Override
	public int getTypeId() {
		return 0;
	}

	@Override
	public byte getLightLevel() {
		return 0;
	}

	@Override
	public World getWorld() {
		return null;
	}

	@Override
	public int getX() {
		return 0;
	}

	@Override
	public int getY() {
		return 0;
	}

	@Override
	public int getZ() {
		return 0;
	}

	@Override
	public Location getLocation() {
		return null;
	}

	@Override
	public Location getLocation(Location loc) {
		return null;
	}

	@Override
	public Chunk getChunk() {
		return null;
	}

	@Override
	public void setData(MaterialData data) {

	}

	@Override
	public void setType(Material type) {

	}

	@Override
	public boolean setTypeId(int type) {
		return false;
	}

	@Override
	public boolean update() {
		return false;
	}

	@Override
	public boolean update(boolean force) {
		return false;
	}

	@Override
	public boolean update(boolean force, boolean applyPhysics) {
		return false;
	}

	@Override
	public byte getRawData() {
		return 0;
	}

	@Override
	public void setRawData(byte data) {

	}

	@Override
	public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {

	}

	@Override
	public List<MetadataValue> getMetadata(String metadataKey) {
		return null;
	}

	@Override
	public boolean hasMetadata(String metadataKey) {
		return false;
	}

	@Override
	public void removeMetadata(String metadataKey, Plugin owningPlugin) {

	}
}
