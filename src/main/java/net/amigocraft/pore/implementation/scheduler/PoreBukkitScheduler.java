package net.amigocraft.pore.implementation.scheduler;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scheduler.BukkitWorker;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

// TODO: Bridge

// TODO: Bridge

public class PoreBukkitScheduler implements BukkitScheduler {

	@Override
	public int scheduleSyncDelayedTask(Plugin plugin, Runnable task, long delay) {
		return 0;
	}

	@Override
	public int scheduleSyncDelayedTask(Plugin plugin, BukkitRunnable task, long delay) {
		return 0;
	}

	@Override
	public int scheduleSyncDelayedTask(Plugin plugin, Runnable task) {
		return 0;
	}

	@Override
	public int scheduleSyncDelayedTask(Plugin plugin, BukkitRunnable task) {
		return 0;
	}

	@Override
	public int scheduleSyncRepeatingTask(Plugin plugin, Runnable task, long delay, long period) {
		return 0;
	}

	@Override
	public int scheduleSyncRepeatingTask(Plugin plugin, BukkitRunnable task, long delay, long period) {
		return 0;
	}

	@Override
	public int scheduleAsyncDelayedTask(Plugin plugin, Runnable task, long delay) {
		return 0;
	}

	@Override
	public int scheduleAsyncDelayedTask(Plugin plugin, Runnable task) {
		return 0;
	}

	@Override
	public int scheduleAsyncRepeatingTask(Plugin plugin, Runnable task, long delay, long period) {
		return 0;
	}

	@Override
	public <T> Future<T> callSyncMethod(Plugin plugin, Callable<T> task) {
		throw new NotImplementedException();
	}

	@Override
	public void cancelTask(int taskId) {
		throw new NotImplementedException();
	}

	@Override
	public void cancelTasks(Plugin plugin) {
		throw new NotImplementedException();
	}

	@Override
	public void cancelAllTasks() {
		throw new NotImplementedException();
	}

	@Override
	public boolean isCurrentlyRunning(int taskId) {
		return false;
	}

	@Override
	public boolean isQueued(int taskId) {
		return false;
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
		throw new NotImplementedException();
	}

	@Override
	public BukkitTask runTask(Plugin plugin, BukkitRunnable task) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public BukkitTask runTaskAsynchronously(Plugin plugin, Runnable task) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public BukkitTask runTaskAsynchronously(Plugin plugin, BukkitRunnable task) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public BukkitTask runTaskLater(Plugin plugin, Runnable task, long delay) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public BukkitTask runTaskLater(Plugin plugin, BukkitRunnable task, long delay) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public BukkitTask runTaskLaterAsynchronously(Plugin plugin, Runnable task, long delay) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public BukkitTask runTaskLaterAsynchronously(Plugin plugin, BukkitRunnable task, long delay) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public BukkitTask runTaskTimer(Plugin plugin, Runnable task, long delay, long period) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public BukkitTask runTaskTimer(Plugin plugin, BukkitRunnable task, long delay, long period) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public BukkitTask runTaskTimerAsynchronously(Plugin plugin, Runnable task, long delay, long period) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public BukkitTask runTaskTimerAsynchronously(Plugin plugin, BukkitRunnable task, long delay, long period) throws IllegalArgumentException {
		throw new NotImplementedException();
	}
}
