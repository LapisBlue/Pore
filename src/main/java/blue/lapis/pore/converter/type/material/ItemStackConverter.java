/*
 * Pore
 * Copyright (c) 2014-2016, Lapis <https://github.com/LapisBlue>
 *
 * The MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package blue.lapis.pore.converter.type.material;

import org.bukkit.Material;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;

public final class ItemStackConverter {

    private ItemStackConverter() {
    }

    public static org.bukkit.inventory.ItemStack of(org.spongepowered.api.item.inventory.ItemStack stack) {
        if (stack == null) {
            return new org.bukkit.inventory.ItemStack(Material.AIR);
        }

        return new org.bukkit.inventory.ItemStack(
                MaterialConverter.of(stack.getItem()),
                stack.getQuantity(),
                (short) DurabilityConverter.getDamageValue(stack.getContainers())
        );
    }

    @SuppressWarnings("unchecked")
    public static org.spongepowered.api.item.inventory.ItemStack of(org.bukkit.inventory.ItemStack stack) {
        ItemType type = MaterialConverter.asItem(stack.getType());
        if (type == null) {
            throw new UnsupportedOperationException();
        }
        // IntelliJ doesn't recognize the above check and thinks withItemType() may throw an NPE
        //noinspection ConstantConditions
        return ItemStack.builder()
                .itemType(type)
                .quantity(stack.getAmount())
                .itemData(DurabilityConverter.getItemData(stack))
                //.maxQuantity(stack.getType().getMaxStackSize()) //TODO
                .build();
    }

}
