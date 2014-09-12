package net.amigocraft.pore.implementation.plugin;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.*;

import java.io.File;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

//TODO: Bridge
public class PorePluginLoader implements PluginLoader {

	@Override
	public Plugin loadPlugin(File file) throws InvalidPluginException, UnknownDependencyException {
		throw new NotImplementedException();
	}

	@Override
	public PluginDescriptionFile getPluginDescription(File file) throws InvalidDescriptionException {
		throw new NotImplementedException();
	}

	@Override
	public Pattern[] getPluginFileFilters() {
		throw new NotImplementedException();
	}

	@Override
	public Map<Class<? extends Event>, Set<RegisteredListener>> createRegisteredListeners(Listener listener, Plugin plugin) {
		throw new NotImplementedException();
	}

	@Override
	public void enablePlugin(Plugin plugin) {
		throw new NotImplementedException();
	}

	@Override
	public void disablePlugin(Plugin plugin) {
		throw new NotImplementedException();
	}

}
