package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.util.Collection;

public class PoreThrownPotion extends PoreProjectile implements ThrownPotion {

	// TODO: Bridge

	public PoreThrownPotion(org.spongepowered.api.entity.Entity handle) { //TODO: accept most specfific type
		super(handle);
	}

	@Override
	public Collection<PotionEffect> getEffects() {
		throw new NotImplementedException();
	}

	@Override
	public ItemStack getItem() {
		throw new NotImplementedException();
	}

	@Override
	public void setItem(ItemStack item) {
		throw new NotImplementedException();
	}
}
