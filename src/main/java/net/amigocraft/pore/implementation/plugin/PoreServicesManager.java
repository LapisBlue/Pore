package net.amigocraft.pore.implementation.plugin;

import java.util.Collection;
import java.util.List;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.ServicesManager;

public class PoreServicesManager implements ServicesManager {

	@Override
	public <T> void register(Class<T> service, T provider, Plugin plugin, ServicePriority priority) {
		 //TODO: Bridge
	}

	@Override
	public void unregisterAll(Plugin plugin) {
		 //TODO: Bridge
	}

	@Override
	public void unregister(Class<?> service, Object provider) {
		 //TODO: Bridge
	}

	@Override
	public void unregister(Object provider) {
		 //TODO: Bridge
	}

	@Override
	public <T> T load(Class<T> service) {
		return null; //TODO: Bridge
	}

	@Override
	public <T> RegisteredServiceProvider<T> getRegistration(Class<T> service) {
		return null; //TODO: Bridge
	}

	@Override
	public List<RegisteredServiceProvider<?>> getRegistrations(Plugin plugin) {
		return null; //TODO: Bridge
	}

	@Override
	public <T> Collection<RegisteredServiceProvider<T>> getRegistrations(Class<T> service) {
		return null; //TODO: Bridge
	}

	@Override
	public Collection<Class<?>> getKnownServices() {
		return null; //TODO: Bridge
	}

	@Override
	public <T> boolean isProvidedFor(Class<T> service) {
		return false; //TODO: Bridge
	}

}
