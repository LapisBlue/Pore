package net.amigocraft.pore.implementation.plugin;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

import net.amigocraft.pore.implementation.command.PoreTabExecutor;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;

import com.avaje.ebean.EbeanServer;

public class PorePlugin extends PoreTabExecutor implements Plugin  {

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		return null; //TODO: Bridge
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		return false; //TODO: Bridge
	}

	@Override
	public File getDataFolder() {
		return null; //TODO: Bridge
	}

	@Override
	public PluginDescriptionFile getDescription() {
		return null; //TODO: Bridge
	}

	@Override
	public FileConfiguration getConfig() {
		return null; //TODO: Bridge
	}

	@Override
	public InputStream getResource(String filename) {
		return null; //TODO: Bridge
	}

	@Override
	public void saveConfig() {
		 //TODO: Bridge
	}

	@Override
	public void saveDefaultConfig() {
		 //TODO: Bridge
	}

	@Override
	public void saveResource(String resourcePath, boolean replace) {
		 //TODO: Bridge
	}

	@Override
	public void reloadConfig() {
		 //TODO: Bridge
	}

	@Override
	public PluginLoader getPluginLoader() {
		return null; //TODO: Bridge
	}

	@Override
	public Server getServer() {
		return null; //TODO: Bridge
	}

	@Override
	public boolean isEnabled() {
		return false; //TODO: Bridge
	}

	@Override
	public void onDisable() {
		 //TODO: Bridge
	}

	@Override
	public void onLoad() {
		 //TODO: Bridge
	}

	@Override
	public void onEnable() {
		 //TODO: Bridge
	}

	@Override
	public boolean isNaggable() {
		return false; //TODO: Bridge
	}

	@Override
	public void setNaggable(boolean canNag) {
		 //TODO: Bridge
	}

	@Override
	public EbeanServer getDatabase() {
		return null; //TODO: Bridge
	}

	@Override
	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
		return null; //TODO: Bridge
	}

	@Override
	public Logger getLogger() {
		return null; //TODO: Bridge
	}

	@Override
	public String getName() {
		return null; //TODO: Bridge
	}

}
