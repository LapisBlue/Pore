package net.amigocraft.pore.implementation.block;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.Collection;
import java.util.List;

public class PoreBlock implements Block {
	private org.spongepowered.api.block.Block handle;

	public PoreBlock(org.spongepowered.api.block.Block spongeBlock) {
		this.handle = spongeBlock;
	}

	@Override
	public byte getData() {
		return 0; //TODO: bridge
	}

	@Override
	public Block getRelative(int modX, int modY, int modZ) {
		throw new NotImplementedException(); //TODO: bridge
	}

	@Override
	public Block getRelative(BlockFace face) {
		throw new NotImplementedException(); //TODO: bridge
	}

	@Override
	public Block getRelative(BlockFace face, int distance) {
		throw new NotImplementedException(); //TODO: bridge
	}

	@Override
	public Material getType() {
		throw new NotImplementedException(); //TODO: bridge
	}

	@Override
	public int getTypeId() {
		return 0; //TODO: bridge
	}

	@Override
	public byte getLightLevel() {
		return 0; //TODO: bridge
	}

	@Override
	public byte getLightFromSky() {
		return 0; //TODO: bridge
	}

	@Override
	public byte getLightFromBlocks() {
		return 0; //TODO: bridge
	}

	@Override
	public World getWorld() {
		throw new NotImplementedException(); //TODO: bridge
	}

	@Override
	public int getX() {
		return 0; //TODO: bridge
	}

	@Override
	public int getY() {
		return 0; //TODO: bridge
	}

	@Override
	public int getZ() {
		return 0; //TODO: bridge
	}

	@Override
	public Location getLocation() {
		throw new NotImplementedException(); //TODO: bridge
	}

	@Override
	public Location getLocation(Location loc) {
		throw new NotImplementedException(); //TODO: bridge
	}

	@Override
	public Chunk getChunk() {
		throw new NotImplementedException(); //TODO: bridge
	}

	@Override
	public void setData(byte data) {
		//TODO: bridge
	}

	@Override
	public void setData(byte data, boolean applyPhysics) {
		//TODO: bridge
	}

	@Override
	public void setType(Material type) {
		//TODO: bridge
	}

	@Override
	public boolean setTypeId(int type) {
		return false; //TODO: bridge //TODO: bridge
	}

	@Override
	public boolean setTypeId(int type, boolean applyPhysics) {
		return false; //TODO: bridge
	}

	@Override
	public boolean setTypeIdAndData(int type, byte data, boolean applyPhysics) {
		return false; //TODO: bridge
	}

	@Override
	public BlockFace getFace(Block block) {
		throw new NotImplementedException(); //TODO: bridge
	}

	@Override
	public PoreBlockState getState() {
		throw new NotImplementedException(); //TODO: bridge
	}

	@Override
	public Biome getBiome() {
		throw new NotImplementedException(); //TODO: bridge
	}

	@Override
	public void setBiome(Biome bio) {
		//TODO: bridge
	}

	@Override
	public boolean isBlockPowered() {
		return false; //TODO: bridge
	}

	@Override
	public boolean isBlockIndirectlyPowered() {
		return false; //TODO: bridge
	}

	@Override
	public boolean isBlockFacePowered(BlockFace face) {
		return false; //TODO: bridge
	}

	@Override
	public boolean isBlockFaceIndirectlyPowered(BlockFace face) {
		return false; //TODO: bridge
	}

	@Override
	public int getBlockPower(BlockFace face) {
		return 0; //TODO: bridge
	}

	@Override
	public int getBlockPower() {
		return 0; //TODO: bridge
	}

	@Override
	public boolean isEmpty() {
		return false; //TODO: bridge
	}

	@Override
	public boolean isLiquid() {
		return false; //TODO: bridge
	}

	@Override
	public double getTemperature() {
		return 0; //TODO: bridge
	}

	@Override
	public double getHumidity() {
		return 0; //TODO: bridge
	}

	@Override
	public PistonMoveReaction getPistonMoveReaction() {
		throw new NotImplementedException(); //TODO: bridge
	}

	@Override
	public boolean breakNaturally() {
		return false; //TODO: bridge
	}

	@Override
	public boolean breakNaturally(ItemStack tool) {
		return false; //TODO: bridge
	}

	@Override
	public Collection<ItemStack> getDrops() {
		throw new NotImplementedException(); //TODO: bridge
	}

	@Override
	public Collection<ItemStack> getDrops(ItemStack tool) {
		throw new NotImplementedException(); //TODO: bridge
	}

	@Override
	public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
		//TODO: bridge
	}

	@Override
	public List<MetadataValue> getMetadata(String metadataKey) {
		throw new NotImplementedException(); //TODO: bridge
	}

	@Override
	public boolean hasMetadata(String metadataKey) {
		return false; //TODO: bridge
	}

	@Override
	public void removeMetadata(String metadataKey, Plugin owningPlugin) {
		//TODO: bridge
	}

}
