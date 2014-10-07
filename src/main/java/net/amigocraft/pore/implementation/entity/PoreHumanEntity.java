package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.spongepowered.api.entity.Player;

import java.util.Set;

//TODO: bridge

//TODO: bridge

public class PoreHumanEntity extends PoreLivingEntity implements HumanEntity {

	public PoreHumanEntity(org.spongepowered.api.entity.HumanEntity handle) {
		super(handle);
	}

	@Override
	public String getName() {
		if (handle instanceof Player)
			return ((Player)handle).getName();
		throw new NotImplementedException();
	}

	@Override
	public PlayerInventory getInventory() {
		throw new NotImplementedException();
	}

	@Override
	public Inventory getEnderChest() {
		throw new NotImplementedException();
	}

	@Override
	public boolean setWindowProperty(InventoryView.Property prop, int value) {
		return false;
	}

	@Override
	public InventoryView getOpenInventory() {
		throw new NotImplementedException();
	}

	@Override
	public InventoryView openInventory(Inventory inventory) {
		throw new NotImplementedException();
	}

	@Override
	public InventoryView openWorkbench(Location location, boolean force) {
		throw new NotImplementedException();
	}

	@Override
	public InventoryView openEnchanting(Location location, boolean force) {
		throw new NotImplementedException();
	}

	@Override
	public void openInventory(InventoryView inventory) {
		throw new NotImplementedException();
	}

	@Override
	public void closeInventory() {
		throw new NotImplementedException();
	}

	@Override
	public ItemStack getItemInHand() {
		throw new NotImplementedException();
	}

	@Override
	public void setItemInHand(ItemStack item) {
		throw new NotImplementedException();
	}

	@Override
	public ItemStack getItemOnCursor() {
		throw new NotImplementedException();
	}

	@Override
	public void setItemOnCursor(ItemStack item) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isSleeping() {
		return false;
	}

	@Override
	public int getSleepTicks() {
		return 0;
	}

	@Override
	public GameMode getGameMode() {
		throw new NotImplementedException();
	}

	@Override
	public void setGameMode(GameMode mode) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isBlocking() {
		return false;
	}

	@Override
	public int getExpToLevel() {
		return 0;
	}

	@Override
	public boolean isPermissionSet(String name) {
		return false;
	}

	@Override
	public boolean isPermissionSet(Permission perm) {
		return false;
	}

	@Override
	public boolean hasPermission(String name) {
		return false;
	}

	@Override
	public boolean hasPermission(Permission perm) {
		return false;
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
		throw new NotImplementedException();
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin) {
		throw new NotImplementedException();
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
		throw new NotImplementedException();
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
		throw new NotImplementedException();
	}

	@Override
	public void removeAttachment(PermissionAttachment attachment) {
		throw new NotImplementedException();
	}

	@Override
	public void recalculatePermissions() {
		throw new NotImplementedException();
	}

	@Override
	public Set<PermissionAttachmentInfo> getEffectivePermissions() {
		throw new NotImplementedException();
	}

	@Override
	public boolean isOp() {
		return false;
	}

	@Override
	public void setOp(boolean value) {
		throw new NotImplementedException();
	}
}
