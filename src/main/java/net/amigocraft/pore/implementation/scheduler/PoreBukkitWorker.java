package net.amigocraft.pore.implementation.scheduler;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitWorker;

// TODO: Bridge

// TODO: Bridge

public class PoreBukkitWorker implements BukkitWorker {

	@Override
	public int getTaskId() {
		return 0;
	}

	@Override
	public Plugin getOwner() {
		throw new NotImplementedException();
	}

	@Override
	public Thread getThread() {
		throw new NotImplementedException();
	}

}
