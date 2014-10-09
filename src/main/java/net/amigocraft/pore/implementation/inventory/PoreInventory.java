package net.amigocraft.pore.implementation.inventory;

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