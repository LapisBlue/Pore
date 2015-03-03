package blue.lapis.pore.impl.inventory;

import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.ListIterator;

/**
 * Literally just a reimplementation of {@link ListIterator}, except it's also
 * responsible for modifying an accompanying inventory.
 */
public class ItemStackIterator implements ListIterator<ItemStack> {

    private final PoreInventory handle;
    private final ListIterator<ItemStack> backing;

    ItemStackIterator(PoreInventory inventory, int index) {
        this.handle = inventory;
        this.backing = Arrays.asList(inventory.getContents()).listIterator(index);
    }

    @Override
    public boolean hasNext() {
        return this.backing.hasNext();
    }

    @Override
    public ItemStack next() {
        return this.backing.next();
    }

    @Override
    public boolean hasPrevious() {
        return this.backing.hasPrevious();
    }

    @Override
    public ItemStack previous() {
        return this.backing.previous();
    }

    @Override
    public int nextIndex() {
        return this.backing.nextIndex();
    }

    @Override
    public int previousIndex() {
        return this.backing.previousIndex();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Inventory resize not permitted");
    }

    @Override
    public void set(ItemStack itemStack) {
        this.backing.set(itemStack);
        //TODO: remove the item from the handle. I don't think anyone will care whatsoever if that's deferred a bit.
    }

    @Override
    public void add(ItemStack itemStack) {
        throw new UnsupportedOperationException("Inventory resize not permitted");
    }
}
