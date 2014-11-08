package net.amigocraft.pore.implementation.scheduler;

import com.google.common.base.Preconditions;
import net.amigocraft.pore.Pore;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.plugin.IllegalPluginAccessException;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scheduler.BukkitWorker;
import org.spongepowered.api.service.scheduler.Scheduler;
import org.spongepowered.api.service.scheduler.Task;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class PoreBukkitScheduler implements BukkitScheduler {

	private static Scheduler getHandle() {
		return Pore.getGame().getScheduler();
	}

	private static void validate(Plugin plugin, Object task) {
		Preconditions.checkNotNull(plugin, "plugin");
		Preconditions.checkNotNull(task, "task");
		if (!plugin.isEnabled()) {
			throw new IllegalPluginAccessException("Plugin attempted to register task while disabled");
		}
	}


	@Override
	public <T> Future<T> callSyncMethod(Plugin plugin, Callable<T> task) {
		validate(plugin, task);
		throw new NotImplementedException();
	}

	@Override
	public void cancelTask(int taskId) {
		throw new NotImplementedException();
	}

	@Override
	public void cancelTasks(Plugin plugin) {
		for (Task task : getHandle().getScheduledTasks(Pore.getPlugin(plugin))) {
			task.cancel();
		}
	}

	@Override
	public void cancelAllTasks() {
		for (Task task : getHandle().getScheduledTasks()) {
			task.cancel();
		}
	}

	@Override
	public boolean isCurrentlyRunning(int taskId) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isQueued(int taskId) {
		throw new NotImplementedException();
	}

	@Override
	public List<BukkitWorker> getActiveWorkers() {
		throw new NotImplementedException();
	}

	@Override
	public List<BukkitTask> getPendingTasks() {
		throw new NotImplementedException();
	}

	@Override
	public BukkitTask runTask(Plugin plugin, Runnable task) throws IllegalArgumentException {
		validate(plugin, task);
		return new PoreBukkitTask(getHandle().runTask(Pore.getPlugin(plugin), task).get());
	}

	@Override
	public BukkitTask runTaskAsynchronously(Plugin plugin, Runnable task) throws IllegalArgumentException {
		validate(plugin, task);
		throw new NotImplementedException();
	}

	@Override
	public BukkitTask runTaskLater(Plugin plugin, Runnable task, long delay) throws IllegalArgumentException {
		validate(plugin, task);
		return new PoreBukkitTask(getHandle().runTaskAfter(Pore.getPlugin(plugin), task, delay).get());
	}

	@Override
	public BukkitTask runTaskLaterAsynchronously(Plugin plugin, Runnable task, long delay) throws IllegalArgumentException {
		validate(plugin, task);
		throw new NotImplementedException();
	}

	@Override
	public BukkitTask runTaskTimer(Plugin plugin, Runnable task, long delay, long period) throws IllegalArgumentException {
		validate(plugin, task);
		return new PoreBukkitTask(getHandle().runRepeatingTaskAfter(Pore.getPlugin(plugin), task, delay, period).get());
	}

	@Override
	public BukkitTask runTaskTimerAsynchronously(Plugin plugin, Runnable task, long delay, long period) throws IllegalArgumentException {
		validate(plugin, task);
		throw new NotImplementedException();
	}

	@Override
	public BukkitTask runTask(Plugin plugin, BukkitRunnable task) throws IllegalArgumentException {
		return runTask(plugin, (Runnable) task);
	}

	@Override
	public BukkitTask runTaskAsynchronously(Plugin plugin, BukkitRunnable task) throws IllegalArgumentException {
		return runTaskAsynchronously(plugin, (Runnable) task);
	}

	@Override
	public BukkitTask runTaskLater(Plugin plugin, BukkitRunnable task, long delay) throws IllegalArgumentException {
		return runTaskLater(plugin, (Runnable) task, delay);
	}

	@Override
	public BukkitTask runTaskLaterAsynchronously(Plugin plugin, BukkitRunnable task, long delay) throws IllegalArgumentException {
		return runTaskLaterAsynchronously(plugin, (Runnable) task, delay);
	}

	@Override
	public BukkitTask runTaskTimer(Plugin plugin, BukkitRunnable task, long delay, long period) throws IllegalArgumentException {
		return runTaskTimer(plugin, (Runnable) task, delay, period);
	}

	@Override
	public BukkitTask runTaskTimerAsynchronously(Plugin plugin, BukkitRunnable task, long delay, long period) throws IllegalArgumentException {
		return runTaskTimerAsynchronously(plugin, (Runnable) task, delay, period);
	}

	@Override
	public int scheduleSyncDelayedTask(Plugin plugin, Runnable task, long delay) {
		return runTaskLater(plugin, task, delay).getTaskId();
	}

	@Override
	public int scheduleSyncDelayedTask(Plugin plugin, BukkitRunnable task, long delay) {
		return runTaskLater(plugin, task, delay).getTaskId();
	}

	@Override
	public int scheduleSyncDelayedTask(Plugin plugin, Runnable task) {
		return runTask(plugin, task).getTaskId();
	}

	@Override
	public int scheduleSyncDelayedTask(Plugin plugin, BukkitRunnable task) {
		return runTask(plugin, task).getTaskId();
	}

	@Override
	public int scheduleSyncRepeatingTask(Plugin plugin, Runnable task, long delay, long period) {
		return runTaskTimer(plugin, task, delay, period).getTaskId();
	}

	@Override
	public int scheduleSyncRepeatingTask(Plugin plugin, BukkitRunnable task, long delay, long period) {
		return runTaskTimer(plugin, task, delay, period).getTaskId();
	}

	@Override
	public int scheduleAsyncDelayedTask(Plugin plugin, Runnable task, long delay) {
		return runTaskLaterAsynchronously(plugin, task, delay).getTaskId();
	}

	@Override
	public int scheduleAsyncDelayedTask(Plugin plugin, Runnable task) {
		return runTaskAsynchronously(plugin, task).getTaskId();
	}

	@Override
	public int scheduleAsyncRepeatingTask(Plugin plugin, Runnable task, long delay, long period) {
		return runTaskTimerAsynchronously(plugin, task, delay, period).getTaskId();
	}
}
