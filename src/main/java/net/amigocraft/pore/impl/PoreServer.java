/*
 * Pore
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
package net.amigocraft.pore.impl;

import com.avaje.ebean.config.ServerConfig;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import net.amigocraft.pore.impl.entity.PorePlayer;
import net.amigocraft.pore.impl.scheduler.PoreBukkitScheduler;
import net.amigocraft.pore.logging.PoreLogger;
import net.amigocraft.pore.util.PoreCollections;
import net.amigocraft.pore.util.PoreWrapper;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.UnsafeValues;
import org.bukkit.Warning;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.help.HelpMap;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.map.MapView;
import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginLoadOrder;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.java.JavaPluginLoader;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.plugin.messaging.StandardMessenger;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.CachedServerIcon;
import org.bukkit.util.StringUtil;
import org.spongepowered.api.Game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

//TODO: skeleton implementation

public class PoreServer extends PoreWrapper<org.spongepowered.api.Server> implements Server {
    private final Game game;
    private final Logger logger;
    private final PluginManager pluginManager;
    private final File pluginsDir = new File(".", "bukkit-plugins");
    //TODO: use actual server directory, currently set to working directory

    private final BukkitScheduler scheduler = new PoreBukkitScheduler();

    public PoreServer(org.spongepowered.api.Game handle, org.slf4j.Logger logger) {
        super(handle.getServer().get());
        this.game = handle;
        this.logger = new PoreLogger(logger);
        this.pluginManager = new SimplePluginManager(this, new SimpleCommandMap(this));
        Bukkit.setServer(this);

        getLogger().info("Loading plugins");
        loadPlugins();
    }

    public Game getGame() {
        return game;
    }

    public void loadPlugins() {
        pluginManager.registerInterface(JavaPluginLoader.class);

        if (pluginsDir.exists()) {
            Plugin[] plugins = pluginManager.loadPlugins(pluginsDir);
            for (Plugin plugin : plugins) {
                try {
                    getLogger().info(String.format("Loading %s", plugin.getDescription().getFullName()));
                    plugin.onLoad();
                } catch (Throwable ex) {
                    getLogger().log(Level.SEVERE,
                            ex.getMessage() + " initializing " + plugin.getDescription().getFullName() +
                                    " (Is it up to date?)", ex);
                }
            }
        } else {
            pluginsDir.mkdir();
        }
    }

    private void loadPlugin(Plugin plugin) {
        try {
            pluginManager.enablePlugin(plugin);

            List<Permission> perms = plugin.getDescription().getPermissions();
            for (Permission perm : perms) {
                try {
                    pluginManager.addPermission(perm);
                } catch (IllegalArgumentException ex) {
                    System.out.println("Plugin " + plugin.getDescription().getFullName() +
                            " tried to register permission '" + perm.getName() +
                            "' but it's already registered");
                }
            }
        } catch (Throwable ex) {
            System.out.println(ex.getMessage() + " loading " + plugin.getDescription().getFullName() +
                    " (Is it up to date?)");
        }
    }

    public void enablePlugins(PluginLoadOrder type) { // TODO: Load plugins before or after world loading
        Plugin[] plugins = pluginManager.getPlugins();
        for (Plugin plugin : plugins) {
            if ((!plugin.isEnabled())) {
                loadPlugin(plugin);
            }
        }
    }

    public void disablePlugins() {
        pluginManager.disablePlugins();
    }

    @Override
    public String getName() {
        return "Sponge";
    }

    @Override
    public String getVersion() {
        return game.getImplementationVersion();
    }

    @Override
    public String getBukkitVersion() {
        return "Pore-" + getVersion();
    }

    @Override
    public Player[] _INVALID_getOnlinePlayers() {
        Collection<? extends Player> online = getOnlinePlayers();
        return online.toArray(new Player[online.size()]);
    }

    @Override
    public Collection<? extends Player> getOnlinePlayers() {
        return PoreCollections.transform(getHandle().getOnlinePlayers(), PorePlayer.getPlayerConverter());
    }

    @Override
    public int getMaxPlayers() {
        return getHandle().getMaxPlayers();
    }

    @Override
    public int getPort() {
        Optional<InetSocketAddress> address = getHandle().getBoundAddress();
        if (address.isPresent()) {
            return address.get().getPort();
        } else {
            return -1;
        }
    }

    @Override
    public int getViewDistance() {
        throw new NotImplementedException();
    }

    @Override
    public String getIp() {
        Optional<InetSocketAddress> address = getHandle().getBoundAddress();
        if (address.isPresent()) {
            return address.get().getHostName();
        } else {
            return "Unknown";
        }
    }

    @Override
    public String getServerName() {
        throw new NotImplementedException();
    }

    @Override
    public String getServerId() {
        throw new NotImplementedException();
    }

    @Override
    public String getWorldType() {
        throw new NotImplementedException();
    }

    @Override
    public boolean getGenerateStructures() {
        throw new NotImplementedException();
    }

    @Override
    public boolean getAllowEnd() {
        throw new NotImplementedException();
    }

    @Override
    public boolean getAllowNether() {
        throw new NotImplementedException();
    }

    @Override
    public boolean hasWhitelist() {
        return getHandle().hasWhitelist();
    }

    @Override
    public void setWhitelist(boolean value) {
        getHandle().setHasWhitelist(value);
    }

    @Override
    public Set<OfflinePlayer> getWhitelistedPlayers() {
        throw new NotImplementedException();
    }

    @Override
    public void reloadWhitelist() {
        throw new NotImplementedException();
    }

    @Override
    public int broadcastMessage(String message) {
        return broadcast(message, BROADCAST_CHANNEL_USERS);
    }

    @Override
    public String getUpdateFolder() {
        throw new NotImplementedException();
    }

    @Override
    public File getUpdateFolderFile() {
        throw new NotImplementedException();
    }

    @Override
    public long getConnectionThrottle() {
        throw new NotImplementedException();
    }

    @Override
    public int getTicksPerAnimalSpawns() {
        throw new NotImplementedException();
    }

    @Override
    public int getTicksPerMonsterSpawns() {
        throw new NotImplementedException();
    }

    @Override
    public Player getPlayer(String name) {
        Preconditions.checkNotNull(name, "name");

        org.spongepowered.api.entity.player.Player result = null;
        int delta = Integer.MAX_VALUE;
        for (org.spongepowered.api.entity.player.Player player : getHandle().getOnlinePlayers()) {
            if (StringUtil.startsWithIgnoreCase(player.getName(), name)) {
                int newDelta = player.getName().length() - name.length();
                if (newDelta < delta) {
                    result = player;
                    delta = newDelta;
                }

                if (newDelta == 0) break;
            }
        }

        return result != null ? PorePlayer.of(result) : null;
    }

    @Override
    public Player getPlayerExact(String name) {
        Optional<org.spongepowered.api.entity.player.Player> player = getHandle().getPlayer(name);
        return player.isPresent() ? PorePlayer.of(player.get()) : null;
    }

    @Override
    public List<Player> matchPlayer(String name) {
        Preconditions.checkNotNull(name, "name");
        name = name.toLowerCase();

        List<Player> result = Lists.newArrayList();
        for (org.spongepowered.api.entity.player.Player player : getHandle().getOnlinePlayers()) {
            String playerName = player.getName().toLowerCase();

            if (name.equals(playerName)) {
                // Exact match
                return ImmutableList.<Player>of(PorePlayer.of(player));
            }

            if (playerName.contains(name)) {
                // Partial match
                result.add(PorePlayer.of(player));
            }
        }

        return result;
    }

    @Override
    public Player getPlayer(UUID id) {
        Optional<org.spongepowered.api.entity.player.Player> player = getHandle().getPlayer(id);
        return player.isPresent() ? PorePlayer.of(player.get()) : null;
    }

    @Override
    public PluginManager getPluginManager() {
        return pluginManager;
    }

    @Override
    public BukkitScheduler getScheduler() {
        return scheduler;
    }

    @Override
    public ServicesManager getServicesManager() {
        throw new NotImplementedException();
    }

    @Override
    public List<World> getWorlds() {
        // TODO: Should this be unmodifiable?
        return PoreCollections
                .<org.spongepowered.api.world.World, World>transformToList(getHandle().getWorlds(),
                        PoreWorld.getConverter());
    }

    @Override
    public World createWorld(WorldCreator creator) {
        throw new NotImplementedException();
    }

    @Override
    public boolean unloadWorld(String name, boolean save) {
        Optional<org.spongepowered.api.world.World> world = getHandle().getWorld(name);
        return world.isPresent() && getHandle().unloadWorld(world.get());
    }

    @Override
    public boolean unloadWorld(World world, boolean save) {
        return getHandle().unloadWorld(((PoreWorld) world).getHandle());
    }

    @Override
    public World getWorld(String name) {
        Optional<org.spongepowered.api.world.World> world = getHandle().getWorld(name);
        return world.isPresent() ? PoreWorld.of(world.get()) : null;
    }

    @Override
    public World getWorld(UUID uid) {
        Optional<org.spongepowered.api.world.World> world = getHandle().getWorld(uid);
        return world.isPresent() ? PoreWorld.of(world.get()) : null;
    }

    @Override
    public MapView getMap(short id) {
        throw new NotImplementedException();
    }

    @Override
    public MapView createMap(World world) {
        throw new NotImplementedException();
    }

    @Override
    public void reload() {
        throw new NotImplementedException();
    }

    @Override
    public Logger getLogger() {
        return logger;
    }

    @Override
    public PluginCommand getPluginCommand(String name) {
        throw new NotImplementedException();
    }

    @Override
    public void savePlayers() {
        throw new NotImplementedException();
    }

    @Override
    public boolean dispatchCommand(CommandSender sender, String commandLine) throws CommandException {
        throw new NotImplementedException();
    }

    @Override
    public void configureDbConfig(ServerConfig config) {
        throw new NotImplementedException();
    }

    @Override
    public boolean addRecipe(Recipe recipe) {
        throw new NotImplementedException();
    }

    @Override
    public List<Recipe> getRecipesFor(ItemStack result) {
        throw new NotImplementedException();
    }

    @Override
    public Iterator<Recipe> recipeIterator() {
        throw new NotImplementedException();
    }

    @Override
    public void clearRecipes() {
        throw new NotImplementedException();
    }

    @Override
    public void resetRecipes() {
        throw new NotImplementedException();
    }

    @Override
    public Map<String, String[]> getCommandAliases() {
        throw new NotImplementedException();
    }

    @Override
    public int getSpawnRadius() {
        throw new NotImplementedException();
    }

    @Override
    public void setSpawnRadius(int value) {
        throw new NotImplementedException();
    }

    @Override
    public boolean getOnlineMode() {
        return getHandle().getOnlineMode();
    }

    @Override
    public boolean getAllowFlight() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isHardcore() {
        throw new NotImplementedException();
    }

    @Override
    public boolean useExactLoginLocation() {
        throw new NotImplementedException();
    }

    @Override
    public void shutdown() {
        throw new NotImplementedException();
    }

    @Override
    public int broadcast(String message, String permission) {
        int count = 0;
        Set<Permissible> permissibles = getPluginManager().getPermissionSubscriptions(permission);

        for (Permissible permissible : permissibles) {
            if (permissible instanceof CommandSender && permissible.hasPermission(permission)) {
                CommandSender user = (CommandSender) permissible;
                user.sendMessage(message);
                count++;
            }
        }

        return count;
    }

    @Override
    public OfflinePlayer getOfflinePlayer(String name) {
        throw new NotImplementedException();
    }

    @Override
    public OfflinePlayer getOfflinePlayer(UUID id) {
        throw new NotImplementedException();
    }

    @Override
    public Set<String> getIPBans() {
        throw new NotImplementedException();
    }

    @Override
    public void banIP(String address) {
        throw new NotImplementedException();
    }

    @Override
    public void unbanIP(String address) {
        throw new NotImplementedException();
    }

    @Override
    public Set<OfflinePlayer> getBannedPlayers() {
        throw new NotImplementedException();
    }

    @Override
    public BanList getBanList(BanList.Type type) {
        throw new NotImplementedException();
    }

    @Override
    public Set<OfflinePlayer> getOperators() {
        throw new NotImplementedException();
    }

    @Override
    public GameMode getDefaultGameMode() {
        throw new NotImplementedException();
    }

    @Override
    public void setDefaultGameMode(GameMode mode) {
        throw new NotImplementedException();
    }

    @Override
    public ConsoleCommandSender getConsoleSender() {
        throw new NotImplementedException();
    }

    @Override
    public File getWorldContainer() {
        throw new NotImplementedException();
    }

    @Override
    public PoreOfflinePlayer[] getOfflinePlayers() {
        throw new NotImplementedException();
    }

    @Override
    public Messenger getMessenger() {
        throw new NotImplementedException();
    }

    @Override
    public HelpMap getHelpMap() {
        throw new NotImplementedException();
    }

    @Override
    public Inventory createInventory(InventoryHolder owner, InventoryType type) {
        throw new NotImplementedException();
    }

    @Override
    public Inventory createInventory(InventoryHolder owner, InventoryType type, String title) {
        throw new NotImplementedException();
    }

    @Override
    public Inventory createInventory(InventoryHolder owner, int size) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public Inventory createInventory(InventoryHolder owner, int size, String title)
            throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public int getMonsterSpawnLimit() {
        throw new NotImplementedException();
    }

    @Override
    public int getAnimalSpawnLimit() {
        throw new NotImplementedException();
    }

    @Override
    public int getWaterAnimalSpawnLimit() {
        throw new NotImplementedException();
    }

    @Override
    public int getAmbientSpawnLimit() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isPrimaryThread() {
        throw new NotImplementedException();
    }

    @Override
    public String getMotd() {
        throw new NotImplementedException();
    }

    @Override
    public String getShutdownMessage() {
        throw new NotImplementedException();
    }

    @Override
    public Warning.WarningState getWarningState() {
        throw new NotImplementedException();
    }

    @Override
    public ItemFactory getItemFactory() {
        throw new NotImplementedException();
    }

    @Override
    public ScoreboardManager getScoreboardManager() {
        throw new NotImplementedException();
    }

    @Override
    public CachedServerIcon getServerIcon() {
        throw new NotImplementedException();
    }

    @Override
    public CachedServerIcon loadServerIcon(File file) throws IllegalArgumentException, Exception {
        throw new NotImplementedException();
    }

    @Override
    public CachedServerIcon loadServerIcon(BufferedImage image) throws IllegalArgumentException, Exception {
        throw new NotImplementedException();
    }

    @Override
    public void setIdleTimeout(int threshold) {
        throw new NotImplementedException();
    }

    @Override
    public int getIdleTimeout() {
        throw new NotImplementedException();
    }

    @Deprecated
    @Override
    public UnsafeValues getUnsafe() {
        return new PoreUnsafeValues();
    }

    @Override
    public void sendPluginMessage(Plugin source, String channel, byte[] message) {
        StandardMessenger.validatePluginMessage(getMessenger(), source, channel, message);

        for (Player player : getOnlinePlayers()) {
            player.sendPluginMessage(source, channel, message);
        }
    }

    @Override
    public Set<String> getListeningPluginChannels() {
        Set<String> result = new HashSet<String>();

        for (Player player : getOnlinePlayers()) {
            result.addAll(player.getListeningPluginChannels());
        }

        return result;
    }
}
