package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.ThrownPotion;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.util.Collection;

public class PoreThrownPotion extends PoreProjectile implements ThrownPotion {
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
