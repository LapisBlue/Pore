package net.amigocraft.pore.implementation.inventory;

import org.bukkit.inventory.HorseInventory;
import org.bukkit.inventory.ItemStack;

// TODO: bridge

public class PoreHorseInventory extends PoreInventory implements HorseInventory {

    @Override
    public ItemStack getSaddle() {
        return null;
    }

    @Override
    public ItemStack getArmor() {
        return null;
    }

    @Override
    public void setSaddle(ItemStack stack) {

    }

    @Override
    public void setArmor(ItemStack stack) {

    }
}