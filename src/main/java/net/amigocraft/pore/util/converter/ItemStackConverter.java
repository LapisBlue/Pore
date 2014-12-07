/*
 * Pore
 * Copyright (c) 2014, Maxim Roncacé <http://bitbucket.org/mproncace>
 * Copyright (c) 2014, Lapis <https://github.com/LapisBlue>
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
package net.amigocraft.pore.util.converter;

import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStackBuilder;

public class ItemStackConverter {

    public static org.bukkit.inventory.ItemStack of(org.spongepowered.api.item.inventory.ItemStack stack) {
        return new org.bukkit.inventory.ItemStack(
                MaterialConverter.toBukkitMaterial(stack.getItem()),
                stack.getQuantity(),
                stack.getDamage()
        );
    }

    public static org.spongepowered.api.item.inventory.ItemStack of(org.bukkit.inventory.ItemStack stack) {
        ItemType type = MaterialConverter.toItemType(stack.getType());
        if (type == null)
            throw new UnsupportedOperationException();
        // IntelliJ doesn't recognize the above check and thinks withItemType() may throw an NPE
        //noinspection ConstantConditions
        return ItemTypes.getItemBuilder()
                .withItemType(type)
                .withQuantity(stack.getAmount())
                .withDamage(stack.getDurability())
                .withMaxQuantity(stack.getType().getMaxStackSize())
                .build();
    }

}
