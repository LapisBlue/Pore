/*
 * Pore
 * Copyright (c) 2014, Maxim Roncacé <http://bitbucket.org/mproncace>
 * Copyright (c) 2014, Lapis <https://github.com/LapisBlue>
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
package net.amigocraft.pore.event;

import net.amigocraft.pore.impl.PoreChunk;
import net.amigocraft.pore.impl.PoreWorld;
import org.bukkit.Bukkit;
import org.spongepowered.api.event.world.ChunkLoadEvent;
import org.spongepowered.api.event.world.ChunkUnloadEvent;
import org.spongepowered.api.event.world.WorldLoadEvent;
import org.spongepowered.api.event.world.WorldUnloadEvent;
import org.spongepowered.api.util.event.Subscribe;

public class WorldEventRelay {

    @Subscribe
    public void onChunkLoad(
            final ChunkLoadEvent event) { //TODO: instanceof WorldEvent according to Bukkit, but not Sponge
        //TODO: fix second argument when Sponge makes it possible
        Bukkit.getPluginManager().callEvent(
                new org.bukkit.event.world.ChunkLoadEvent(
                        PoreChunk.of(event.getChunk()),
                        false
                )
        );
    }

    @Subscribe
    public void onChunkUnload(final ChunkUnloadEvent event) {
        Bukkit.getPluginManager().callEvent(
                new org.bukkit.event.world.ChunkUnloadEvent(
                        PoreChunk.of(event.getChunk())
                ) {
                    @Override
                    public void setCancelled(boolean cancelled) {
                        super.setCancelled(cancelled);
                        //TODO: find a way to cancel the Sponge event
                    }
                }
        );
    }

    @Subscribe
    public void onWorldLoad(final WorldLoadEvent event) {
        Bukkit.getPluginManager().callEvent(
                new org.bukkit.event.world.WorldLoadEvent(
                        PoreWorld.of(event.getWorld())
                )
        );
    }

    @Subscribe
    public void onWorldUnload(final WorldUnloadEvent event) {
        Bukkit.getPluginManager().callEvent(
                new org.bukkit.event.world.WorldUnloadEvent(
                        PoreWorld.of(event.getWorld())
                ) {
                    @Override
                    public void setCancelled(boolean cancelled) {
                        super.setCancelled(cancelled);
                        //TODO: find a way to cancel the Sponge event
                    }
                }
        );
    }
}
