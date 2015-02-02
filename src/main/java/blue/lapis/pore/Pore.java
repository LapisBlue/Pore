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
package blue.lapis.pore;

import blue.lapis.pore.event.PoreEventWrapper;
import blue.lapis.pore.impl.PoreServer;
import blue.lapis.pore.impl.command.PoreCommandSender;
import blue.lapis.pore.plugin.PorePluginContainer;
import com.google.common.base.Preconditions;
import org.bukkit.plugin.PluginLoadOrder;
import org.slf4j.Logger;
import org.slf4j.helpers.NOPLogger;
import org.spongepowered.api.Game;
import org.spongepowered.api.event.message.CommandEvent;
import org.spongepowered.api.event.state.PreInitializationEvent;
import org.spongepowered.api.event.state.ServerAboutToStartEvent;
import org.spongepowered.api.event.state.ServerStartingEvent;
import org.spongepowered.api.event.state.ServerStoppingEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.util.event.Subscribe;

import javax.inject.Inject;

/**
 * @author Lapis Blue
 */
@Plugin(id = "pore", name = "Pore")
public final class Pore {
    protected static Pore instance;

    @Inject
    protected Game game;

    @Inject
    protected Logger logger;
    private PoreServer server;

    public static Pore getInstance() {
        return Preconditions.checkNotNull(instance);
    }

    public static Logger getLogger() {
        return getInstance().logger;
    }

    public static PoreServer getServer() {
        return getInstance().server;
    }

    public static Game getGame() {
        return getInstance().game;
    }

    public static PluginContainer getPlugin(org.bukkit.plugin.Plugin plugin) {
        return new PorePluginContainer(plugin);
    }

    @Subscribe
    public void onInitialization(PreInitializationEvent event) {
        instance = this;

        logger.info("Loading Pore server, please wait...");

        server = new PoreServer(game, logger);
        PoreEventWrapper.register();

        server.getLogger().info("Loading plugins");
        server.loadPlugins();
    }

    @Subscribe
    public void onAboutToStart(ServerAboutToStartEvent event) {
        server.enablePlugins(PluginLoadOrder.STARTUP);
    }

    @Subscribe
    public void onStarting(ServerStartingEvent event) {
        server.enablePlugins(PluginLoadOrder.POSTWORLD);
    }

    @Subscribe
    public void onShutdown(ServerStoppingEvent event) {
        logger.info("Disabling Bukkit plugins, please wait...");
        server.disablePlugins();
        logger.info("Finished disabling Bukkit plugins!");

        instance = null;
        server = null;
        logger = null;
    }

    @Subscribe
    public void onCommand(CommandEvent event) {
        String command = event.getCommand();
        String args = event.getArguments();
        if (!args.isEmpty()) command = command + ' ' + args;

        if (Pore.getServer().dispatchCommand(PoreCommandSender.of(event.getSource()), command)) {
            event.setCancelled(true);
        }
    }

    static Logger testLogger = NOPLogger.NOP_LOGGER;

    public static Logger getTestLogger() {
        return testLogger;
    }

}
