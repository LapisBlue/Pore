package net.amigocraft.pore.implementation.material;

import org.bukkit.block.BlockFace;
import org.bukkit.material.Attachable;

//TODO: Bridge

public class PoreAttachable extends PoreDirectional implements Attachable {

	@Override
	public BlockFace getAttachedFace() {
		return null;
	}

}
