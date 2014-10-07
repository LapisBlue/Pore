package net.amigocraft.pore.util;

import com.google.common.collect.MapMaker;

import java.util.Map;

/**
 * Contains a weak map between Sponge objects and their respective Pore wrappers.
 * This class allows for Pore to maintain a single wrapper for each object in Sponge, as opposed to multiple.
 * @param <S> The class of the Sponge object to be wrapped.
 * @param <B> The class of the Sponge class's corresponding wrapper in Pore.
 */
public abstract class Cache<S, B> {

	private final Map<S, B> instances = new MapMaker().concurrencyLevel(1).weakKeys().weakValues().makeMap();

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return The Pore wrapper for the given Sponge object (<b>handle</b>).
	 */
	public B get(S handle) {
		B result = instances.get(handle);
		if (result == null) {
			instances.put(handle, result = construct(handle));
		}
		return result;
	}

	public void put(S spongeObject, B bukkitObject){
		instances.put(spongeObject, bukkitObject);
	}

	protected abstract B construct(S handle);

}
