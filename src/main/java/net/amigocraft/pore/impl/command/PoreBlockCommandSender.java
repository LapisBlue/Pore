package net.amigocraft.pore.impl.command;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.Block;
import org.bukkit.command.BlockCommandSender;
import org.spongepowered.api.service.permission.Subject;

public class PoreBlockCommandSender extends PoreCommandSender implements BlockCommandSender {

	// TODO
	protected PoreBlockCommandSender(Subject handle) {
		super(handle);
	}

	@Override
	public Block getBlock() {
		throw new NotImplementedException(); // TODO: Bridge
	}

}
