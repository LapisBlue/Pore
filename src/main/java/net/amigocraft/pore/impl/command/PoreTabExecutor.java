package net.amigocraft.pore.impl.command;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.List;

//TODO: don't think this is implemented in Craftbukkit
public class PoreTabExecutor implements TabExecutor {

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		throw new NotImplementedException();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		throw new NotImplementedException();
	}

}
