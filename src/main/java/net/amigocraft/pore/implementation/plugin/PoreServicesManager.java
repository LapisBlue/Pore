package net.amigocraft.pore.implementation.plugin;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.ServicesManager;

import java.util.Collection;
import java.util.List;

public class PoreServicesManager implements ServicesManager {

	//TODO: Bridge

	@Override
	public <T> void register(Class<T> service, T provider, Plugin plugin, ServicePriority priority) {
		throw new NotImplementedException();
	}

	@Override
	public void unregisterAll(Plugin plugin) {
		throw new NotImplementedException();
	}

	@Override
	public void unregister(Class<?> service, Object provider) {
		throw new NotImplementedException();
	}

	@Override
	public void unregister(Object provider) {
		throw new NotImplementedException();
	}

	@Override
	public <T> T load(Class<T> service) {
		throw new NotImplementedException();
	}

	@Override
	public <T> RegisteredServiceProvider<T> getRegistration(Class<T> service) {
		throw new NotImplementedException();
	}

	@Override
	public List<RegisteredServiceProvider<?>> getRegistrations(Plugin plugin) {
		throw new NotImplementedException();
	}

	@Override
	public <T> Collection<RegisteredServiceProvider<T>> getRegistrations(Class<T> service) {
		throw new NotImplementedException();
	}

	@Override
	public Collection<Class<?>> getKnownServices() {
		throw new NotImplementedException();
	}

	@Override
	public <T> boolean isProvidedFor(Class<T> service) {
		return false;
	}

}
