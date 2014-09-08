package net.amigocraft.pore.implementation.metadata;

import java.util.List;

import org.bukkit.metadata.MetadataValue;
import org.bukkit.metadata.Metadatable;
import org.bukkit.plugin.Plugin;

// TODO: Bridge

public class PoreMetadatable implements Metadatable {

	@Override
	public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
		
	}

	@Override
	public List<MetadataValue> getMetadata(String metadataKey) {
		return null;
	}

	@Override
	public boolean hasMetadata(String metadataKey) {
		return false;
	}

	@Override
	public void removeMetadata(String metadataKey, Plugin owningPlugin) {
		
	}

}
