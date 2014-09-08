package net.amigocraft.pore.implementation.inventory;

import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

// TODO: bridge

public class PoreCraftingInventory extends PoreInventory implements CraftingInventory {

    @Override
    public ItemStack getResult() {
        return null;
    }

    @Override
    public ItemStack[] getMatrix() {
        return new ItemStack[0];
    }

    @Override
    public void setResult(ItemStack newResult) {

    }

    @Override
    public void setMatrix(ItemStack[] contents) {

    }

    @Override
    public Recipe getRecipe() {
        return null;
    }
}