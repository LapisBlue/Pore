package net.amigocraft.pore.implementation.block;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.Sign;

//TODO: skeleton implementation

//TODO: skeleton implementation

public class PoreSign extends PoreBlockState implements Sign {
	public PoreSign(org.spongepowered.api.block.Block spongeBlock) {
		super(spongeBlock);
	}

	@Override
	public String[] getLines() {
		throw new NotImplementedException();
	}

	@Override
	public String getLine(int index) throws IndexOutOfBoundsException {
		throw new NotImplementedException();
	}

	@Override
	public void setLine(int index, String line) throws IndexOutOfBoundsException {
		throw new NotImplementedException();
	}
}
