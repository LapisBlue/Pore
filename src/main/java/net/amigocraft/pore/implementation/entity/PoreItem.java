package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

public class PoreItem extends PoreEntity implements Item {
    @Override
    public ItemStack getItemStack() {
        return null;
    }

    @Override
    public void setItemStack(ItemStack stack) {

    }

    @Override
    public int getPickupDelay() {
        return 0;
    }

    @Override
    public void setPickupDelay(int delay) {

    }
}
