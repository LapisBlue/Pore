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
package net.amigocraft.pore.impl.inventory;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

// TODO: bridge

// TODO: bridge

public class PoreInventory implements Inventory {

    @Override
    public int getSize() {
        throw new NotImplementedException();
    }

    @Override
    public int getMaxStackSize() {
        throw new NotImplementedException();
    }

    @Override
    public void setMaxStackSize(int size) {
        throw new NotImplementedException();
    }

    @Override
    public String getName() {
        throw new NotImplementedException();
    }

    @Override
    public ItemStack getItem(int index) {
        throw new NotImplementedException();
    }

    @Override
    public void setItem(int index, ItemStack item) {
        throw new NotImplementedException();
    }

    @Override
    public HashMap<Integer, ItemStack> addItem(ItemStack... items) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public HashMap<Integer, ItemStack> removeItem(ItemStack... items) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public ItemStack[] getContents() {
        throw new NotImplementedException();
    }

    @Override
    public void setContents(ItemStack[] items) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public boolean contains(int materialId) {
        throw new NotImplementedException();
    }

    @Override
    public boolean contains(Material material) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public boolean contains(ItemStack item) {
        throw new NotImplementedException();
    }

    @Override
    public boolean contains(int materialId, int amount) {
        throw new NotImplementedException();
    }

    @Override
    public boolean contains(Material material, int amount) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public boolean contains(ItemStack item, int amount) {
        throw new NotImplementedException();
    }

    @Override
    public boolean containsAtLeast(ItemStack item, int amount) {
        throw new NotImplementedException();
    }

    @Override
    public HashMap<Integer, ? extends ItemStack> all(int materialId) {
        throw new NotImplementedException();
    }

    @Override
    public HashMap<Integer, ? extends ItemStack> all(Material material) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public HashMap<Integer, ? extends ItemStack> all(ItemStack item) {
        throw new NotImplementedException();
    }

    @Override
    public int first(int materialId) {
        throw new NotImplementedException();
    }

    @Override
    public int first(Material material) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public int first(ItemStack item) {
        throw new NotImplementedException();
    }

    @Override
    public int firstEmpty() {
        throw new NotImplementedException();
    }

    @Override
    public void remove(int materialId) {
        throw new NotImplementedException();
    }

    @Override
    public void remove(Material material) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void remove(ItemStack item) {
        throw new NotImplementedException();
    }

    @Override
    public void clear(int index) {
        throw new NotImplementedException();
    }

    @Override
    public void clear() {
        throw new NotImplementedException();
    }

    @Override
    public List<HumanEntity> getViewers() {
        throw new NotImplementedException();
    }

    @Override
    public String getTitle() {
        throw new NotImplementedException();
    }

    @Override
    public InventoryType getType() {
        throw new NotImplementedException();
    }

    @Override
    public InventoryHolder getHolder() {
        throw new NotImplementedException();
    }

    @Override
    public ListIterator<ItemStack> iterator() {
        throw new NotImplementedException();
    }

    @Override
    public ListIterator<ItemStack> iterator(int index) {
        throw new NotImplementedException();
    }
}