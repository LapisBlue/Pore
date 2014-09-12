package net.amigocraft.pore.implementation;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import java.util.logging.Logger;

import net.amigocraft.pore.implementation.entity.PorePlayer;
import org.apache.commons.lang.Validate;
import org.bukkit.BanList;
import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.UnsafeValues;
import org.bukkit.Warning;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.*;
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
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.plugin.messaging.StandardMessenger;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.CachedServerIcon;

import com.avaje.ebean.config.ServerConfig;

//TODO: skeleton implementation

public class PoreServer implements Server {

	private org.spongepowered.api.Game handle;

	private PluginManager pluginManager;

	public PoreServer(org.spongepowered.api.Game handle){
		this.handle = handle;
		this.pluginManager = new SimplePluginManager(this, new SimpleCommandMap(this));
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
		return "Pore-"+getVersion();
	}

	@Override
	public Player[] _INVALID_getOnlinePlayers() {
		return getOnlinePlayers().toArray(new Player[]{});
	}

	@Override
	public Collection<? extends Player> getOnlinePlayers() {
		//TODO: figure out how to create a goddamn collection
		return null;
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
		return null;
	}

	@Override
	public String getServerName() {
		return null;
	}

	@Override
	public String getServerId() {
		return null;
	}

	@Override
	public String getWorldType() {
		return null;
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

	}

	@Override
	public Set<OfflinePlayer> getWhitelistedPlayers() {
		return null;
	}

	@Override
	public void reloadWhitelist() {

	}

	@Override
	public int broadcastMessage(String message) {
		return broadcast(message, BROADCAST_CHANNEL_USERS);
	}

	@Override
	public String getUpdateFolder() {
		return null;
	}

	@Override
	public File getUpdateFolderFile() {
		return null;
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
		return null;
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

		return null;
	}

	@Override
	public List<Player> matchPlayer(String name) {
		return null;
	}

	@Override
	public Player getPlayer(UUID id) {
		return new PorePlayer(handle.getPlayer(id));
	}

	@Override
	public PluginManager getPluginManager() {
		return null;
	}

	@Override
	public BukkitScheduler getScheduler() {
		return null;
	}

	@Override
	public ServicesManager getServicesManager() {
		return null;
	}

	@Override
	public List<World> getWorlds() {
		List<World> worldList = new ArrayList<World>();
		for (org.spongepowered.api.world.World w : handle.getWorlds())
			worldList.add(new PoreWorld(w));
		return worldList;
	}

	@Override
	public World createWorld(WorldCreator creator) {
		return null;
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
		return new PoreWorld(handle.getWorld(name));
	}

	@Override
	public World getWorld(UUID uid) {
		return new PoreWorld(handle.getWorld(uid));
	}

	@Override
	public MapView getMap(short id) {
		return null;
	}

	@Override
	public MapView createMap(World world) {
		return null;
	}

	@Override
	public void reload() {

	}

	@Override
	public Logger getLogger() {
		return null;
	}

	@Override
	public PluginCommand getPluginCommand(String name) {
		return null;
	}

	@Override
	public void savePlayers() {

	}

	@Override
	public boolean dispatchCommand(CommandSender sender, String commandLine) throws CommandException {
		return false;
	}

	@Override
	public void configureDbConfig(ServerConfig config) {

	}

	@Override
	public boolean addRecipe(Recipe recipe) {
		return false;
	}

	@Override
	public List<Recipe> getRecipesFor(ItemStack result) {
		return null;
	}

	@Override
	public Iterator<Recipe> recipeIterator() {
		return null;
	}

	@Override
	public void clearRecipes() {

	}

	@Override
	public void resetRecipes() {

	}

	@Override
	public Map<String, String[]> getCommandAliases() {
		return null;
	}

	@Override
	public int getSpawnRadius() {
		return 0;
	}

	@Override
	public void setSpawnRadius(int value) {

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
		return null;
	}

	@Override
	public OfflinePlayer getOfflinePlayer(UUID id) {
		return null;
	}

	@Override
	public Set<String> getIPBans() {
		return null;
	}

	@Override
	public void banIP(String address) {

	}

	@Override
	public void unbanIP(String address) {

	}

	@Override
	public Set<OfflinePlayer> getBannedPlayers() {
		return null;
	}

	@Override
	public BanList getBanList(BanList.Type type) {
		return null;
	}

	@Override
	public Set<OfflinePlayer> getOperators() {
		return null;
	}

	@Override
	public GameMode getDefaultGameMode() {
		return null;
	}

	@Override
	public void setDefaultGameMode(GameMode mode) {

	}

	@Override
	public ConsoleCommandSender getConsoleSender() {
		return null;
	}

	@Override
	public File getWorldContainer() {
		return null;
	}

	@Override
	public PoreOfflinePlayer[] getOfflinePlayers() {
		return new PoreOfflinePlayer[0];
	}

	@Override
	public Messenger getMessenger() {
		return null;
	}

	@Override
	public HelpMap getHelpMap() {
		return null;
	}

	@Override
	public Inventory createInventory(InventoryHolder owner, InventoryType type) {
		return null;
	}

	@Override
	public Inventory createInventory(InventoryHolder owner, InventoryType type, String title) {
		return null;
	}

	@Override
	public Inventory createInventory(InventoryHolder owner, int size) throws IllegalArgumentException {
		return null;
	}

	@Override
	public Inventory createInventory(InventoryHolder owner, int size, String title) throws IllegalArgumentException {
		return null;
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
		return null;
	}

	@Override
	public String getShutdownMessage() {
		return null;
	}

	@Override
	public Warning.WarningState getWarningState() {
		return null;
	}

	@Override
	public ItemFactory getItemFactory() {
		return null;
	}

	@Override
	public ScoreboardManager getScoreboardManager() {
		return null;
	}

	@Override
	public CachedServerIcon getServerIcon() {
		return null;
	}

	@Override
	public CachedServerIcon loadServerIcon(File file) throws IllegalArgumentException, Exception {
		return null;
	}

	@Override
	public CachedServerIcon loadServerIcon(BufferedImage image) throws IllegalArgumentException, Exception {
		return null;
	}

	@Override
	public void setIdleTimeout(int threshold) {

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
