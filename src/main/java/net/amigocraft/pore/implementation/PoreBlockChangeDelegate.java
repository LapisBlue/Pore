package net.amigocraft.pore.implementation;

import org.bukkit.BlockChangeDelegate;

//TODO: skeleton implementation

public class PoreBlockChangeDelegate implements BlockChangeDelegate {

	@Override
	public boolean setRawTypeId(int x, int y, int z, int typeId) {
		return false;
	}

	@Override
	public boolean setRawTypeIdAndData(int x, int y, int z, int typeId, int data) {
		return false;
	}

	@Override
	public boolean setTypeId(int x, int y, int z, int typeId) {
		return false;
	}

	@Override
	public boolean setTypeIdAndData(int x, int y, int z, int typeId, int data) {
		return false;
	}

	@Override
	public int getTypeId(int x, int y, int z) {
		return 0;
	}

	@Override
	public int getHeight() {
		return 0;
	}

	@Override
	public boolean isEmpty(int x, int y, int z) {
		return false;
	}
}
