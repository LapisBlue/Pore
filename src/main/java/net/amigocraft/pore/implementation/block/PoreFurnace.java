package net.amigocraft.pore.implementation.block;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Furnace;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class PoreFurnace implements Furnace {
	
	//TODO: associate with... something
	
	@Override
	public short getBurnTime(){
		return 0; //TODO: bridge
	}

	@Override
	public void setBurnTime(short burnTime){
		//TODO: bridge
	}

	@Override
	public short getCookTime(){
		return 0; //TODO: bridge
	}

	@Override
	public void setCookTime(short cookTime){
		//TODO: bridge
	}

	@Override
	public FurnaceInventory getInventory(){
		return null; //TODO: bridge
	}

	@Override
	public Block getBlock(){
		return null; //TODO: bridge
	}

	@Override
	public MaterialData getData(){
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
	public void setData(MaterialData data){
		//TODO: bridge
	}

	@Override
	public void setType(Material type){
		//TODO: bridge
	}

	@Override
	public boolean setTypeId(int type){
		return false; //TODO: bridge
	}

	@Override
	public boolean update(){
		return false; //TODO: bridge
	}

	@Override
	public boolean update(boolean force){
		return false; //TODO: bridge
	}

	@Override
	public boolean update(boolean force, boolean applyPhysics){
		return false; //TODO: bridge
	}

	@Override
	public byte getRawData(){
		return 0; //TODO: bridge
	}

	@Override
	public void setRawData(byte data){
		//TODO: bridge
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
