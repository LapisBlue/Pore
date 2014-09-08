package net.amigocraft.pore.implementation.scheduler;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future; 

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler; 
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scheduler.BukkitWorker;

public class PoreBukkitScheduler implements BukkitScheduler {
	
	@Override
	public int scheduleSyncDelayedTask(Plugin plugin, Runnable task, long delay) {
		return 0; // TODO: Bridge
	}
	
	@Override
	public int scheduleSyncDelayedTask(Plugin plugin, BukkitRunnable task, long delay) {
		return 0; // TODO: Bridge
	}
	
	@Override
	public int scheduleSyncDelayedTask(Plugin plugin, Runnable task) {
		return 0; // TODO: Bridge
	}
	
	@Override
	public int scheduleSyncDelayedTask(Plugin plugin, BukkitRunnable task) {
		return 0; // TODO: Bridge
	}
	
	@Override
	public int scheduleSyncRepeatingTask(Plugin plugin, Runnable task, long delay, long period) {
		return 0; // TODO: Bridge
	}
	
	@Override
	public int scheduleSyncRepeatingTask(Plugin plugin, BukkitRunnable task, long delay, long period) {
		return 0; // TODO: Bridge
	}
	
	@Override
	public int scheduleAsyncDelayedTask(Plugin plugin, Runnable task, long delay) {
		return 0; // TODO: Bridge
	}
	
	@Override
	public int scheduleAsyncDelayedTask(Plugin plugin, Runnable task) {
		return 0; // TODO: Bridge
	}
	
	@Override
	public int scheduleAsyncRepeatingTask(Plugin plugin, Runnable task, long delay, long period) {
		return 0; // TODO: Bridge
	}
	
	@Override
	public <T> Future<T> callSyncMethod(Plugin plugin, Callable<T> task) {
		return null; // TODO: Bridge
	}
	
	@Override
	public void cancelTask(int taskId) {
		// TODO: Bridge
	}
	
	@Override
	public void cancelTasks(Plugin plugin) {
		// TODO: Bridge
	}
	
	@Override
	public void cancelAllTasks() {
		// TODO: Bridge
	}
	
	@Override
	public boolean isCurrentlyRunning(int taskId) {
		return false; // TODO: Bridge
	}
	
	@Override
	public boolean isQueued(int taskId) {
		return false; // TODO: Bridge
	}
	
	@Override
	public List<BukkitWorker> getActiveWorkers() {
		return null; // TODO: Bridge
	}
	
	@Override
	public List<BukkitTask> getPendingTasks() {
		return null; // TODO: Bridge
	}
	
	@Override
	public BukkitTask runTask(Plugin plugin, Runnable task) throws IllegalArgumentException {
		return null; // TODO: Bridge
	}
	
	@Override
	public BukkitTask runTask(Plugin plugin, BukkitRunnable task) throws IllegalArgumentException {
		return null; // TODO: Bridge
	}
	
	@Override
	public BukkitTask runTaskAsynchronously(Plugin plugin, Runnable task) throws IllegalArgumentException {
		return null; // TODO: Bridge
	}
	
	@Override
	public BukkitTask runTaskAsynchronously(Plugin plugin, BukkitRunnable task) throws IllegalArgumentException {
		return null; // TODO: Bridge
	}
	
	@Override
	public BukkitTask runTaskLater(Plugin plugin, Runnable task, long delay) throws IllegalArgumentException {
		return null; // TODO: Bridge
	}
	
	@Override
	public BukkitTask runTaskLater(Plugin plugin, BukkitRunnable task, long delay) throws IllegalArgumentException {
		return null; // TODO: Bridge
	}
	
	@Override
	public BukkitTask runTaskLaterAsynchronously(Plugin plugin, Runnable task, long delay) throws IllegalArgumentException {
		return null; // TODO: Bridge
	}
	
	@Override
	public BukkitTask runTaskLaterAsynchronously(Plugin plugin, BukkitRunnable task, long delay) throws IllegalArgumentException {
		return null; // TODO: Bridge
	}
	
	@Override
	public BukkitTask runTaskTimer(Plugin plugin, Runnable task, long delay, long period) throws IllegalArgumentException {
		return null; // TODO: Bridge
	}
	
	@Override
	public BukkitTask runTaskTimer(Plugin plugin, BukkitRunnable task, long delay, long period) throws IllegalArgumentException {
		return null; // TODO: Bridge
	}
	
	@Override
	public BukkitTask runTaskTimerAsynchronously(Plugin plugin, Runnable task, long delay, long period) throws IllegalArgumentException {
		return null; // TODO: Bridge
	}
	
	@Override
	public BukkitTask runTaskTimerAsynchronously(Plugin plugin, BukkitRunnable task, long delay, long period) throws IllegalArgumentException {
		return null; // TODO: Bridge
	}
}
