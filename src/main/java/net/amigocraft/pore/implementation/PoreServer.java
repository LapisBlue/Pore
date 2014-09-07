package net.amigocraft.pore.implementation;

import com.avaje.ebean.config.ServerConfig;
import org.bukkit.*;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.help.HelpMap;
import org.bukkit.inventory.*;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.CachedServerIcon;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import java.util.logging.Logger;

public class PoreServer implements Server {


	@Override
	public String getName(){
		return null; //TODO: bridge
	}

	@Override
	public String getVersion(){
		return null; //TODO: bridge
	}

	@Override
	public String getBukkitVersion(){
		return null; //TODO: bridge
	}

	@Override
	public Player[] _INVALID_getOnlinePlayers(){
		return new Player[0]; //TODO: bridge
	}

	@Override
	public Collection<? extends Player> getOnlinePlayers(){
		return null; //TODO: bridge
	}

	@Override
	public int getMaxPlayers(){
		return 0; //TODO: bridge
	}

	@Override
	public int getPort(){
		return 0; //TODO: bridge
	}

	@Override
	public int getViewDistance(){
		return 0; //TODO: bridge
	}

	@Override
	public String getIp(){
		return null; //TODO: bridge
	}

	@Override
	public String getServerName(){
		return null; //TODO: bridge
	}

	@Override
	public String getServerId(){
		return null; //TODO: bridge
	}

	@Override
	public String getWorldType(){
		return null; //TODO: bridge
	}

	@Override
	public boolean getGenerateStructures(){
		return false; //TODO: bridge
	}

	@Override
	public boolean getAllowEnd(){
		return false; //TODO: bridge
	}

	@Override
	public boolean getAllowNether(){
		return false; //TODO: bridge
	}

	@Override
	public boolean hasWhitelist(){
		return false; //TODO: bridge
	}

	@Override
	public void setWhitelist(boolean value){
		//TODO: bridge
	}

	@Override
	public Set<OfflinePlayer> getWhitelistedPlayers(){
		return null; //TODO: bridge
	}

	@Override
	public void reloadWhitelist(){
		//TODO: bridge
	}

	@Override
	public int broadcastMessage(String message){
		return 0; //TODO: bridge
	}

	@Override
	public String getUpdateFolder(){
		return null; //TODO: bridge
	}

	@Override
	public File getUpdateFolderFile(){
		return null; //TODO: bridge
	}

	@Override
	public long getConnectionThrottle(){
		return 0; //TODO: bridge
	}

	@Override
	public int getTicksPerAnimalSpawns(){
		return 0; //TODO: bridge
	}

	@Override
	public int getTicksPerMonsterSpawns(){
		return 0; //TODO: bridge
	}

	@Override
	public Player getPlayer(String name){
		return null; //TODO: bridge
	}

	@Override
	public Player getPlayerExact(String name){
		return null; //TODO: bridge
	}

	@Override
	public List<Player> matchPlayer(String name){
		return null; //TODO: bridge
	}

	@Override
	public Player getPlayer(UUID id){
		return null; //TODO: bridge
	}

	@Override
	public PluginManager getPluginManager(){
		return null; //TODO: bridge
	}

	@Override
	public BukkitScheduler getScheduler(){
		return null; //TODO: bridge
	}

	@Override
	public ServicesManager getServicesManager(){
		return null; //TODO: bridge
	}

	@Override
	public List<World> getWorlds(){
		return null; //TODO: bridge
	}

	@Override
	public World createWorld(WorldCreator creator){
		return null; //TODO: bridge
	}

	@Override
	public boolean unloadWorld(String name, boolean save){
		return false; //TODO: bridge
	}

	@Override
	public boolean unloadWorld(World world, boolean save){
		return false; //TODO: bridge
	}

	@Override
	public World getWorld(String name){
		return null; //TODO: bridge
	}

	@Override
	public World getWorld(UUID uid){
		return null; //TODO: bridge
	}

	@Override
	public MapView getMap(short id){
		return null; //TODO: bridge
	}

	@Override
	public MapView createMap(World world){
		return null; //TODO: bridge
	}

	@Override
	public void reload(){
		//TODO: bridge
	}

	@Override
	public Logger getLogger(){
		return null; //TODO: bridge
	}

	@Override
	public PluginCommand getPluginCommand(String name){
		return null; //TODO: bridge
	}

	@Override
	public void savePlayers(){
		//TODO: bridge
	}

	@Override
	public boolean dispatchCommand(CommandSender sender, String commandLine) throws CommandException{
		return false; //TODO: bridge
	}

	@Override
	public void configureDbConfig(ServerConfig config){
		//TODO: bridge
	}

	@Override
	public boolean addRecipe(Recipe recipe){
		return false; //TODO: bridge
	}

	@Override
	public List<Recipe> getRecipesFor(ItemStack result){
		return null; //TODO: bridge
	}

	@Override
	public Iterator<Recipe> recipeIterator(){
		return null; //TODO: bridge
	}

	@Override
	public void clearRecipes(){
		//TODO: bridge
	}

	@Override
	public void resetRecipes(){
		//TODO: bridge
	}

	@Override
	public Map<String, String[]> getCommandAliases(){
		return null; //TODO: bridge
	}

	@Override
	public int getSpawnRadius(){
		return 0; //TODO: bridge
	}

	@Override
	public void setSpawnRadius(int value){
		//TODO: bridge
	}

	@Override
	public boolean getOnlineMode(){
		return false; //TODO: bridge
	}

	@Override
	public boolean getAllowFlight(){
		return false; //TODO: bridge
	}

	@Override
	public boolean isHardcore(){
		return false; //TODO: bridge
	}

	@Override
	public boolean useExactLoginLocation(){
		return false; //TODO: bridge
	}

	@Override
	public void shutdown(){
		//TODO: bridge
	}

	@Override
	public int broadcast(String message, String permission){
		return 0; //TODO: bridge
	}

	@Override
	public PoreOfflinePlayer getOfflinePlayer(String name){
		return null; //TODO: bridge
	}

	@Override
	public PoreOfflinePlayer getOfflinePlayer(UUID id){
		return null; //TODO: bridge
	}

	@Override
	public Set<String> getIPBans(){
		return null; //TODO: bridge
	}

	@Override
	public void banIP(String address){
		//TODO: bridge
	}

	@Override
	public void unbanIP(String address){
		//TODO: bridge
	}

	@Override
	public Set<OfflinePlayer> getBannedPlayers(){
		return null; //TODO: bridge
	}

	@Override
	public BanList getBanList(BanList.Type type){
		return null; //TODO: bridge
	}

	@Override
	public Set<OfflinePlayer> getOperators(){
		return null; //TODO: bridge
	}

	@Override
	public GameMode getDefaultGameMode(){
		return null; //TODO: bridge
	}

	@Override
	public void setDefaultGameMode(GameMode mode){
		//TODO: bridge
	}

	@Override
	public ConsoleCommandSender getConsoleSender(){
		return null; //TODO: bridge
	}

	@Override
	public File getWorldContainer(){
		return null; //TODO: bridge
	}

	@Override
	public PoreOfflinePlayer[] getOfflinePlayers(){
		return new PoreOfflinePlayer[0]; //TODO: bridge
	}

	@Override
	public Messenger getMessenger(){
		return null; //TODO: bridge
	}

	@Override
	public HelpMap getHelpMap(){
		return null; //TODO: bridge
	}

	@Override
	public Inventory createInventory(InventoryHolder owner, InventoryType type){
		return null; //TODO: bridge
	}

	@Override
	public Inventory createInventory(InventoryHolder owner, InventoryType type, String title){
		return null; //TODO: bridge
	}

	@Override
	public Inventory createInventory(InventoryHolder owner, int size) throws IllegalArgumentException{
		return null; //TODO: bridge
	}

	@Override
	public Inventory createInventory(InventoryHolder owner, int size, String title) throws IllegalArgumentException{
		return null; //TODO: bridge
	}

	@Override
	public int getMonsterSpawnLimit(){
		return 0; //TODO: bridge
	}

	@Override
	public int getAnimalSpawnLimit(){
		return 0; //TODO: bridge
	}

	@Override
	public int getWaterAnimalSpawnLimit(){
		return 0; //TODO: bridge
	}

	@Override
	public int getAmbientSpawnLimit(){
		return 0; //TODO: bridge
	}

	@Override
	public boolean isPrimaryThread(){
		return false; //TODO: bridge
	}

	@Override
	public String getMotd(){
		return null; //TODO: bridge
	}

	@Override
	public String getShutdownMessage(){
		return null; //TODO: bridge
	}

	@Override
	public Warning.WarningState getWarningState(){
		return null; //TODO: bridge
	}

	@Override
	public ItemFactory getItemFactory(){
		return null; //TODO: bridge
	}

	@Override
	public ScoreboardManager getScoreboardManager(){
		return null; //TODO: bridge
	}

	@Override
	public CachedServerIcon getServerIcon(){
		return null; //TODO: bridge
	}

	@Override
	public CachedServerIcon loadServerIcon(File file) throws IllegalArgumentException, Exception{
		return null; //TODO: bridge
	}

	@Override
	public CachedServerIcon loadServerIcon(BufferedImage image) throws IllegalArgumentException, Exception{
		return null; //TODO: bridge
	}

	@Override
	public void setIdleTimeout(int threshold){
		//TODO: bridge
	}

	@Override
	public int getIdleTimeout(){
		return 0; //TODO: bridge
	}

	@Override
	public UnsafeValues getUnsafe(){
		return null; //TODO: bridge
	}

	@Override
	public void sendPluginMessage(Plugin source, String channel, byte[] message){
		//TODO: bridge
	}

	@Override
	public Set<String> getListeningPluginChannels(){
		return null; //TODO: bridge
	}
}
