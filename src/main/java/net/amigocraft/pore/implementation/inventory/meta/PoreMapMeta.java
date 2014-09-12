package net.amigocraft.pore.implementation.inventory.meta;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.inventory.meta.MapMeta;

// TODO: bridge

// TODO: bridge

public class PoreMapMeta extends PoreItemMeta implements MapMeta {

	@Override
	public boolean isScaling() {
		return false;
	}

	@Override
	public void setScaling(boolean value) {
		throw new NotImplementedException();
	}

	@Override
	public MapMeta clone() {
		throw new NotImplementedException();
	}

}