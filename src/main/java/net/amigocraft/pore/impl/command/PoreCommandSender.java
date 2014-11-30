package net.amigocraft.pore.impl.command;

import net.amigocraft.pore.impl.permissions.PorePermissible;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.spongepowered.api.service.permission.Subject;

public class PoreCommandSender extends PorePermissible implements CommandSender {

	// TODO
	protected PoreCommandSender(Subject handle) {
		super(handle);
	}

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
