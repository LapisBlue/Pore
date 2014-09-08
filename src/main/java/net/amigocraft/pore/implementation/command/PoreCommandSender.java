package net.amigocraft.pore.implementation.command;

import org.bukkit.Server;
import org.bukkit.command.CommandSender;

import net.amigocraft.pore.implementation.permissions.PorePermissible;

public class PoreCommandSender extends PorePermissible implements CommandSender {

	@Override
	public void sendMessage(String message) {
		// TODO: Bridge
	}

	@Override
	public void sendMessage(String[] messages) {
		// TODO: Bridge
	}

	@Override
	public Server getServer() {
		return null; // TODO: Bridge
	}

	@Override
	public String getName() {
		return null; // TODO: Bridge
	}

}
