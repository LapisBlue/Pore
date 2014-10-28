package net.amigocraft.pore.implementation.command;

import net.amigocraft.pore.implementation.permissions.PorePermissible;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;

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
		throw new NotImplementedException(); // TODO: Bridge
	}

	@Override
	public String getName() {
		throw new NotImplementedException(); // TODO: Bridge
	}

}
