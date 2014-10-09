package net.amigocraft.pore.implementation.metadata;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.metadata.MetadataStore;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.List;

// TODO: Bridge

// TODO: Bridge

public class PoreMetadataStore<T> implements MetadataStore<T> {

	@Override
	public void setMetadata(T subject, String metadataKey, MetadataValue newMetadataValue) {
	}

	@Override
	public List<MetadataValue> getMetadata(T subject, String metadataKey) {
		throw new NotImplementedException();
	}

	@Override
	public boolean hasMetadata(T subject, String metadataKey) {
		throw new NotImplementedException();
	}

	@Override
	public void removeMetadata(T subject, String metadataKey, Plugin owningPlugin) {
		throw new NotImplementedException();
	}

	@Override
	public void invalidateAll(Plugin owningPlugin) {
		throw new NotImplementedException();
	}


}
