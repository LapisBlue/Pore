package net.amigocraft.pore.implementation.scheduler;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

public class PoreBukkitTask implements BukkitTask {

	@Override
	public int getTaskId() {
		return 0;
	}

	@Override
	public Plugin getOwner() {
		return null;
	}

	@Override
	public boolean isSync() {
		return false;
	}

	@Override
	public void cancel() {
		
	}

}
