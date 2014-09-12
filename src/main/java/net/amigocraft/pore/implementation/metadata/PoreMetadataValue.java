package net.amigocraft.pore.implementation.metadata;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

public class PoreMetadataValue implements MetadataValue {

	// TODO: Bridge

	@Override
	public Object value() {
		throw new NotImplementedException();
	}

	@Override
	public int asInt() {
		return 0;
	}

	@Override
	public float asFloat() {
		return 0;
	}

	@Override
	public double asDouble() {
		return 0;
	}

	@Override
	public long asLong() {
		return 0;
	}

	@Override
	public short asShort() {
		return 0;
	}

	@Override
	public byte asByte() {
		return 0;
	}

	@Override
	public boolean asBoolean() {
		return false;
	}

	@Override
	public String asString() {
		throw new NotImplementedException();
	}

	@Override
	public Plugin getOwningPlugin() {
		throw new NotImplementedException();
	}

	@Override
	public void invalidate() {
		throw new NotImplementedException();
	}

}
