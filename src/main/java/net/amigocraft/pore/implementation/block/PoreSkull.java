package net.amigocraft.pore.implementation.block;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Skull;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.List;

//TODO: skeleton implementation

public class PoreSkull extends PoreBlockState implements Skull {

	@Override
	public boolean hasOwner(){
		return false;
	}

	@Override
	public String getOwner(){
		return null;
	}

	@Override
	public boolean setOwner(String name){
		return false;
	}

	@Override
	public BlockFace getRotation(){
		return null;
	}

	@Override
	public void setRotation(BlockFace rotation){

	}

	@Override
	public SkullType getSkullType(){
		return null;
	}

	@Override
	public void setSkullType(SkullType skullType){

	}
}
