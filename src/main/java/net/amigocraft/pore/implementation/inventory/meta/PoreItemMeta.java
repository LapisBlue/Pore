package net.amigocraft.pore.implementation.inventory.meta;

// TODO: bridge

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Map;

public class PoreItemMeta implements ItemMeta {

	@Override
	public boolean hasDisplayName() {
		return false;
	}

	@Override
	public String getDisplayName() {
		throw new NotImplementedException();
	}

	@Override
	public void setDisplayName(String name) {
		throw new NotImplementedException();
	}

	@Override
	public boolean hasLore() {
		return false;
	}

	@Override
	public List<String> getLore() {
		throw new NotImplementedException();
	}

	@Override
	public void setLore(List<String> lore) {
		throw new NotImplementedException();
	}

	@Override
	public boolean hasEnchants() {
		return false;
	}

	@Override
	public boolean hasEnchant(Enchantment ench) {
		return false;
	}

	@Override
	public int getEnchantLevel(Enchantment ench) {
		return 0;
	}

	@Override
	public Map<Enchantment, Integer> getEnchants() {
		throw new NotImplementedException();
	}

	@Override
	public boolean addEnchant(Enchantment ench, int level, boolean ignoreLevelRestriction) {
		return false;
	}

	@Override
	public boolean removeEnchant(Enchantment ench) {
		return false;
	}

	@Override
	public boolean hasConflictingEnchant(Enchantment ench) {
		return false;
	}

	@Override
	public ItemMeta clone() {
		throw new NotImplementedException();
	}

	@Override
	public Map<String, Object> serialize() {
		throw new NotImplementedException();
	}
}
