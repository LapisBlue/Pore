package net.amigocraft.pore.implementation.scheduler;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitWorker;

// TODO: Bridge

public class PoreBukkitWorker implements BukkitWorker {

	@Override
	public int getTaskId() {
		return 0;
	}

	@Override
	public Plugin getOwner() {
		return null;
	}

	@Override
	public Thread getThread() {
		return null;
	}

}
