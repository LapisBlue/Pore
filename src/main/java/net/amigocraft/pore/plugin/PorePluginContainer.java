package net.amigocraft.pore.plugin;

import net.amigocraft.pore.util.PoreWrapper;
import org.bukkit.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;

public class PorePluginContainer extends PoreWrapper<Plugin> implements PluginContainer {
	public PorePluginContainer(Plugin handle) {
		super(handle);
	}

	@Override
	public String getId() {
		return "pore:" + getHandle().getName(); // TODO
	}

	@Override
	public String getName() {
		return getHandle().getName();
	}

	@Override
	public String getVersion() {
		return getHandle().getDescription().getVersion();
	}

	@Override
	public Object getInstance() {
		return getHandle();
	}
}
