package net.amigocraft.pore.implementation.plugin.messaging;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.messaging.PluginMessageRecipient;

import java.util.Set;

// TODO: Bridge

// TODO: Bridge

public class PorePluginMessageRecipient implements PluginMessageRecipient {

	@Override
	public void sendPluginMessage(Plugin source, String channel, byte[] message) {
		throw new NotImplementedException();
	}

	@Override
	public Set<String> getListeningPluginChannels() {
		throw new NotImplementedException();
	}

}
