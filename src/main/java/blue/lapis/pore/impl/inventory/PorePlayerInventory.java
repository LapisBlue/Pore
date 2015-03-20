/*
 * Pore
 * Copyright (c) 2014-2015, Lapis <https://github.com/LapisBlue>
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
package blue.lapis.pore.impl.inventory;

import blue.lapis.pore.converter.ItemStackConverter;
import blue.lapis.pore.converter.type.MaterialConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;
import blue.lapis.pore.impl.entity.PorePlayer;

import com.google.common.base.Optional;
import com.google.common.collect.Iterables;
import org.apache.commons.lang.Validate;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.spongepowered.api.item.data.DurabilityData;
import org.spongepowered.api.item.data.ItemData;
import org.spongepowered.api.item.inventory.Slot;
import org.spongepowered.api.item.inventory.entity.Hotbar;
import org.spongepowered.api.item.inventory.entity.HumanInventory;
import org.spongepowered.api.item.inventory.equipment.EquipmentTypes;
import org.spongepowered.api.item.inventory.properties.SlotIndex;

public class PorePlayerInventory extends PoreInventory implements PlayerInventory {

    public static PorePlayerInventory of(HumanInventory handle) {
        return WrapperConverter.of(PorePlayerInventory.class, handle);
    }

    protected PorePlayerInventory(HumanInventory handle) {
        super(handle);
    }

    @Override
    public HumanInventory getHandle() {
        return (HumanInventory)super.getHandle();
    }

    @Override
    public ItemStack[] getArmorContents() {
        return new ItemStack[]{this.getHelmet(), this.getChestplate(), this.getLeggings(), this.getBoots()};
    }

    @Override
    public ItemStack getHelmet() {
        return this.getArbitraryStack(EquipmentTypes.HEADWEAR);
    }

    @Override
    public ItemStack getChestplate() {
        return this.getArbitraryStack(EquipmentTypes.CHESTPLATE);
    }

    @Override
    public ItemStack getLeggings() {
        return this.getArbitraryStack(EquipmentTypes.LEGGINGS);
    }

    @Override
    public ItemStack getBoots() {
        return this.getArbitraryStack(EquipmentTypes.BOOTS);
    }

    @Override
    public void setArmorContents(ItemStack[] items) {
        final int length = items.length;
        if (length > 0) {
            this.setHelmet(items[0]);
        }
        if (length > 1) {
            this.setChestplate(items[1]);
        }
        if (length > 2) {
            this.setLeggings(items[2]);
        }
        if (length > 3) {
            this.setBoots(items[3]);
        }
    }

    @Override
    public void setHelmet(ItemStack helmet) {
        // this code relies on the notion that Mojang won't implement hydra-people or something
        Iterables.get(this.getHandle().query(EquipmentTypes.HEADWEAR).<Slot>slots(), 0)
                .set(ItemStackConverter.of(helmet));
    }

    @Override
    public void setChestplate(ItemStack chestplate) {
        Iterables.get(this.getHandle().query(EquipmentTypes.CHESTPLATE).<Slot>slots(), 0)
                .set(ItemStackConverter.of(chestplate));
    }

    @Override
    public void setLeggings(ItemStack leggings) {
        Iterables.get(this.getHandle().query(EquipmentTypes.LEGGINGS).<Slot>slots(), 0)
                .set(ItemStackConverter.of(leggings));
    }

    @Override
    public void setBoots(ItemStack boots) {
        Iterables.get(this.getHandle().query(EquipmentTypes.BOOTS).<Slot>slots(), 0)
                .set(ItemStackConverter.of(boots));
    }

    @Override
    public ItemStack getItemInHand() {
        Hotbar hotbar = this.getHandle().getHotbar();
        Optional<Slot> slot = hotbar.getSlot(new SlotIndex(hotbar.getSelectedSlotIndex()));
        if (slot.isPresent()) {
            Optional<org.spongepowered.api.item.inventory.ItemStack> stack = slot.get().peek();
            if (stack.isPresent()) {
                return ItemStackConverter.of(stack.get());
            }
        }
        return null;
    }

    @Override
    public void setItemInHand(ItemStack stack) {
        Hotbar hotbar = this.getHandle().getHotbar();
        Optional<Slot> slot = hotbar.getSlot(new SlotIndex(hotbar.getSelectedSlotIndex()));
        if (slot.isPresent()) {
            slot.get().set(ItemStackConverter.of(stack));
        }
    }

    @Override
    public int getHeldItemSlot() {
        return this.getHandle().getHotbar().getSelectedSlotIndex();
    }

    @Override
    public void setHeldItemSlot(int slot) {
        Validate.isTrue(slot >= 0 || slot <= 8, "Invalid hotbar slot index");
        this.getHandle().getHotbar().setSelectedSlotIndex(slot);
    }

    @Override
    public int clear(int id, int data) {
        int removed = 0;
        for (Slot slot : this.getHandle().<Slot>slots()) {
            Optional<org.spongepowered.api.item.inventory.ItemStack> stackOptional = slot.peek();
            if (stackOptional.isPresent()) {
                org.spongepowered.api.item.inventory.ItemStack stack = stackOptional.get();
                if (id == -1 || stack.getItem() == MaterialConverter.asItem(Material.getMaterial(id))) {
                    //TODO: determine damage value
                    //if (data == -1 || durability == data) {
                        removed += stack.getQuantity();
                        slot.clear();
                    //}
                }
            }
        }
        return removed;
    }

    @Override
    public Player getHolder() {
        if (this.getHandle().getCarrier().isPresent()) {
            if (this.getHandle().getCarrier().get() instanceof org.spongepowered.api.entity.player.Player) {
                return PorePlayer.of((org.spongepowered.api.entity.player.Player)this.getHandle().getCarrier());
            }
        }
        return null;
    }
}
