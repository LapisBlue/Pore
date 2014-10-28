package net.amigocraft.pore.implementation.block;

import net.amigocraft.pore.util.Converter;
import net.amigocraft.pore.util.PoreWrapper;
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

public class PoreBlock extends PoreWrapper<org.spongepowered.api.block.Block> implements Block {
	private static Converter<org.spongepowered.api.block.Block, PoreBlock> converter;

	static Converter<org.spongepowered.api.block.Block, PoreBlock> getConverter() {
		if (converter == null) {
			converter = new Converter<org.spongepowered.api.block.Block, PoreBlock>() {
				@Override
				protected PoreBlock convert(org.spongepowered.api.block.Block handle) {
					return new PoreBlock(handle);
				}
			};
		}

		return converter;
	}

	private PoreBlock(org.spongepowered.api.block.Block handle) {
		super(handle);
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreBlock of(org.spongepowered.api.block.Block handle) {
		return getConverter().apply(handle);
	}

	@Override
	public byte getData() {
		throw new NotImplementedException();
	}

	@Override
	public Block getRelative(int modX, int modY, int modZ) {
		throw new NotImplementedException();
	}

	@Override
	public Block getRelative(BlockFace face) {
		throw new NotImplementedException();
	}

	@Override
	public Block getRelative(BlockFace face, int distance) {
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
	public byte getLightFromSky() {
		throw new NotImplementedException();
	}

	@Override
	public byte getLightFromBlocks() {
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
	public void setData(byte data) {
		throw new NotImplementedException();
	}

	@Override
	public void setData(byte data, boolean applyPhysics) {
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
	public boolean setTypeId(int type, boolean applyPhysics) {
		throw new NotImplementedException();
	}

	@Override
	public boolean setTypeIdAndData(int type, byte data, boolean applyPhysics) {
		throw new NotImplementedException();
	}

	@Override
	public BlockFace getFace(Block block) {
		throw new NotImplementedException();
	}

	@Override
	public PoreBlockState getState() {
		throw new NotImplementedException();
	}

	@Override
	public Biome getBiome() {
		throw new NotImplementedException();
	}

	@Override
	public void setBiome(Biome bio) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isBlockPowered() {
		throw new NotImplementedException();
	}

	@Override
	public boolean isBlockIndirectlyPowered() {
		throw new NotImplementedException();
	}

	@Override
	public boolean isBlockFacePowered(BlockFace face) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isBlockFaceIndirectlyPowered(BlockFace face) {
		throw new NotImplementedException();
	}

	@Override
	public int getBlockPower(BlockFace face) {
		throw new NotImplementedException();
	}

	@Override
	public int getBlockPower() {
		throw new NotImplementedException();
	}

	@Override
	public boolean isEmpty() {
		throw new NotImplementedException();
	}

	@Override
	public boolean isLiquid() {
		throw new NotImplementedException();
	}

	@Override
	public double getTemperature() {
		throw new NotImplementedException();
	}

	@Override
	public double getHumidity() {
		throw new NotImplementedException();
	}

	@Override
	public PistonMoveReaction getPistonMoveReaction() {
		throw new NotImplementedException();
	}

	@Override
	public boolean breakNaturally() {
		throw new NotImplementedException();
	}

	@Override
	public boolean breakNaturally(ItemStack tool) {
		throw new NotImplementedException();
	}

	@Override
	public Collection<ItemStack> getDrops() {
		throw new NotImplementedException();
	}

	@Override
	public Collection<ItemStack> getDrops(ItemStack tool) {
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
