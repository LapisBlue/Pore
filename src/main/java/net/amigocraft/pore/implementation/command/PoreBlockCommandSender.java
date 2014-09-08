package net.amigocraft.pore.implementation.command;

import org.bukkit.block.Block;
import org.bukkit.command.BlockCommandSender;

public class PoreBlockCommandSender extends PoreCommandSender implements BlockCommandSender {

	@Override
	public Block getBlock() {
		return null; // TODO: Bridge
	}

}
