package net.amigocraft.pore.implementation.inventory;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

// TODO: bridge

public class PoreItemFactory implements ItemFactory {

	@Override
	public ItemMeta getItemMeta(Material material) {
		return null;
	}

	@Override
	public boolean isApplicable(ItemMeta meta, ItemStack stack) throws IllegalArgumentException {
		return false;
	}

	@Override
	public boolean isApplicable(ItemMeta meta, Material material) throws IllegalArgumentException {
		return false;
	}

	@Override
	public boolean equals(ItemMeta meta1, ItemMeta meta2) throws IllegalArgumentException {
		return false;
	}

	@Override
	public ItemMeta asMetaFor(ItemMeta meta, ItemStack stack) throws IllegalArgumentException {
		return null;
	}

	@Override
	public ItemMeta asMetaFor(ItemMeta meta, Material material) throws IllegalArgumentException {
		return null;
	}

	@Override
	public Color getDefaultLeatherColor() {
		return null;
	}
}
