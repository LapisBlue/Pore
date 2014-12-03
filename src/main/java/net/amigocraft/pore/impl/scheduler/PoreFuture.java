package net.amigocraft.pore.impl.scheduler;

import com.google.common.util.concurrent.AbstractFuture;
import org.spongepowered.api.service.scheduler.Task;

import java.util.concurrent.Callable;

class PoreFuture<T> extends AbstractFuture<T> implements Runnable {
	private final Callable<T> callable;
	Task handle;

	PoreFuture(Callable<T> callable) {
		this.callable = callable;
	}

	@Override
	public void run() {
		try {
			set(callable.call());
		} catch (Exception e) {
			setException(e);
		}
	}

	@Override
	protected void interruptTask() {
		handle.cancel();
	}
}
