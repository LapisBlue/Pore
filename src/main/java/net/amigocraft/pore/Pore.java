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
package net.amigocraft.pore;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import net.amigocraft.pore.event.PlayerEventHandler;
import net.amigocraft.pore.event.WorldEventHandler;
import net.amigocraft.pore.impl.PoreServer;
import org.apache.commons.lang.NotImplementedException;
import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.event.state.PreInitializationEvent;
import org.spongepowered.api.event.state.ServerStoppingEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.util.event.Subscribe;

/**
 * @author Maxim Roncacé, Lapis Blue
 */
@Plugin(id = "pore", name = "Pore")
public class Pore {
    private static Pore instance;

    private final Game game;
    private final PluginContainer container;

    @Inject
    protected Logger logger;
    private PoreServer server;

    @Inject
    public Pore(Game game, PluginContainer container) {
        instance = this;

        this.game = game;
        this.container = container;
    }

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
        throw new NotImplementedException();
    }

    //TODO: possibly move state event handlers to their own class
    @Subscribe
    public void onInitialization(PreInitializationEvent event) {
        instance = this;

        logger.info("Loading Pore server, please wait...");

        initializeEventHandlers();

        server = new PoreServer(event.getGame(), logger);
        //TODO: initialize plugins with proper load order
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

    private static void initializeEventHandlers(){
        // main class
        getGame().getEventManager().register(getInstance(), getInstance());
        // player events
        getGame().getEventManager().register(getInstance(), new PlayerEventHandler());
        // world events
        getGame().getEventManager().register(getInstance(), new WorldEventHandler());
    }

}
