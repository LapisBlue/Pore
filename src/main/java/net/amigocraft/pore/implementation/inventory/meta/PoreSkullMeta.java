package net.amigocraft.pore.implementation.inventory.meta;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.inventory.meta.SkullMeta;

// TODO: bridge

// TODO: bridge

public class PoreSkullMeta extends PoreItemMeta implements SkullMeta {

	@Override
	public String getOwner() {
		throw new NotImplementedException();
	}

	@Override
	public boolean hasOwner() {
		return false;
	}

	@Override
	public boolean setOwner(String owner) {
		return false;
	}

	@Override
	public SkullMeta clone() {
		throw new NotImplementedException();
	}

}