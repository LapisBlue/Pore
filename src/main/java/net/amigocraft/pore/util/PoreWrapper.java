package net.amigocraft.pore.util;

import com.google.common.base.Preconditions;

public abstract class PoreWrapper<T> {
	private final T handle;

	protected PoreWrapper(T handle) {
		this.handle = Preconditions.checkNotNull(handle, "handle");
	}

	public T getHandle() {
		return handle;
	}
}
