package net.amigocraft.pore.util;

import com.google.common.collect.ImmutableMap;

import javax.annotation.Nullable;
import java.util.Map;

public abstract class ParentConverter<S, B> extends Converter<S, B> {
	private final ImmutableMap<Class<? extends S>, Converter<? extends S, ? extends B>> children;

	// We need some strange workarounds here to make it work on Java 6
	protected ParentConverter(Class<? extends S> type, Converter<? extends S, ? extends B> cache) {
		this.children = (ImmutableMap) ImmutableMap.of(type, cache);
	}

	protected ParentConverter(ImmutableMap<Class<? extends S>, Converter<? extends S, ? extends B>> children) {
		this.children = children;
	}

	@Nullable
	@Override
	public B apply(@Nullable S handle) {
		if (handle == null) return null;

		// Get the class of the sponge object
		Class<? extends S> spongeType = (Class<? extends S>) handle.getClass();

		// Check for the specific implementation first
		Converter<? extends S, ? extends B> child = children.get(spongeType);
		if (child != null) {
			// Use the specific cache directly
			return child.applyUnchecked(handle);
		}

		// We should still check if there is a more accurate implementation
		for (Map.Entry<Class<? extends S>, Converter<? extends S, ? extends B>> entry : children.entrySet()) {
			if (entry.getKey().isAssignableFrom(spongeType)) {
				// Use the more accurate cache instead
				return entry.getValue().applyUnchecked(handle);
			}
		}

		// We don't have any specific implementation for that type, so we'll use a generic one
		return super.apply(handle);
	}
}
