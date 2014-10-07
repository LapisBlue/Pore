package net.amigocraft.pore.implementation.event;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.event.Cancellable;

// TODO: Bridge
public class PoreCancellable implements Cancellable {

	@Override
	public boolean isCancelled() {
		return false;
	}

	@Override
	public void setCancelled(boolean cancel) {
		throw new NotImplementedException();
	}

}
