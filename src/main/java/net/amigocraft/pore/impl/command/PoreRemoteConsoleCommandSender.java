package net.amigocraft.pore.impl.command;

import org.bukkit.command.RemoteConsoleCommandSender;
import org.spongepowered.api.service.permission.Subject;

//TODO: Bridge

public class PoreRemoteConsoleCommandSender extends PoreCommandSender implements RemoteConsoleCommandSender {

	// TODO
	protected PoreRemoteConsoleCommandSender(Subject handle) {
		super(handle);
	}
}
