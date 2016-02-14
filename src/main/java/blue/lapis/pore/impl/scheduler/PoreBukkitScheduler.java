/*
 * Pore
 * Copyright (c) 2014-2015, Lapis <https://github.com/LapisBlue>
 *
 * The MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package blue.lapis.pore.impl.scheduler;

import blue.lapis.pore.Pore;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.MapMaker;
import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.plugin.IllegalPluginAccessException;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scheduler.BukkitWorker;
import org.spongepowered.api.scheduler.Scheduler;
import org.spongepowered.api.scheduler.Task;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class PoreBukkitScheduler implements BukkitScheduler {

    private static final int MS_PER_TICK = 50;

    private static final AtomicInteger id = new AtomicInteger();

    private final Map<Integer, Task> tasks = new MapMaker().weakValues().makeMap();

    private static Scheduler getScheduler() {
        return Pore.getGame().getScheduler();
    }

    private static Task.Builder newTask() {
        return getScheduler().createTaskBuilder();
    }

    private static void validate(Plugin plugin, Object task) {
        Preconditions.checkState(plugin != null, "Plugin is null");
        Preconditions.checkNotNull(task, "task");
        //noinspection ConstantConditions
        if (!plugin.isEnabled()) {
            throw new IllegalPluginAccessException("Plugin attempted to register task while disabled");
        }
    }

    public static long ticksToMillis(long ticks) {
        return ticks * MS_PER_TICK;
    }


    @Override
    public <T> Future<T> callSyncMethod(Plugin plugin, Callable<T> task) {
        validate(plugin, task);
        PoreFuture<T> future = new PoreFuture<>(task);
        future.handle = newTask().execute(future).submit(Pore.getPlugin(plugin));
        return future;
    }

    @Override
    public void cancelTask(int taskId) {
        Task task = this.tasks.get(taskId);
        if (task != null) {
            task.cancel(); // TODO: Result
        }
    }

    @Override
    public void cancelTasks(Plugin plugin) {
        getScheduler().getScheduledTasks(Pore.getPlugin(plugin)).forEach(Task::cancel);
    }

    @Override
    public void cancelAllTasks() {
        getScheduler().getScheduledTasks().forEach(Task::cancel);
    }

    @Override
    public boolean isCurrentlyRunning(int taskId) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean isQueued(int taskId) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public List<BukkitWorker> getActiveWorkers() {
        return ImmutableList.of();
    }

    @Override
    public List<BukkitTask> getPendingTasks() {
        throw new NotImplementedException("TODO");
    }

    private BukkitTask register(PoreBukkitTask task) {
        this.tasks.put(task.getTaskId(), task.getHandle());
        return task;
    }

    @Override
    public BukkitTask runTask(Plugin plugin, Runnable task) throws IllegalArgumentException {
        validate(plugin, task);
        return register(new PoreBukkitTask(newTask().execute(task).submit(Pore.getPlugin(plugin)), id.incrementAndGet()));
    }

    @Override
    public BukkitTask runTaskAsynchronously(Plugin plugin, Runnable task) throws IllegalArgumentException {
        validate(plugin, task);
        return register(new PoreBukkitTask(newTask().async().execute(task).submit(Pore.getPlugin(plugin)), id.incrementAndGet()));
    }

    @Override
    public BukkitTask runTaskLater(Plugin plugin, Runnable task, long delay) throws IllegalArgumentException {
        validate(plugin, task);
        return register(new PoreBukkitTask(newTask().delay(ticksToMillis(delay), TimeUnit.MILLISECONDS).execute(task)
                .submit(Pore.getPlugin(plugin)), id.incrementAndGet()));
    }

    @Override
    public BukkitTask runTaskLaterAsynchronously(Plugin plugin, Runnable task, long delay)
            throws IllegalArgumentException {
        validate(plugin, task);
        return register(new PoreBukkitTask(newTask().async().delay(ticksToMillis(delay), TimeUnit.MILLISECONDS).execute(task)
                .submit(Pore.getPlugin(plugin)), id.incrementAndGet()));
    }

    @Override
    public BukkitTask runTaskTimer(Plugin plugin, Runnable task, long delay, long period)
            throws IllegalArgumentException {
        validate(plugin, task);
        return register(new PoreBukkitTask(newTask().delay(ticksToMillis(delay), TimeUnit.MILLISECONDS)
                .interval(ticksToMillis(period), TimeUnit.MILLISECONDS).execute(task)
                .submit(Pore.getPlugin(plugin)), id.incrementAndGet()));
    }

    @Override
    public BukkitTask runTaskTimerAsynchronously(Plugin plugin, Runnable task, long delay, long period)
            throws IllegalArgumentException {
        validate(plugin, task);
        return register(new PoreBukkitTask(newTask().async()
                .delay(ticksToMillis(delay), TimeUnit.MILLISECONDS)
                .interval(ticksToMillis(period), TimeUnit.MILLISECONDS)
                .execute(task)
                .submit(Pore.getPlugin(plugin)), id.incrementAndGet()));
    }

    @SuppressWarnings("deprecation")
    @Override
    public BukkitTask runTask(Plugin plugin, BukkitRunnable task) throws IllegalArgumentException {
        return runTask(plugin, (Runnable) task);
    }

    @SuppressWarnings("deprecation")
    @Override
    public BukkitTask runTaskAsynchronously(Plugin plugin, BukkitRunnable task)
            throws IllegalArgumentException {
        return runTaskAsynchronously(plugin, (Runnable) task);
    }

    @SuppressWarnings("deprecation")
    @Override
    public BukkitTask runTaskLater(Plugin plugin, BukkitRunnable task, long delay)
            throws IllegalArgumentException {
        return runTaskLater(plugin, (Runnable) task, delay);
    }

    @SuppressWarnings("deprecation")
    @Override
    public BukkitTask runTaskLaterAsynchronously(Plugin plugin, BukkitRunnable task, long delay)
            throws IllegalArgumentException {
        return runTaskLaterAsynchronously(plugin, (Runnable) task, delay);
    }

    @SuppressWarnings("deprecation")
    @Override
    public BukkitTask runTaskTimer(Plugin plugin, BukkitRunnable task, long delay, long period)
            throws IllegalArgumentException {
        return runTaskTimer(plugin, (Runnable) task, delay, period);
    }

    @SuppressWarnings("deprecation")
    @Override
    public BukkitTask runTaskTimerAsynchronously(Plugin plugin, BukkitRunnable task, long delay, long period)
            throws IllegalArgumentException {
        return runTaskTimerAsynchronously(plugin, (Runnable) task, delay, period);
    }

    @Override
    public int scheduleSyncDelayedTask(Plugin plugin, Runnable task, long delay) {
        return runTaskLater(plugin, task, delay).getTaskId();
    }

    @SuppressWarnings("deprecation")
    @Override
    public int scheduleSyncDelayedTask(Plugin plugin, BukkitRunnable task, long delay) {
        return runTaskLater(plugin, task, delay).getTaskId();
    }

    @Override
    public int scheduleSyncDelayedTask(Plugin plugin, Runnable task) {
        return runTask(plugin, task).getTaskId();
    }

    @SuppressWarnings("deprecation")
    @Override
    public int scheduleSyncDelayedTask(Plugin plugin, BukkitRunnable task) {
        return runTask(plugin, task).getTaskId();
    }

    @Override
    public int scheduleSyncRepeatingTask(Plugin plugin, Runnable task, long delay, long period) {
        return runTaskTimer(plugin, task, delay, period).getTaskId();
    }

    @SuppressWarnings("deprecation")
    @Override
    public int scheduleSyncRepeatingTask(Plugin plugin, BukkitRunnable task, long delay, long period) {
        return runTaskTimer(plugin, task, delay, period).getTaskId();
    }

    @SuppressWarnings("deprecation")
    @Override
    public int scheduleAsyncDelayedTask(Plugin plugin, Runnable task, long delay) {
        return runTaskLaterAsynchronously(plugin, task, delay).getTaskId();
    }

    @SuppressWarnings("deprecation")
    @Override
    public int scheduleAsyncDelayedTask(Plugin plugin, Runnable task) {
        return runTaskAsynchronously(plugin, task).getTaskId();
    }

    @SuppressWarnings("deprecation")
    @Override
    public int scheduleAsyncRepeatingTask(Plugin plugin, Runnable task, long delay, long period) {
        return runTaskTimerAsynchronously(plugin, task, delay, period).getTaskId();
    }
}
