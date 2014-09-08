package net.amigocraft.pore.implementation.command;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCommandExecutor;

//TODO: Bridge

@Deprecated
public class PoreTabCommandExecutor implements TabCommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		return false;
	}

	@Override
	public List<String> onTabComplete() {
		return null;
	}

}
