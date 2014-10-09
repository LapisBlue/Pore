package net.amigocraft.pore.implementation.inventory;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

// TODO: bridge

// TODO: bridge

public class PorePlayerInventory extends PoreInventory implements PlayerInventory {

	@Override
	public ItemStack[] getArmorContents() {
		throw new NotImplementedException();
	}

	@Override
	public ItemStack getHelmet() {
		throw new NotImplementedException();
	}

	@Override
	public ItemStack getChestplate() {
		throw new NotImplementedException();
	}

	@Override
	public ItemStack getLeggings() {
		throw new NotImplementedException();
	}

	@Override
	public ItemStack getBoots() {
		throw new NotImplementedException();
	}

	@Override
	public void setArmorContents(ItemStack[] items) {
		throw new NotImplementedException();
	}

	@Override
	public void setHelmet(ItemStack helmet) {
		throw new NotImplementedException();
	}

	@Override
	public void setChestplate(ItemStack chestplate) {
		throw new NotImplementedException();
	}

	@Override
	public void setLeggings(ItemStack leggings) {
		throw new NotImplementedException();
	}

	@Override
	public void setBoots(ItemStack boots) {
		throw new NotImplementedException();
	}

	@Override
	public ItemStack getItemInHand() {
		throw new NotImplementedException();
	}

	@Override
	public void setItemInHand(ItemStack stack) {
		throw new NotImplementedException();
	}

	@Override
	public int getHeldItemSlot() {
		throw new NotImplementedException();
	}

	@Override
	public void setHeldItemSlot(int slot) {
		throw new NotImplementedException();
	}

	@Override
	public int clear(int id, int data) {
		throw new NotImplementedException();
	}

	@Override
	public Player getHolder() {
		throw new NotImplementedException();
	}
}