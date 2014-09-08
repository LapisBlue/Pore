package net.amigocraft.pore.implementation.block;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Skull;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class PoreSkull implements Skull {

	//TODO: associate with... something

	@Override
	public boolean hasOwner(){
		return false; //TODO: bridge
	}

	@Override
	public String getOwner(){
		return null; //TODO: bridge
	}

	@Override
	public boolean setOwner(String name){
		return false; //TODO: bridge
	}

	@Override
	public BlockFace getRotation(){
		return null; //TODO: bridge
	}

	@Override
	public void setRotation(BlockFace rotation){
		//TODO: bridge
	}

	@Override
	public SkullType getSkullType(){
		return null; //TODO: bridge
	}

	@Override
	public void setSkullType(SkullType skullType){
		//TODO: bridge
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
		return 0;
	}

	@Override
	public byte getLightLevel(){
		return 0;
	}

	@Override
	public World getWorld(){
		return null; //TODO: bridge
	}

	@Override
	public int getX(){
		return 0;
	}

	@Override
	public int getY(){
		return 0;
	}

	@Override
	public int getZ(){
		return 0;
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
		return 0;
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
