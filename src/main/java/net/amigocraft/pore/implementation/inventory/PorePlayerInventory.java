package net.amigocraft.pore.implementation.inventory;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

// TODO: bridge

public class PorePlayerInventory extends PoreInventory implements PlayerInventory {

    @Override
    public ItemStack[] getArmorContents() {
        return new ItemStack[0];
    }

    @Override
    public ItemStack getHelmet() {
        return null;
    }

    @Override
    public ItemStack getChestplate() {
        return null;
    }

    @Override
    public ItemStack getLeggings() {
        return null;
    }

    @Override
    public ItemStack getBoots() {
        return null;
    }

    @Override
    public void setArmorContents(ItemStack[] items) {

    }

    @Override
    public void setHelmet(ItemStack helmet) {

    }

    @Override
    public void setChestplate(ItemStack chestplate) {

    }

    @Override
    public void setLeggings(ItemStack leggings) {

    }

    @Override
    public void setBoots(ItemStack boots) {

    }

    @Override
    public ItemStack getItemInHand() {
        return null;
    }

    @Override
    public void setItemInHand(ItemStack stack) {

    }

    @Override
    public int getHeldItemSlot() {
        return 0;
    }

    @Override
    public void setHeldItemSlot(int slot) {

    }

    @Override
    public int clear(int id, int data) {
        return 0;
    }

    @Override
    public Player getHolder() {
        return null;
    }
}