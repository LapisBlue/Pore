package net.amigocraft.pore.implementation.block;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.Collection;
import java.util.List;

public class PoreBlock implements Block {
	
	//TODO: associate with Sponge's implementation of blocks
	
	@Override
	public byte getData(){
		return 0; //TODO: bridge
	}

	@Override
	public Block getRelative(int modX, int modY, int modZ){
		return null; //TODO: bridge
	}

	@Override
	public Block getRelative(BlockFace face){
		return null; //TODO: bridge
	}

	@Override
	public Block getRelative(BlockFace face, int distance){
		return null; //TODO: bridge
	}

	@Override
	public Material getType(){
		return null; //TODO: bridge
	}

	@Override
	public int getTypeId(){
		return 0; //TODO: bridge
	}

	@Override
	public byte getLightLevel(){
		return 0; //TODO: bridge
	}

	@Override
	public byte getLightFromSky(){
		return 0; //TODO: bridge
	}

	@Override
	public byte getLightFromBlocks(){
		return 0; //TODO: bridge
	}

	@Override
	public World getWorld(){
		return null; //TODO: bridge
	}

	@Override
	public int getX(){
		return 0; //TODO: bridge
	}

	@Override
	public int getY(){
		return 0; //TODO: bridge
	}

	@Override
	public int getZ(){
		return 0; //TODO: bridge
	}

	@Override
	public Location getLocation(){
		return null; //TODO: bridge
	}

	@Override
	public Location getLocation(Location loc){
		return null; //TODO: bridge
	}

	@Override
	public Chunk getChunk(){
		return null; //TODO: bridge
	}

	@Override
	public void setData(byte data){
		//TODO: bridge
	}

	@Override
	public void setData(byte data, boolean applyPhysics){
		//TODO: bridge
	}

	@Override
	public void setType(Material type){
		//TODO: bridge
	}

	@Override
	public boolean setTypeId(int type){
		return false; //TODO: bridge //TODO: bridge
	}

	@Override
	public boolean setTypeId(int type, boolean applyPhysics){
		return false; //TODO: bridge
	}

	@Override
	public boolean setTypeIdAndData(int type, byte data, boolean applyPhysics){
		return false; //TODO: bridge
	}

	@Override
	public BlockFace getFace(Block block){
		return null; //TODO: bridge
	}

	@Override
	public PoreBlockState getState(){
		return null; //TODO: bridge
	}

	@Override
	public Biome getBiome(){
		return null; //TODO: bridge
	}

	@Override
	public void setBiome(Biome bio){
		//TODO: bridge
	}

	@Override
	public boolean isBlockPowered(){
		return false; //TODO: bridge
	}

	@Override
	public boolean isBlockIndirectlyPowered(){
		return false; //TODO: bridge
	}

	@Override
	public boolean isBlockFacePowered(BlockFace face){
		return false; //TODO: bridge
	}

	@Override
	public boolean isBlockFaceIndirectlyPowered(BlockFace face){
		return false; //TODO: bridge
	}

	@Override
	public int getBlockPower(BlockFace face){
		return 0; //TODO: bridge
	}

	@Override
	public int getBlockPower(){
		return 0; //TODO: bridge
	}

	@Override
	public boolean isEmpty(){
		return false; //TODO: bridge
	}

	@Override
	public boolean isLiquid(){
		return false; //TODO: bridge
	}

	@Override
	public double getTemperature(){
		return 0; //TODO: bridge
	}

	@Override
	public double getHumidity(){
		return 0; //TODO: bridge
	}

	@Override
	public PistonMoveReaction getPistonMoveReaction(){
		return null; //TODO: bridge
	}

	@Override
	public boolean breakNaturally(){
		return false; //TODO: bridge
	}

	@Override
	public boolean breakNaturally(ItemStack tool){
		return false; //TODO: bridge
	}

	@Override
	public Collection<ItemStack> getDrops(){
		return null; //TODO: bridge
	}

	@Override
	public Collection<ItemStack> getDrops(ItemStack tool){
		return null; //TODO: bridge
	}

	@Override
	public void setMetadata(String metadataKey, MetadataValue newMetadataValue){
		//TODO: bridge
	}

	@Override
	public List<MetadataValue> getMetadata(String metadataKey){
		return null; //TODO: bridge
	}

	@Override
	public boolean hasMetadata(String metadataKey){
		return false; //TODO: bridge
	}

	@Override
	public void removeMetadata(String metadataKey, Plugin owningPlugin){
		//TODO: bridge
	}
	
}
