package net.amigocraft.pore.implementation.block;

import net.amigocraft.pore.implementation.PoreWorld;
import net.amigocraft.pore.util.*;
import net.amigocraft.pore.util.converter.DirectionConverter;
import net.amigocraft.pore.util.converter.vector.LocationFactory;
import net.amigocraft.pore.util.converter.MaterialConverter;
import net.amigocraft.pore.util.converter.TypeConverter;
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
import org.spongepowered.api.block.BlockType;

import java.util.Collection;
import java.util.List;

public class PoreBlock extends PoreWrapper<org.spongepowered.api.block.BlockLoc> implements Block {

	private static TypeConverter<org.spongepowered.api.block.BlockLoc, PoreBlock> converter;

	static TypeConverter<org.spongepowered.api.block.BlockLoc, PoreBlock> getConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.block.BlockLoc, PoreBlock>() {
				@Override
				protected PoreBlock convert(org.spongepowered.api.block.BlockLoc handle) {
					return new PoreBlock(handle);
				}
			};
		}

		return converter;
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreBlock of(org.spongepowered.api.block.BlockLoc handle) {
		return getConverter().apply(handle);
	}

	private PoreBlock(org.spongepowered.api.block.BlockLoc handle) {
		super(handle);
	}

	@Override
	public byte getData() {
		return getHandle().getState().getDataValue();
	}

	@Override
	public void setData(byte data) {
		getHandle().replaceWith(getHandle().getState().getType().getStateFromDataValue(data));
	}

	@Override
	public Block getRelative(int modX, int modY, int modZ) {
		return getWorld().getBlockAt(getX() + modX, getY() + modY, getZ() + modZ);
	}

	@Override
	public Block getRelative(BlockFace face) {
		return getRelative(face, 1);
	}

	@Override
	public Block getRelative(BlockFace face, int distance) {
		return getRelative(face.getModX() * distance, face.getModY() * distance, face.getModZ() * distance);
	}

	@Override
	public Material getType() {
		return MaterialConverter.toBukkitMaterial(getHandle().getState().getType());
	}

	@Override
	public void setType(Material type) {
		getHandle().replaceWith(MaterialConverter.toBlockType(type));
	}

	@Override
	public int getTypeId() {
		return MaterialConverter.toBukkitMaterial(getHandle().getState().getType()).getId();
	}

	@Override
	public byte getLightLevel() {
		return getHandle().getLuminance();
	}

	@Override
	public byte getLightFromSky() {
		return getHandle().getLuminanceFromSky();
	}

	@Override
	public byte getLightFromBlocks() {
		return getHandle().getLuminanceFromGround();
	}

	@Override
	public World getWorld() {
		return PoreWorld.of(getHandle().getExtent());
	}

	@Override
	public int getX() {
		return getHandle().getX();
	}

	@Override
	public int getY() {
		return getHandle().getY();
	}

	@Override
	public int getZ() {
		return getHandle().getZ();
	}

	@Override
	public Location getLocation() {
		return LocationFactory.of(getHandle().getLocation());
	}

	@Override
	public Location getLocation(Location loc) {
		return LocationFactory.apply(loc, getHandle().getLocation());
	}

	@Override
	public Chunk getChunk() {
		throw new NotImplementedException();
	}

	@Override
	public void setData(byte data, boolean applyPhysics) {
		// TODO: applyPhysics
		setData(data);
	}

	@Override
	public boolean setTypeId(int type) {
		BlockType blockType = MaterialConverter.toBlockType(Material.getMaterial(type));
		throw new NotImplementedException();
	}

	@Override
	public boolean setTypeId(int type, boolean applyPhysics) {
		// TODO: applyPhysics
		return setTypeId(type);
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
		return getHandle().isPowered();
	}

	@Override
	public boolean isBlockIndirectlyPowered() {
		return getHandle().isIndirectlyPowered();
	}

	@Override
	public boolean isBlockFacePowered(BlockFace face) {
		return getHandle().isFacePowered(DirectionConverter.of(face));
	}

	@Override
	public boolean isBlockFaceIndirectlyPowered(BlockFace face) {
		return getHandle().isFaceIndirectlyPowered(DirectionConverter.of(face));
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
