package net.amigocraft.pore.implementation.block;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.block.Dispenser;
import org.bukkit.inventory.Inventory;
import org.bukkit.projectiles.BlockProjectileSource;

//TODO: skeleton implementation

//TODO: skeleton implementation

public class PoreDispenser extends PoreBlockState implements Dispenser {
	public PoreDispenser(org.spongepowered.api.block.Block spongeBlock) {
		super(spongeBlock);
	}

	@Override
	public BlockProjectileSource getBlockProjectileSource() {
		throw new NotImplementedException();
	}

	@Override
	public boolean dispense() {
		return false;
	}

	@Override
	public Inventory getInventory() {
		throw new NotImplementedException();
	}
}
