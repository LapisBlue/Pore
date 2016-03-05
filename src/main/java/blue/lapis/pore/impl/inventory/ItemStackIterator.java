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

package blue.lapis.pore.impl.inventory;

import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.ListIterator;

/**
 * Literally just a reimplementation of {@link ListIterator}, except it's also
 * responsible for modifying an accompanying inventory.
 */
class ItemStackIterator implements ListIterator<ItemStack> {

    private final ListIterator<ItemStack> backing;

    ItemStackIterator(PoreInventory inventory, int index) {
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
