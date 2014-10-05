package net.amigocraft.pore.implementation;

import com.avaje.ebean.config.ServerConfig;

import com.google.common.collect.Lists;
import net.amigocraft.pore.implementation.entity.PorePlayer;

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
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.java.JavaPluginLoader;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.plugin.messaging.StandardMessenger;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.CachedServerIcon;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import java.util.logging.Logger;

//TODO: skeleton implementation

public class PoreServer implements Server {

	private org.spongepowered.api.Game handle;

	private PluginManager pluginManager;
	private File pluginsDir = new File(".", "bukkit-plugins"); //TODO: use actual server directory, currently set to working directory

	public PoreServer(org.spongepowered.api.Game handle) {
		this.handle = handle;
		this.pluginManager = new SimplePluginManager(this, new SimpleCommandMap(this));
	}

	public org.spongepowered.api.Game getHandle() {
		return handle;
	}
	
	public void loadPlugins() {
		pluginManager.registerInterface(JavaPluginLoader.class);
		
		Plugin[] plugins = pluginManager.loadPlugins(pluginsDir );
		for (Plugin plugin : plugins) {
			try {
				String message = String.format("Loading %s", plugin.getDescription().getFullName());
				System.out.println(message);
				plugin.onLoad();
			} catch (Throwable ex) {
				System.out.println(ex.getMessage() + " initializing " + plugin.getDescription().getFullName() + " (Is it up to date?)");
			}
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
	
	public void enablePlugins() {
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
		return handle.getImplementationVersion();
	}

	@Override
	public String getBukkitVersion() {
		return "Pore-" + getVersion();
	}

	@Override
	public Player[] _INVALID_getOnlinePlayers() {
		return getOnlinePlayers().toArray(new Player[]{});
	}

	@Override
	public Collection<? extends Player> getOnlinePlayers() {
		List<Player> players = new ArrayList<Player>();
		for (org.spongepowered.api.entity.Player pl : this.getHandle().getOnlinePlayers()){
			players.add(new PorePlayer(pl));
		}
		return Collections.unmodifiableList(players);
	}

	@Override
	public int getMaxPlayers() {
		return handle.getMaxPlayers();
	}

	@Override
	public int getPort() {
		return 0;
	}

	@Override
	public int getViewDistance() {
		return 0;
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
		return false;
	}

	@Override
	public boolean getAllowEnd() {
		return false;
	}

	@Override
	public boolean getAllowNether() {
		return false;
	}

	@Override
	public boolean hasWhitelist() {
		return false;
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
		return 0;
	}

	@Override
	public int getTicksPerAnimalSpawns() {
		return 0;
	}

	@Override
	public int getTicksPerMonsterSpawns() {
		return 0;
	}

	@Override
	public Player getPlayer(String name) {
		throw new NotImplementedException();
	}

	@Override
	public Player getPlayerExact(String name) {
		Validate.notNull(name, "Name cannot be null");

		String lname = name.toLowerCase();

		for (Player player : getOnlinePlayers()) {
			if (player.getName().equalsIgnoreCase(lname)) {
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
		return new PorePlayer(handle.getPlayer(id));
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
		List<World> worldList = new ArrayList<World>();
		for (org.spongepowered.api.world.World w : handle.getWorlds())
			worldList.add(PoreWorld.of(w));
		return worldList;
	}

	@Override
	public World createWorld(WorldCreator creator) {
		throw new NotImplementedException();
	}

	@Override
	public boolean unloadWorld(String name, boolean save) {
		return false;
	}

	@Override
	public boolean unloadWorld(World world, boolean save) {
		return false;
	}

	@Override
	public World getWorld(String name) {
		return PoreWorld.of(handle.getWorld(name));
	}

	@Override
	public World getWorld(UUID uid) {
		return PoreWorld.of(handle.getWorld(uid));
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
		return false;
	}

	@Override
	public void configureDbConfig(ServerConfig config) {
		throw new NotImplementedException();
	}

	@Override
	public boolean addRecipe(Recipe recipe) {
		return false;
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
		return 0;
	}

	@Override
	public void setSpawnRadius(int value) {
		throw new NotImplementedException();
	}

	@Override
	public boolean getOnlineMode() {
		return false;
	}

	@Override
	public boolean getAllowFlight() {
		return false;
	}

	@Override
	public boolean isHardcore() {
		return false;
	}

	@Override
	public boolean useExactLoginLocation() {
		return false;
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
		return new PoreOfflinePlayer[0];
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
		return 0;
	}

	@Override
	public int getAnimalSpawnLimit() {
		return 0;
	}

	@Override
	public int getWaterAnimalSpawnLimit() {
		return 0;
	}

	@Override
	public int getAmbientSpawnLimit() {
		return 0;
	}

	@Override
	public boolean isPrimaryThread() {
		return false;
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
		return 0;
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
