package net.amigocraft.pore.implementation.block;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.CommandBlock;
import org.spongepowered.api.block.BlockLoc;

//TODO: skeleton implementation

public class PoreCommandBlock extends PoreBlockState implements CommandBlock {
	public PoreCommandBlock(BlockLoc spongeBlock) {
		super(spongeBlock);
	}

	@Override
	public String getCommand() {
		throw new NotImplementedException();
	}

	@Override
	public void setCommand(String command) {
		throw new NotImplementedException();
	}

	@Override
	public String getName() {
		throw new NotImplementedException();
	}

	@Override
	public void setName(String name) {
		throw new NotImplementedException();
	}
}
