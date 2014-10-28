package net.amigocraft.pore.implementation.command;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.Block;
import org.bukkit.command.BlockCommandSender;

public class PoreBlockCommandSender extends PoreCommandSender implements BlockCommandSender {

	@Override
	public Block getBlock() {
		throw new NotImplementedException(); // TODO: Bridge
	}

}
