package net.amigocraft.pore.impl.inventory.meta;

// TODO: bridge

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

import java.util.Map;

public class PoreEnchantmentStorageMeta extends PoreItemMeta implements EnchantmentStorageMeta {
	@Override
	public boolean hasStoredEnchants() {
		throw new NotImplementedException();
	}

	@Override
	public boolean hasStoredEnchant(Enchantment ench) {
		throw new NotImplementedException();
	}

	@Override
	public int getStoredEnchantLevel(Enchantment ench) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Enchantment, Integer> getStoredEnchants() {
		throw new NotImplementedException();
	}

	@Override
	public boolean addStoredEnchant(Enchantment ench, int level, boolean ignoreLevelRestriction) {
		throw new NotImplementedException();
	}

	@Override
	public boolean removeStoredEnchant(Enchantment ench) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public boolean hasConflictingStoredEnchant(Enchantment ench) {
		throw new NotImplementedException();
	}

	@Override
	public EnchantmentStorageMeta clone() {
		throw new NotImplementedException();
	}
}
