package net.amigocraft.pore.implementation.block;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.Dispenser;
import org.bukkit.inventory.Inventory;
import org.bukkit.projectiles.BlockProjectileSource;
import org.spongepowered.api.block.BlockLoc;

//TODO: skeleton implementation

public class PoreDispenser extends PoreBlockState implements Dispenser {
	public PoreDispenser(BlockLoc spongeBlock) {
		super(spongeBlock);
	}

	@Override
	public BlockProjectileSource getBlockProjectileSource() {
		throw new NotImplementedException();
	}

	@Override
	public boolean dispense() {
		throw new NotImplementedException();
	}

	@Override
	public Inventory getInventory() {
		throw new NotImplementedException();
	}
}
