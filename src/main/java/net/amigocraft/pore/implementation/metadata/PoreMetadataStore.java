package net.amigocraft.pore.implementation.metadata;

import java.util.List;

import org.bukkit.metadata.MetadataStore;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

// TODO: Bridge

public class PoreMetadataStore<T> implements MetadataStore<T> {

	@Override
	public void setMetadata(T subject, String metadataKey, MetadataValue newMetadataValue) {
	}

	@Override
	public List<MetadataValue> getMetadata(T subject, String metadataKey) {
		return null;
	}

	@Override
	public boolean hasMetadata(T subject, String metadataKey) {
		return false;
	}

	@Override
	public void removeMetadata(T subject, String metadataKey, Plugin owningPlugin) {

	}

	@Override
	public void invalidateAll(Plugin owningPlugin) {

	}


}
