package net.amigocraft.pore.implementation.inventory;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

// TODO: bridge

// TODO: bridge

public class PoreItemFactory implements ItemFactory {

	@Override
	public ItemMeta getItemMeta(Material material) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isApplicable(ItemMeta meta, ItemStack stack) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public boolean isApplicable(ItemMeta meta, Material material) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public boolean equals(ItemMeta meta1, ItemMeta meta2) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public ItemMeta asMetaFor(ItemMeta meta, ItemStack stack) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public ItemMeta asMetaFor(ItemMeta meta, Material material) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public Color getDefaultLeatherColor() {
		throw new NotImplementedException();
	}
}
