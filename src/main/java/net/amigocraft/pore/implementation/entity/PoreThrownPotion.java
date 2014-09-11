package net.amigocraft.pore.implementation.entity;

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
        return null;
    }

    @Override
    public ItemStack getItem() {
        return null;
    }

    @Override
    public void setItem(ItemStack item) {

    }
}
