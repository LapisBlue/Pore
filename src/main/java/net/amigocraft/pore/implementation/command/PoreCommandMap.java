package net.amigocraft.pore.implementation.command;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;

public class PoreCommandMap implements CommandMap {

	@Override
	public void registerAll(String fallbackPrefix, List<Command> commands) {
		// TODO: Bridge
	}

	@Override
	public boolean register(String label, String fallbackPrefix, Command command) {
		return false; // TODO: Bridge
	}

	@Override
	public boolean register(String fallbackPrefix, Command command) {
		return false; // TODO: Bridge
	}

	@Override
	public boolean dispatch(CommandSender sender, String cmdLine) throws CommandException {
		return false; // TODO: Bridge
	}

	@Override
	public void clearCommands() {
		// TODO: Bridge
	}

	@Override
	public Command getCommand(String name) {
		return null; // TODO: Bridge
	}

	@Override
	public List<String> tabComplete(CommandSender sender, String cmdLine) throws IllegalArgumentException {
		return null; // TODO: Bridge
	}

}
