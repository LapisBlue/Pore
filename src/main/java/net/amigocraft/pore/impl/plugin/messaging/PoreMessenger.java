package net.amigocraft.pore.impl.plugin.messaging;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.bukkit.plugin.messaging.PluginMessageListenerRegistration;

import java.util.Set;

// TODO: Bridge

// TODO: Bridge

public class PoreMessenger implements Messenger {

	@Override
	public boolean isReservedChannel(String channel) {
		throw new NotImplementedException();
	}

	@Override
	public void registerOutgoingPluginChannel(Plugin plugin, String channel) {
		throw new NotImplementedException();
	}

	@Override
	public void unregisterOutgoingPluginChannel(Plugin plugin, String channel) {
		throw new NotImplementedException();
	}

	@Override
	public void unregisterOutgoingPluginChannel(Plugin plugin) {
		throw new NotImplementedException();
	}

	@Override
	public PluginMessageListenerRegistration registerIncomingPluginChannel(Plugin plugin, String channel, PluginMessageListener listener) {
		throw new NotImplementedException();
	}

	@Override
	public void unregisterIncomingPluginChannel(Plugin plugin, String channel, PluginMessageListener listener) {
		throw new NotImplementedException();
	}

	@Override
	public void unregisterIncomingPluginChannel(Plugin plugin, String channel) {
		throw new NotImplementedException();
	}

	@Override
	public void unregisterIncomingPluginChannel(Plugin plugin) {
		throw new NotImplementedException();
	}

	@Override
	public Set<String> getOutgoingChannels() {
		throw new NotImplementedException();
	}

	@Override
	public Set<String> getOutgoingChannels(Plugin plugin) {
		throw new NotImplementedException();
	}

	@Override
	public Set<String> getIncomingChannels() {
		throw new NotImplementedException();
	}

	@Override
	public Set<String> getIncomingChannels(Plugin plugin) {
		throw new NotImplementedException();
	}

	@Override
	public Set<PluginMessageListenerRegistration> getIncomingChannelRegistrations(Plugin plugin) {
		throw new NotImplementedException();
	}

	@Override
	public Set<PluginMessageListenerRegistration> getIncomingChannelRegistrations(String channel) {
		throw new NotImplementedException();
	}

	@Override
	public Set<PluginMessageListenerRegistration> getIncomingChannelRegistrations(Plugin plugin, String channel) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isRegistrationValid(PluginMessageListenerRegistration registration) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isIncomingChannelRegistered(Plugin plugin, String channel) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isOutgoingChannelRegistered(Plugin plugin, String channel) {
		throw new NotImplementedException();
	}

	@Override
	public void dispatchIncomingMessage(Player source, String channel, byte[] message) {
		throw new NotImplementedException();
	}

}
