package net.amigocraft.pore.implementation.plugin;

import com.avaje.ebean.EbeanServer;
import net.amigocraft.pore.implementation.command.PoreTabExecutor;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

//TODO: Bridge

//TODO: Bridge

public class PorePlugin extends PoreTabExecutor implements Plugin {

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		throw new NotImplementedException();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		return false;
	}

	@Override
	public File getDataFolder() {
		throw new NotImplementedException();
	}

	@Override
	public PluginDescriptionFile getDescription() {
		throw new NotImplementedException();
	}

	@Override
	public FileConfiguration getConfig() {
		throw new NotImplementedException();
	}

	@Override
	public InputStream getResource(String filename) {
		throw new NotImplementedException();
	}

	@Override
	public void saveConfig() {
		throw new NotImplementedException();
	}

	@Override
	public void saveDefaultConfig() {
		throw new NotImplementedException();
	}

	@Override
	public void saveResource(String resourcePath, boolean replace) {
		throw new NotImplementedException();
	}

	@Override
	public void reloadConfig() {
		throw new NotImplementedException();
	}

	@Override
	public PluginLoader getPluginLoader() {
		throw new NotImplementedException();
	}

	@Override
	public Server getServer() {
		throw new NotImplementedException();
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

	@Override
	public void onDisable() {
		throw new NotImplementedException();
	}

	@Override
	public void onLoad() {
		throw new NotImplementedException();
	}

	@Override
	public void onEnable() {
		throw new NotImplementedException();
	}

	@Override
	public boolean isNaggable() {
		return false;
	}

	@Override
	public void setNaggable(boolean canNag) {
		throw new NotImplementedException();
	}

	@Override
	public EbeanServer getDatabase() {
		throw new NotImplementedException();
	}

	@Override
	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
		throw new NotImplementedException();
	}

	@Override
	public Logger getLogger() {
		throw new NotImplementedException();
	}

	@Override
	public String getName() {
		throw new NotImplementedException();
	}

}
