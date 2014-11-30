package net.amigocraft.pore.impl.inventory.meta;

// TODO: bridge

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Map;

public class PoreItemMeta implements ItemMeta {

	@Override
	public boolean hasDisplayName() {
		throw new NotImplementedException();
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
		throw new NotImplementedException();
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
		throw new NotImplementedException();
	}

	@Override
	public boolean hasEnchant(Enchantment ench) {
		throw new NotImplementedException();
	}

	@Override
	public int getEnchantLevel(Enchantment ench) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Enchantment, Integer> getEnchants() {
		throw new NotImplementedException();
	}

	@Override
	public boolean addEnchant(Enchantment ench, int level, boolean ignoreLevelRestriction) {
		throw new NotImplementedException();
	}

	@Override
	public boolean removeEnchant(Enchantment ench) {
		throw new NotImplementedException();
	}

	@Override
	public boolean hasConflictingEnchant(Enchantment ench) {
		throw new NotImplementedException();
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
