package net.amigocraft.pore.implementation;

import com.avaje.ebean.config.ServerConfig;
import com.google.common.base.Optional;
import net.amigocraft.pore.implementation.entity.PorePlayer;
import net.amigocraft.pore.util.PoreCollections;
import net.amigocraft.pore.util.PoreWrapper;
import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.lang.Validate;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.help.HelpMap;
import org.bukkit.inventory.*;
import org.bukkit.map.MapView;
import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.*;
import org.bukkit.plugin.java.JavaPluginLoader;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.plugin.messaging.StandardMessenger;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.CachedServerIcon;
import org.spongepowered.api.Game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

//TODO: skeleton implementation

public class PoreServer extends PoreWrapper<Game> implements Server {
	private final PluginManager pluginManager;
	private final File pluginsDir = new File(".", "bukkit-plugins"); //TODO: use actual server directory, currently set to working directory

	public PoreServer(org.spongepowered.api.Game handle) {
		super(handle);
		this.pluginManager = new SimplePluginManager(this, new SimpleCommandMap(this));
		Bukkit.setServer(this);

		getLogger().info("Loading plugins");
		loadPlugins();
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
					getLogger().log(Level.SEVERE, ex.getMessage() + " initializing " + plugin.getDescription().getFullName() + " (Is it up to date?)", ex);
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
					System.out.println("Plugin " + plugin.getDescription().getFullName() + " tried to register permission '" + perm.getName() + "' but it's already registered");
				}
			}
		} catch (Throwable ex) {
			System.out.println(ex.getMessage() + " loading " + plugin.getDescription().getFullName() + " (Is it up to date?)");
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
		return getHandle().getImplementationVersion();
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
		throw new NotImplementedException();
	}

	@Override
	public int getViewDistance() {
		throw new NotImplementedException();
	}

	@Override
	public String getIp() {
		throw new NotImplementedException();
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
		throw new NotImplementedException();
	}

	@Override
	public void setWhitelist(boolean value) {
		throw new NotImplementedException();
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
		throw new NotImplementedException();
	}

	@Override
	public Player getPlayerExact(String name) {
		Validate.notNull(name, "Name cannot be null");

		for (Player player : getOnlinePlayers()) {
			if (player.getName().equalsIgnoreCase(name)) {
				return player;
			}
		}

		throw new NotImplementedException();
	}

	@Override
	public List<Player> matchPlayer(String name) {
		throw new NotImplementedException();
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
		throw new NotImplementedException();
	}

	@Override
	public ServicesManager getServicesManager() {
		throw new NotImplementedException();
	}

	@Override
	public List<World> getWorlds() {
		// TODO: Should this be unmodifiable?
		return PoreCollections.<org.spongepowered.api.world.World, World>transformToList(getHandle().getWorlds(), PoreWorld.getConverter());
	}

	@Override
	public World createWorld(WorldCreator creator) {
		throw new NotImplementedException();
	}

	@Override
	public boolean unloadWorld(String name, boolean save) {
		throw new NotImplementedException();
	}

	@Override
	public boolean unloadWorld(World world, boolean save) {
		throw new NotImplementedException();
	}

	@Override
	public World getWorld(String name) {
		return PoreWorld.of(getHandle().getWorld(name));
	}

	@Override
	public World getWorld(UUID uid) {
		return PoreWorld.of(getHandle().getWorld(uid));
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
		throw new NotImplementedException();
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
		throw new NotImplementedException();
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
	public Inventory createInventory(InventoryHolder owner, int size, String title) throws IllegalArgumentException {
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
