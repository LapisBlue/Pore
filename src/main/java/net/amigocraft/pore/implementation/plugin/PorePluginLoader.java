package net.amigocraft.pore.implementation.plugin;

import java.io.File;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.RegisteredListener;
import org.bukkit.plugin.UnknownDependencyException;

public class PorePluginLoader implements PluginLoader {

	@Override
	public Plugin loadPlugin(File file) throws InvalidPluginException, UnknownDependencyException {
		return null; //TODO: Bridge
	}

	@Override
	public PluginDescriptionFile getPluginDescription(File file) throws InvalidDescriptionException {
		return null; //TODO: Bridge
	}

	@Override
	public Pattern[] getPluginFileFilters() {
		return null; //TODO: Bridge
	}

	@Override
	public Map<Class<? extends Event>, Set<RegisteredListener>> createRegisteredListeners(Listener listener, Plugin plugin) {
		return null; //TODO: Bridge
	}

	@Override
	public void enablePlugin(Plugin plugin) {
		 //TODO: Bridge
	}

	@Override
	public void disablePlugin(Plugin plugin) {
		 //TODO: Bridge
	}

}
