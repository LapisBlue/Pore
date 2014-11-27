package net.amigocraft.pore.util.converter;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapMaker;

import javax.annotation.Nullable;
import java.util.Map;

public abstract class TypeConverter<S, B> implements Function<S, B> {

	private final Map<S, B> instances = new MapMaker().concurrencyLevel(1).weakKeys().weakValues().makeMap();

	private final ImmutableMap<Class<? extends S>, TypeConverter<? extends S, ? extends B>> children;

	@SuppressWarnings("unchecked")
	protected TypeConverter() {
		this.children = (ImmutableMap)ImmutableMap.of();
	}

	// We need some strange workarounds here to make it work on Java 6
	@SuppressWarnings("unchecked")
	protected TypeConverter(Class<? extends S> type, TypeConverter<? extends S, ? extends B> cache) {
		this.children = (ImmutableMap)ImmutableMap.of(type, cache);
	}

	protected TypeConverter(ImmutableMap<Class<? extends S>, TypeConverter<? extends S, ? extends B>> children) {
		this.children = children;
	}

	@Nullable
	@Override
	@SuppressWarnings("unchecked")
	public B apply(@Nullable S handle) {
		if (handle == null) return null;

		// Get the class of the sponge object
		Class<? extends S> spongeType = (Class<? extends S>) handle.getClass();
		System.out.println("sponge class: " + spongeType);

		// Check for the specific implementation first
		TypeConverter<? extends S, ? extends B> child = children.get(spongeType);
		if (child != null) {
			System.out.println("child: " + child.getClass());
			// Use the specific cache directly
			return child.applyUnchecked(handle);
		}

		// We should still check if there is a more accurate implementation
		for (Map.Entry<Class<? extends S>, TypeConverter<? extends S, ? extends B>> entry : children.entrySet()) {
			if (entry.getKey().isAssignableFrom(spongeType)) {
				System.out.println("matched child: " + entry.getKey());
				// Use the more accurate cache instead
				return entry.getValue().applyUnchecked(handle);
			}
		}

		// We don't have any specific implementation for that type, so we'll use a generic one
		B result = instances.get(handle);
		if (result == null) {
			instances.put(handle, result = convert(handle));
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	protected B applyUnchecked(Object handle) {
		return apply((S) handle);
	}

	protected abstract B convert(S handle);

}
