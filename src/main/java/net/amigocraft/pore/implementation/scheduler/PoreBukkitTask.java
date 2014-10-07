package net.amigocraft.pore.implementation.scheduler;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

// TODO: Bridge

// TODO: Bridge

public class PoreBukkitTask implements BukkitTask {

	@Override
	public int getTaskId() {
		return 0;
	}

	@Override
	public Plugin getOwner() {
		throw new NotImplementedException();
	}

	@Override
	public boolean isSync() {
		return false;
	}

	@Override
	public void cancel() {
		throw new NotImplementedException();
	}

}
