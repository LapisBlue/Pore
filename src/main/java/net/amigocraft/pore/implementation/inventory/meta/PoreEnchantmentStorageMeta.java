package net.amigocraft.pore.implementation.inventory.meta;

// TODO: bridge

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

import java.util.Map;

public class PoreEnchantmentStorageMeta extends PoreItemMeta implements EnchantmentStorageMeta {
	@Override
	public boolean hasStoredEnchants() {
		return false;
	}

	@Override
	public boolean hasStoredEnchant(Enchantment ench) {
		return false;
	}

	@Override
	public int getStoredEnchantLevel(Enchantment ench) {
		return 0;
	}

	@Override
	public Map<Enchantment, Integer> getStoredEnchants() {
		return null;
	}

	@Override
	public boolean addStoredEnchant(Enchantment ench, int level, boolean ignoreLevelRestriction) {
		return false;
	}

	@Override
	public boolean removeStoredEnchant(Enchantment ench) throws IllegalArgumentException {
		return false;
	}

	@Override
	public boolean hasConflictingStoredEnchant(Enchantment ench) {
		return false;
	}

	@Override
	public EnchantmentStorageMeta clone() {
		return null;
	}
}
