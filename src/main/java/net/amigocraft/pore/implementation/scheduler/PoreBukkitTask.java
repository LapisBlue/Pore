package net.amigocraft.pore.implementation.scheduler;

import net.amigocraft.pore.plugin.PorePluginContainer;
import net.amigocraft.pore.util.PoreWrapper;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import org.spongepowered.api.service.scheduler.Task;

public class PoreBukkitTask extends PoreWrapper<Task> implements BukkitTask {
	public PoreBukkitTask(Task handle) {
		super(handle);
	}

	@Override
	public int getTaskId() {
		throw new NotImplementedException(); // TODO
	}

	@Override
	public Plugin getOwner() {
		return ((PorePluginContainer) getHandle().getOwner()).getHandle();
	}

	@Override
	public boolean isSync() {
		throw new NotImplementedException(); // TODO
	}

	@Override
	public void cancel() {
		if (!getHandle().cancel()) {
			throw new RuntimeException("Failed to cancel task " + getTaskId());
		}
	}

}
