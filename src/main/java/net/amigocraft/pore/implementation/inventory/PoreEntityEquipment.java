package net.amigocraft.pore.implementation.inventory;

import org.bukkit.entity.Entity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

// TODO: bridge

public class PoreEntityEquipment implements EntityEquipment {

    @Override
    public ItemStack getItemInHand() {
        return null;
    }

    @Override
    public void setItemInHand(ItemStack stack) {

    }

    @Override
    public ItemStack getHelmet() {
        return null;
    }

    @Override
    public void setHelmet(ItemStack helmet) {

    }

    @Override
    public ItemStack getChestplate() {
        return null;
    }

    @Override
    public void setChestplate(ItemStack chestplate) {

    }

    @Override
    public ItemStack getLeggings() {
        return null;
    }

    @Override
    public void setLeggings(ItemStack leggings) {

    }

    @Override
    public ItemStack getBoots() {
        return null;
    }

    @Override
    public void setBoots(ItemStack boots) {

    }

    @Override
    public ItemStack[] getArmorContents() {
        return new ItemStack[0];
    }

    @Override
    public void setArmorContents(ItemStack[] items) {

    }

    @Override
    public void clear() {

    }

    @Override
    public float getItemInHandDropChance() {
        return 0;
    }

    @Override
    public void setItemInHandDropChance(float chance) {

    }

    @Override
    public float getHelmetDropChance() {
        return 0;
    }

    @Override
    public void setHelmetDropChance(float chance) {

    }

    @Override
    public float getChestplateDropChance() {
        return 0;
    }

    @Override
    public void setChestplateDropChance(float chance) {

    }

    @Override
    public float getLeggingsDropChance() {
        return 0;
    }

    @Override
    public void setLeggingsDropChance(float chance) {

    }

    @Override
    public float getBootsDropChance() {
        return 0;
    }

    @Override
    public void setBootsDropChance(float chance) {

    }

    @Override
    public Entity getHolder() {
        return null;
    }
}
