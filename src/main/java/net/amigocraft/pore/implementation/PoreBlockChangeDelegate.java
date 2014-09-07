package net.amigocraft.pore.implementation;

import org.bukkit.BlockChangeDelegate;

public class PoreBlockChangeDelegate implements BlockChangeDelegate {


	@Override
	public boolean setRawTypeId(int x, int y, int z, int typeId){
		return false; //TODO: bridge
	}

	@Override
	public boolean setRawTypeIdAndData(int x, int y, int z, int typeId, int data){
		return false; //TODO: bridge
	}

	@Override
	public boolean setTypeId(int x, int y, int z, int typeId){
		return false; //TODO: bridge
	}

	@Override
	public boolean setTypeIdAndData(int x, int y, int z, int typeId, int data){
		return false; //TODO: bridge
	}

	@Override
	public int getTypeId(int x, int y, int z){
		return 0; //TODO: bridge
	}

	@Override
	public int getHeight(){
		return 0; //TODO: bridge
	}

	@Override
	public boolean isEmpty(int x, int y, int z){
		return false; //TODO: bridge
	}
}
