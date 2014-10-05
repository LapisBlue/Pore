package net.amigocraft.pore.util;

import com.google.common.collect.MapMaker;

import java.util.Map;

public abstract class Cache<S, B> {

	private final Map<S, B> instances = new MapMaker().concurrencyLevel(1).weakKeys().weakValues().makeMap();

	public B get(S handle) {
		B result = instances.get(handle);
		if (result == null) {
			instances.put(handle, result = construct(handle));
		}
		return result;
	}

	protected abstract B construct(S handle);

}
