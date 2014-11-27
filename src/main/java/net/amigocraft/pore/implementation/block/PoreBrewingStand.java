package net.amigocraft.pore.implementation.block;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.BrewingStand;
import org.bukkit.inventory.BrewerInventory;
import org.spongepowered.api.block.BlockLoc;

//TODO: skeleton implementation

//TODO: skeleton implementation

public class PoreBrewingStand extends PoreBlockState implements BrewingStand {
	public PoreBrewingStand(BlockLoc spongeBlock) {
		super(spongeBlock);
	}

	@Override
	public int getBrewingTime() {
		throw new NotImplementedException();
	}

	@Override
	public void setBrewingTime(int brewTime) {
		throw new NotImplementedException();
	}

	@Override
	public BrewerInventory getInventory() {
		throw new NotImplementedException();
	}
}
