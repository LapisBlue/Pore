package net.amigocraft.pore.implementation.command;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCommandExecutor;

import java.util.List;

//TODO: Bridge

@Deprecated
public class PoreTabCommandExecutor implements TabCommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		throw new NotImplementedException();
	}

	@Override
	public List<String> onTabComplete() {
		throw new NotImplementedException();
	}

}
