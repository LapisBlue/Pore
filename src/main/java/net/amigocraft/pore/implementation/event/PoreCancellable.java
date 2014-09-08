package net.amigocraft.pore.implementation.event;

import org.bukkit.event.Cancellable;

// TODO: Bridge

public class PoreCancellable implements Cancellable {

	@Override
	public boolean isCancelled() {
		return false;
	}

	@Override
	public void setCancelled(boolean cancel) {
		
	}

}
