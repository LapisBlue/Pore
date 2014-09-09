package net.amigocraft.pore.implementation.block;

import org.bukkit.block.CommandBlock;

//TODO: skeleton implementation

public class PoreCommandBlock extends PoreBlockState implements CommandBlock {
	public PoreCommandBlock(org.spongepowered.api.block.Block spongeBlock) {
		super(spongeBlock);
	}

	@Override
	public String getCommand() {
		return null;
	}

	@Override
	public void setCommand(String command) {

	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public void setName(String name) {

	}
}
