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

import blue.lapis.pore.plugin.PorePluginContainer;
import blue.lapis.pore.util.PoreWrapper;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import org.spongepowered.api.service.scheduler.Task;

public class PoreBukkitTask extends PoreWrapper<Task> implements BukkitTask {

    private int id;

    public PoreBukkitTask(Task handle, int id) {
        super(handle);
        this.id = id; //TODO: verify the ID isn't being reassigned if an instance already exists
    }

    @Override
    public int getTaskId() {
        return this.id;
    }

    @Override
    public Plugin getOwner() {
        return ((PorePluginContainer) getHandle().getOwner()).getHandle();
    }

    @Override
    public boolean isSync() {
        return true;
    }

    @Override
    public void cancel() {
        if (!getHandle().cancel()) {
            throw new RuntimeException("Failed to cancel task " + getTaskId());
        }
    }

}
