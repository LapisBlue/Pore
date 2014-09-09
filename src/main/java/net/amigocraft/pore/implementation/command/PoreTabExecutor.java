package net.amigocraft.pore.implementation.command;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

public class PoreTabExecutor implements TabExecutor {

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		return null;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		return false;
	}

}
