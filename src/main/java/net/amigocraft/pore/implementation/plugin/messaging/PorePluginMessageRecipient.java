package net.amigocraft.pore.implementation.plugin.messaging;

import java.util.Set;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.messaging.PluginMessageRecipient;

// TODO: Bridge

public class PorePluginMessageRecipient implements PluginMessageRecipient {

	@Override
	public void sendPluginMessage(Plugin source, String channel, byte[] message) {

	}

	@Override
	public Set<String> getListeningPluginChannels() {
		return null;
	}

}
