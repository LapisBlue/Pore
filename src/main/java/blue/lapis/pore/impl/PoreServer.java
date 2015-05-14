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
package blue.lapis.pore.impl;

import blue.lapis.pore.PoreVersion;
import blue.lapis.pore.converter.wrapper.WrapperConverter;
import blue.lapis.pore.impl.command.PoreCommandMap;
import blue.lapis.pore.impl.command.PoreConsoleCommandSender;
import blue.lapis.pore.impl.entity.PorePlayer;
import blue.lapis.pore.impl.help.PoreHelpMap;
import blue.lapis.pore.impl.scheduler.PoreBukkitScheduler;
import blue.lapis.pore.impl.util.PoreCachedServerIcon;
import blue.lapis.pore.util.PoreCollections;
import blue.lapis.pore.util.PoreWrapper;

import com.avaje.ebean.config.ServerConfig;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.UnsafeValues;
import org.bukkit.Warning;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
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
import org.bukkit.plugin.SimpleServicesManager;
import org.bukkit.plugin.java.JavaPluginLoader;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.plugin.messaging.StandardMessenger;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.CachedServerIcon;
import org.bukkit.util.StringUtil;
import org.bukkit.util.permissions.DefaultPermissions;
import org.spongepowered.api.Game;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.command.source.ConsoleSource;

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

public class PoreServer extends PoreWrapper<org.spongepowered.api.Server> implements Server {

    private final Game game;
    private final Logger logger;
    private final SimpleCommandMap commandMap;
    private final PluginManager pluginManager;
    private final ServicesManager servicesManager;
    private final Messenger messenger = new StandardMessenger();
    private final Warning.WarningState warnState = Warning.WarningState.DEFAULT;
    private final HelpMap helpMap = new PoreHelpMap();
    private final File pluginsDir = new File(".", "bukkit-plugins");
    //TODO: use actual server directory, currently set to working directory

    private final BukkitScheduler scheduler = new PoreBukkitScheduler();

    public PoreServer(org.spongepowered.api.Game handle, org.slf4j.Logger logger) {
        super(handle.getServer());
        this.game = handle;
        this.logger = Logger.getLogger(logger.getName());
        this.commandMap = new PoreCommandMap(this);
        this.pluginManager = new SimplePluginManager(this, commandMap);
        this.servicesManager = new SimpleServicesManager();
        Bukkit.setServer(this);
    }

    public Game getGame() {
        return game;
    }

    public void loadPlugins() {
        if (pluginsDir.isDirectory()) {
            // Clear plugins and prepare to load
            pluginManager.clearPlugins();
            pluginManager.registerInterface(JavaPluginLoader.class);

            // Call onLoad methods
            for (Plugin plugin : pluginManager.loadPlugins(pluginsDir)) {
                try {
                    getLogger().info(String.format("Loading %s", plugin.getDescription().getFullName()));
                    plugin.onLoad();
                } catch (Exception ex) {
                    getLogger().log(Level.SEVERE,
                            ex.getMessage() + " initializing " + plugin.getDescription().getFullName()
                                    + " (Is it up to date?)", ex);
                }
            }
        } else {
            if (!pluginsDir.mkdir()) {
                logger.log(Level.SEVERE, "Could not create plugins directory: " + pluginsDir);
            }
        }
    }

    private void loadPlugin(Plugin plugin) {
        for (Permission perm : plugin.getDescription().getPermissions()) {
            try {
                pluginManager.addPermission(perm);
            } catch (IllegalArgumentException ex) {
                getLogger().log(Level.WARNING,
                        "Plugin " + plugin.getDescription().getFullName()
                                + " tried to register permission '" + perm.getName()
                                + "' but it's already registered", ex);
            }
        }

        try {
            pluginManager.enablePlugin(plugin);
        } catch (Throwable ex) {
            getLogger().log(Level.SEVERE,
                    ex.getMessage() + " loading " + plugin.getDescription().getFullName()
                            + " (Is it up to date?)");
        }
    }

    public void enablePlugins(PluginLoadOrder type) {
        if (type == PluginLoadOrder.STARTUP) {
            // TODO
            //helpMap.clear();
        }

        // Load all the plugins
        for (Plugin plugin : pluginManager.getPlugins()) {
            if (!plugin.isEnabled() && plugin.getDescription().getLoad() == type) {
                loadPlugin(plugin);
            }
        }

        if (type == PluginLoadOrder.POSTWORLD) {
            commandMap.setFallbackCommands();
            //commandMap.registerServerAliases();
            DefaultPermissions.registerCorePermissions();
            //helpMap.initializeCommands();
        }
    }

    public void disablePlugins() {
        pluginManager.disablePlugins();
    }

    @Override
    public String getName() {
        return PoreVersion.NAME;
    }

    @Override
    public String getVersion() {
        return PoreVersion.VERSION + '@' + game.getImplementationVersion();
    }

    @Override
    public String getBukkitVersion() {
        return PoreVersion.API_VERSION + '@' + game.getApiVersion();
    }

    @Override
    public Player[] _INVALID_getOnlinePlayers() {
        Collection<? extends Player> online = getOnlinePlayers();
        return online.toArray(new Player[online.size()]);
    }

    @Override
    public Collection<? extends Player> getOnlinePlayers() {
        return PoreCollections.transform(getHandle().getOnlinePlayers(),
                WrapperConverter.<org.spongepowered.api.entity.player.Player, PorePlayer>getConverter());
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
        throw new NotImplementedException("TODO");
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
        throw new NotImplementedException("TODO");
    }

    @Override
    public String getServerId() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public String getWorldType() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean getGenerateStructures() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean getAllowEnd() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean getAllowNether() {
        throw new NotImplementedException("TODO");
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
        throw new NotImplementedException("TODO");
    }

    @Override
    public void reloadWhitelist() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public int broadcastMessage(String message) {
        return broadcast(message, BROADCAST_CHANNEL_USERS);
    }

    @Override
    public String getUpdateFolder() {
        return "update";
    }

    @Override
    public File getUpdateFolderFile() {
        return new File(pluginsDir, getUpdateFolder());
    }

    @Override
    public long getConnectionThrottle() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public int getTicksPerAnimalSpawns() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public int getTicksPerMonsterSpawns() {
        throw new NotImplementedException("TODO");
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

                if (newDelta == 0) {
                    break;
                }
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
        return servicesManager;
    }

    @Override
    public List<World> getWorlds() {
        return PoreCollections.<org.spongepowered.api.world.World, World>transformToList(getHandle().getWorlds(),
                WrapperConverter.<org.spongepowered.api.world.World, PoreWorld>getConverter());
    }

    @Override
    public World createWorld(WorldCreator creator) {
        throw new NotImplementedException("TODO");
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
        throw new NotImplementedException("TODO");
    }

    @Override
    public MapView createMap(World world) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void reload() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Logger getLogger() {
        return logger;
    }

    @Override
    public PluginCommand getPluginCommand(String name) {
        Command command = commandMap.getCommand(name);

        if (command instanceof PluginCommand) {
            return (PluginCommand) command;
        } else {
            return null;
        }
    }

    @Override
    public void savePlayers() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean dispatchCommand(CommandSender sender, String commandLine) throws CommandException {
        Preconditions.checkNotNull(sender, "sender");
        Preconditions.checkNotNull(commandLine, "commandLine");

        return commandMap.dispatch(sender, commandLine);
    }

    @Override
    public void configureDbConfig(ServerConfig config) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean addRecipe(Recipe recipe) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public List<Recipe> getRecipesFor(ItemStack result) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Iterator<Recipe> recipeIterator() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void clearRecipes() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void resetRecipes() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Map<String, String[]> getCommandAliases() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public int getSpawnRadius() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setSpawnRadius(int value) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean getOnlineMode() {
        return getHandle().getOnlineMode();
    }

    @Override
    public boolean getAllowFlight() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean isHardcore() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean useExactLoginLocation() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void shutdown() {
        throw new NotImplementedException("TODO");
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
        throw new NotImplementedException("TODO");
    }

    @Override
    public OfflinePlayer getOfflinePlayer(UUID id) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Set<String> getIPBans() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void banIP(String address) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void unbanIP(String address) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Set<OfflinePlayer> getBannedPlayers() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public BanList getBanList(BanList.Type type) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Set<OfflinePlayer> getOperators() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public GameMode getDefaultGameMode() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setDefaultGameMode(GameMode mode) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public ConsoleCommandSender getConsoleSender() {
        return PoreConsoleCommandSender.of((ConsoleSource) getHandle());
    }

    @Override
    public File getWorldContainer() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public PoreOfflinePlayer[] getOfflinePlayers() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Messenger getMessenger() {
        return messenger;
    }

    @Override
    public HelpMap getHelpMap() {
        return helpMap;
    }

    @Override
    public Inventory createInventory(InventoryHolder owner, InventoryType type) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Inventory createInventory(InventoryHolder owner, InventoryType type, String title) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Inventory createInventory(InventoryHolder owner, int size) throws IllegalArgumentException {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Inventory createInventory(InventoryHolder owner, int size, String title)
            throws IllegalArgumentException {
        throw new NotImplementedException("TODO");
    }

    @Override
    public int getMonsterSpawnLimit() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public int getAnimalSpawnLimit() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public int getWaterAnimalSpawnLimit() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public int getAmbientSpawnLimit() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean isPrimaryThread() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public String getMotd() {
        return Texts.toLegacy(getHandle().getMotd());
    }

    @Override
    public String getShutdownMessage() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Warning.WarningState getWarningState() {
        return warnState;
    }

    @Override
    public ItemFactory getItemFactory() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public ScoreboardManager getScoreboardManager() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public CachedServerIcon getServerIcon() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public CachedServerIcon loadServerIcon(File file) throws Exception {
        return PoreCachedServerIcon.of(game.getRegistry().loadFavicon(file));
    }

    @Override
    public CachedServerIcon loadServerIcon(BufferedImage image) throws Exception {
        return PoreCachedServerIcon.of(game.getRegistry().loadFavicon(image));
    }

    @Override
    public void setIdleTimeout(int threshold) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public int getIdleTimeout() {
        throw new NotImplementedException("TODO");
    }

    @Deprecated
    @Override
    public UnsafeValues getUnsafe() {
        return PoreUnsafeValues.INSTANCE;
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
