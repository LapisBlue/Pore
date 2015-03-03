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
import blue.lapis.pore.util.PoreWrapper;

import com.google.common.base.Optional;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.spongepowered.api.item.inventory.Carrier;
import org.spongepowered.api.item.inventory.Slot;
import org.spongepowered.api.item.inventory.crafting.CraftingInventory;
import org.spongepowered.api.item.inventory.entity.HumanInventory;
import org.spongepowered.api.item.inventory.properties.SlotIndex;
import org.spongepowered.api.item.inventory.types.CarriedInventory;
import org.spongepowered.api.item.inventory.types.GridInventory;
import org.spongepowered.api.item.inventory.types.OrderedInventory;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class PoreInventory extends PoreWrapper<org.spongepowered.api.item.inventory.Inventory> implements Inventory {

    public static PoreInventory of(org.spongepowered.api.item.inventory.Inventory handle) {
        return WrapperConverter.of(PoreInventory.class, handle);
    }

    protected PoreInventory(org.spongepowered.api.item.inventory.Inventory handle) {
        super(handle);
    }

    @Override
    public int getSize() {
        return this.getHandle().size();
    }

    @Override
    public int getMaxStackSize() {
        return this.getHandle().getMaxStackSize();
    }

    @Override
    public void setMaxStackSize(int size) {
        this.getHandle().setMaxStackSize(size);
    }

    @Override
    public String getName() {
        return this.getHandle().getName().getTranslation().get();
    }

    @Override
    public ItemStack getItem(int index) {
        if (this.getHandle() instanceof OrderedInventory) {
            Optional<org.spongepowered.api.item.inventory.ItemStack> stack =
                    ((OrderedInventory)this.getHandle()).peek(new SlotIndex(index));
            if (stack.isPresent()) {
                return ItemStackConverter.of(stack.get());
            } else {
                return null;
            }
        } else {
            throw new UnsupportedOperationException("Not an OrderedInventory");
        }
    }

    @Override
    public void setItem(int index, ItemStack item) {
        if (this.getHandle() instanceof OrderedInventory) {
            Optional<org.spongepowered.api.item.inventory.Slot> slot =
                    ((OrderedInventory)this.getHandle()).getSlot(new SlotIndex(index));
            if (slot.isPresent()) {
                slot.get().set(ItemStackConverter.of(item));
            } else {
                throw new IllegalArgumentException("Invalid slot index");
            }
        } else {
            throw new UnsupportedOperationException("Not an OrderedInventory");
        }
    }

    @Override
    public HashMap<Integer, ItemStack> addItem(ItemStack... items) throws IllegalArgumentException {
        HashMap<Integer, ItemStack> remainder = new HashMap<Integer, ItemStack>();
        int i = 0;
        for (ItemStack stack : items) {
            if (stack == null) {
                throw new IllegalArgumentException("Cannot add null ItemStack");
            }
            org.spongepowered.api.item.inventory.ItemStack spongeIs = ItemStackConverter.of(stack);
            this.getHandle().offer(spongeIs);
            if (spongeIs.getQuantity() > 0) {
                remainder.put(i, ItemStackConverter.of(spongeIs));
            }
            ++i;
        }
        return remainder;
    }

    @Override
    public HashMap<Integer, ItemStack> removeItem(ItemStack... items) throws IllegalArgumentException {
        HashMap<Integer, ItemStack> notRemoved = new HashMap<Integer, ItemStack>();
        int i = 0;
        for (ItemStack stack : items) {
            Inventory query = this.getHandle().query(ItemStackConverter.of(stack));
            if (query.getSize() == 0) {
                notRemoved.put(i, stack);
                continue;
            }
            query.clear(); //TODO: verify this affects the parent as well
            ++i;
        }
        return notRemoved;
    }

    /**
     * Returns a HashMap mapping slot IDs to their respective {@link ItemStack}s
     * in this inventory.
     *
     * @return a HashMap mapping slot IDs to their respective {@link ItemStack}s
     *         in this inventory.
     */
    private HashMap<Integer, ItemStack> getOrderedContents() {
        HashMap<Integer, ItemStack> matches = new HashMap<Integer, ItemStack>();
        if (this.getHandle() instanceof OrderedInventory) {
            OrderedInventory ordered = (OrderedInventory)this.getHandle();
            for (int i = 0; i < ordered.size(); i++) {
                Optional<Slot> slot = ordered.getSlot(new SlotIndex(i));
                if (slot.isPresent()) {
                    Optional<org.spongepowered.api.item.inventory.ItemStack> stack = slot.get().peek();
                    if (stack.isPresent()) {
                        matches.put(i, ItemStackConverter.of(stack.get()));
                    }
                }
            }
        } else {
            int i = 0;
            for (Slot slot : this.getHandle().<Slot>slots()) {
                if (slot.peek().isPresent()) {
                    matches.put(i, ItemStackConverter.of(slot.peek().get()));
                }
                ++i;
            }
        }
        return matches;
    }

    @Override
    public ItemStack[] getContents() {
        ItemStack[] contents = new ItemStack[this.getHandle().size()];
        if (this.getHandle() instanceof OrderedInventory) {
            OrderedInventory ordered = (OrderedInventory)this.getHandle();
            for (int i = 0; i < this.getHandle().capacity(); i++) {
                Optional<Slot> slot = ordered.getSlot(new SlotIndex(i));
                if (slot.isPresent()) {
                    Optional<org.spongepowered.api.item.inventory.ItemStack> stack = slot.get().peek();
                    contents[i] = stack.isPresent() ? ItemStackConverter.of(stack.get()) : null;
                } else {
                    contents[i] = null;
                }
            }
        } else {
            int i = 0;
            for (Slot slot : this.getHandle().<Slot>slots()) {
                Optional<org.spongepowered.api.item.inventory.ItemStack> stack = slot.peek();
                contents[i] = stack.isPresent() ? ItemStackConverter.of(stack.get()) : null;
                ++i;
            }
        }
        return contents;
    }

    @Override
    public void setContents(ItemStack[] items) throws IllegalArgumentException {
        if (items.length > this.getSize()) {
            throw new IllegalArgumentException("Contents array is greater than inventory capacity");
        }
        if (this.getHandle() instanceof OrderedInventory) {
            OrderedInventory ordered = (OrderedInventory)this.getHandle();
            int i = 0;
            for (ItemStack stack : items) {
                Optional<Slot> slot = ordered.getSlot(new SlotIndex(i));
                if (slot.isPresent()) {
                    slot.get().set(ItemStackConverter.of(stack));
                }
                ++i;
            }
        } else {
            int i = 0;
            for (Slot slot : this.getHandle().<Slot>slots()) {
                slot.set(ItemStackConverter.of(items[i]));
                ++i;
            }
        }
    }

    @Override
    public boolean contains(int materialId) {
        return this.contains(Material.getMaterial(materialId));
    }

    @Override
    public boolean contains(Material material) throws IllegalArgumentException {
        return this.getHandle().contains(MaterialConverter.asItem(material));
    }

    @Override
    public boolean contains(ItemStack item) {
        return this.contains(item.getType());
    }

    @Override
    public boolean contains(int materialId, int amount) {
        return this.contains(Material.getMaterial(materialId), amount);
    }

    @Override
    public boolean contains(Material material, int amount) throws IllegalArgumentException {
        int count = 0;
        for (Slot slot : this.getHandle().<Slot>slots()) {
            if (slot.peek().isPresent() && slot.peek().get().getItem() == MaterialConverter.asItem(material)) {
                count += slot.peek().get().getQuantity();
                if (count > amount) {
                    return true;
                }
            }
        }
        return count > amount;
    }

    @Override
    public boolean contains(ItemStack item, int amount) {
        int matches = 0;
        for (Slot slot : this.getHandle().<Slot>slots()) {
            if (slot.peek().isPresent() && slot.peek().get().equals(ItemStackConverter.of(item))) {
                ++matches;
                if (matches > amount) {
                    return true;
                }
            }
        }
        return matches > amount;
    }

    @Override
    public boolean containsAtLeast(ItemStack item, int amount) {
        int count = 0;
        for (Slot slot : this.getHandle().<Slot>slots()) {
            if (slot.peek().isPresent() && slot.peek().get().equals(ItemStackConverter.of(item))) {
                count += item.getAmount();
                if (count > amount) {
                    return true;
                }
            }
        }
        return count > amount;
    }

    @Override
    public HashMap<Integer, ? extends ItemStack> all(int materialId) {
        return this.all(Material.getMaterial(materialId));
    }

    @Override
    public HashMap<Integer, ? extends ItemStack> all(Material material) throws IllegalArgumentException {
        HashMap<Integer, ItemStack> matches = new HashMap<Integer, ItemStack>();
        for (Map.Entry<Integer, ItemStack> e : this.getOrderedContents().entrySet()) {
            if (e.getValue().getType().equals(material)) {
                matches.put(e.getKey(), e.getValue());
            }
        }
        return matches;
    }

    @Override
    public HashMap<Integer, ? extends ItemStack> all(ItemStack item) {
        HashMap<Integer, ItemStack> matches = new HashMap<Integer, ItemStack>();
        for (Map.Entry<Integer, ItemStack> e : this.getOrderedContents().entrySet()) {
            if (e.getValue().equals(item)) {
                matches.put(e.getKey(), e.getValue());
            }
        }
        return matches;
    }

    @Override
    public int first(int materialId) {
        return this.first(Material.getMaterial(materialId));
    }

    @Override
    public int first(Material material) throws IllegalArgumentException {
        Set<Map.Entry<Integer, ItemStack>> entries = this.getOrderedContents().entrySet();
        for (Map.Entry<Integer, ItemStack> e : entries) {
            if (e.getValue().getType() == material) {
                return e.getKey();
            }
        }
        return -1;
    }

    @Override
    public int first(ItemStack item) {
        Set<Map.Entry<Integer, ItemStack>> entries = this.getOrderedContents().entrySet();
        for (Map.Entry<Integer, ItemStack> e : entries) {
            if (e.getValue().getType() == item.getType() && e.getValue().getAmount() == item.getAmount()) {
                return e.getKey();
            }
        }
        return -1;
    }

    @Override
    public int firstEmpty() {
        Set<Map.Entry<Integer, ItemStack>> entries = this.getOrderedContents().entrySet();
        for (Map.Entry<Integer, ItemStack> e : entries) {
            if (e.getValue() == null) {
                return e.getKey();
            }
        }
        return -1;
    }

    @Override
    public void remove(int materialId) {
        this.remove(Material.getMaterial(materialId));
    }

    @Override
    public void remove(Material material) throws IllegalArgumentException {
        for (Slot slot : this.getHandle().<Slot>slots()) {
            Optional<org.spongepowered.api.item.inventory.ItemStack> stack = slot.peek();
            if (stack.isPresent()) {
                if (stack.get().getItem() == MaterialConverter.asItem(material)) {
                    slot.clear();
                    return;
                }
            }
        }
    }

    @Override
    public void remove(ItemStack item) {
        for (Slot slot : this.getHandle().<Slot>slots()) {
            Optional<org.spongepowered.api.item.inventory.ItemStack> stack = slot.peek();
            if (stack.isPresent()) {
                if (stack.get().getItem() == MaterialConverter.asItem(item.getType())
                        && stack.get().getQuantity() == item.getAmount()) {
                    slot.clear();
                    return;
                }
            }
        }
    }

    @Override
    public void clear(int index) {
        if (this.getHandle() instanceof OrderedInventory) {
            Optional<Slot> slot = ((OrderedInventory)this.getHandle()).getSlot(new SlotIndex(index));
            if (slot.isPresent()) {
                slot.get().clear();
            }
        } else {
            throw new UnsupportedOperationException("Not an OrderedInventory");
        }
    }

    @Override
    public void clear() {
        this.getHandle().clear();
    }

    @Override
    public List<HumanEntity> getViewers() {
        // we're waiting on SpongeAPI for this one
        throw new NotImplementedException();
    }

    @Override
    public String getTitle() {
        return this.getName();
    }

    @Override
    public InventoryType getType() {
        //TODO: partial implementation, needs work
        // I don't think we can just check the carrier because inventories can be virtual regardless of type

        // for chest
        // dispenser
        // dropper
        // furnace
        if (this.getHandle() instanceof CraftingInventory) {
            GridInventory craftingGrid = ((CraftingInventory)this.getHandle()).getCraftingGrid();
            if (craftingGrid.getRows() == 2) {
                return InventoryType.CRAFTING;
            }
            else {
                return InventoryType.WORKBENCH;
            }
        }
        // enchanting
        // brewing
        if (this.getHandle() instanceof HumanInventory) {
            return InventoryType.PLAYER;
        }
        // creative
        // villager
        // ender chest
        // anvil
        // beacon
        return null;
    }

    @Override
    public InventoryHolder getHolder() {
        if (this.getHandle() instanceof CarriedInventory) {
            Optional<?> carrier = ((CarriedInventory)this.getHandle()).getCarrier();
            if (carrier.isPresent()) {
                return PoreInventoryHolder.of((Carrier)carrier.get());
            }
        }
        return null;
    }

     // I've worked with Bukkit for more than two years and this method is by far
     // one of the worst ideas I've seen in it.
    @Override
    public ListIterator<ItemStack> iterator() {
        return this.iterator(0);
    }

    @Override
    public ListIterator<ItemStack> iterator(int index) {
        return new ItemStackIterator(this, index);
    }

    /**
     * Convenience method for getting the first ItemStack in an inventory that
     * matches the given criterion.
     * @param bound The criterion to pass to
     * {@link org.spongepowered.api.item.inventory.Inventory#query(Object...)}.
     * @return The first match found in this inventory, or <code>null</code> if
     *         one cannot be discovered.
     */
    protected ItemStack getArbitraryStack(Object bound) {
        org.spongepowered.api.item.inventory.Inventory query = this.getHandle().query(bound);
        if (query.capacity() >= 1) {
            Optional<org.spongepowered.api.item.inventory.ItemStack> stack = query.peek();
            if (stack.isPresent()) {
                return ItemStackConverter.of(stack.get());
            }
        }
        return null;
    }
}
