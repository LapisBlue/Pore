package net.amigocraft.pore.implementation.inventory.meta;

import org.bukkit.inventory.meta.MapMeta;

// TODO: bridge

public class PoreMapMeta extends PoreItemMeta implements MapMeta {

	@Override
	public boolean isScaling() {
		return false;
	}

	@Override
	public void setScaling(boolean value) {

	}

	@Override
	public MapMeta clone() {
		return null;
	}

}