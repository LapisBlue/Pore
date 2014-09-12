package net.amigocraft.pore.implementation.inventory;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

// TODO: bridge

// TODO: bridge

public class PoreEntityEquipment implements EntityEquipment {

	@Override
	public ItemStack getItemInHand() {
		throw new NotImplementedException();
	}

	@Override
	public void setItemInHand(ItemStack stack) {
		throw new NotImplementedException();
	}

	@Override
	public ItemStack getHelmet() {
		throw new NotImplementedException();
	}

	@Override
	public void setHelmet(ItemStack helmet) {
		throw new NotImplementedException();
	}

	@Override
	public ItemStack getChestplate() {
		throw new NotImplementedException();
	}

	@Override
	public void setChestplate(ItemStack chestplate) {
		throw new NotImplementedException();
	}

	@Override
	public ItemStack getLeggings() {
		throw new NotImplementedException();
	}

	@Override
	public void setLeggings(ItemStack leggings) {
		throw new NotImplementedException();
	}

	@Override
	public ItemStack getBoots() {
		throw new NotImplementedException();
	}

	@Override
	public void setBoots(ItemStack boots) {
		throw new NotImplementedException();
	}

	@Override
	public ItemStack[] getArmorContents() {
		return new ItemStack[0];
	}

	@Override
	public void setArmorContents(ItemStack[] items) {
		throw new NotImplementedException();
	}

	@Override
	public void clear() {
		throw new NotImplementedException();
	}

	@Override
	public float getItemInHandDropChance() {
		return 0;
	}

	@Override
	public void setItemInHandDropChance(float chance) {
		throw new NotImplementedException();
	}

	@Override
	public float getHelmetDropChance() {
		return 0;
	}

	@Override
	public void setHelmetDropChance(float chance) {
		throw new NotImplementedException();
	}

	@Override
	public float getChestplateDropChance() {
		return 0;
	}

	@Override
	public void setChestplateDropChance(float chance) {
		throw new NotImplementedException();
	}

	@Override
	public float getLeggingsDropChance() {
		return 0;
	}

	@Override
	public void setLeggingsDropChance(float chance) {
		throw new NotImplementedException();
	}

	@Override
	public float getBootsDropChance() {
		return 0;
	}

	@Override
	public void setBootsDropChance(float chance) {
		throw new NotImplementedException();
	}

	@Override
	public Entity getHolder() {
		throw new NotImplementedException();
	}
}
