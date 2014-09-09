package net.amigocraft.pore.implementation.block;

import org.bukkit.block.Furnace;
import org.bukkit.inventory.FurnaceInventory;

//TODO: skeleton implementation

public class PoreFurnace extends PoreBlockState implements Furnace {
	public PoreFurnace(org.spongepowered.api.block.Block spongeBlock) {
		super(spongeBlock);
	}

	@Override
	public short getBurnTime() {
		return 0;
	}

	@Override
	public void setBurnTime(short burnTime) {

	}

	@Override
	public short getCookTime() {
		return 0;
	}

	@Override
	public void setCookTime(short cookTime) {

	}

	@Override
	public FurnaceInventory getInventory() {
		return null;
	}
}
