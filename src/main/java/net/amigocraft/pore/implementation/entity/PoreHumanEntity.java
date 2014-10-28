package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.Converter;
import net.amigocraft.pore.util.ParentConverter;
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

public class PoreHumanEntity extends PoreLivingEntity implements HumanEntity {
	private static Converter<org.spongepowered.api.entity.HumanEntity, PoreHumanEntity> converter;

	static Converter<org.spongepowered.api.entity.HumanEntity, PoreHumanEntity> getHumanEntityConverter() {
		if (converter == null) {
			converter = new ParentConverter<org.spongepowered.api.entity.HumanEntity, PoreHumanEntity>(
					Player.class, PorePlayer.getPlayerConverter()
			) {
				@Override
				protected PoreHumanEntity convert(org.spongepowered.api.entity.HumanEntity handle) {
					return new PoreHumanEntity(handle);
				}
			};
		}

		return converter;
	}

	//TODO: bridge

	protected PoreHumanEntity(org.spongepowered.api.entity.HumanEntity handle) {
		super(handle);
	}

	@Override
	public org.spongepowered.api.entity.HumanEntity getHandle() {
		return (org.spongepowered.api.entity.HumanEntity) super.getHandle();
	}

	public static PoreHumanEntity of(org.spongepowered.api.entity.HumanEntity handle) {
		return getHumanEntityConverter().apply(handle);
	}

	@Override
	public String getName() {
		if (getHandle() instanceof Player)
			return ((Player)getHandle()).getName();
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
		throw new NotImplementedException();
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
		throw new NotImplementedException();
	}

	@Override
	public int getSleepTicks() {
		throw new NotImplementedException();
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
		throw new NotImplementedException();
	}

	@Override
	public int getExpToLevel() {
		throw new NotImplementedException();
	}

	@Override
	public boolean isPermissionSet(String name) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isPermissionSet(Permission perm) {
		throw new NotImplementedException();
	}

	@Override
	public boolean hasPermission(String name) {
		throw new NotImplementedException();
	}

	@Override
	public boolean hasPermission(Permission perm) {
		throw new NotImplementedException();
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
		throw new NotImplementedException();
	}

	@Override
	public void setOp(boolean value) {
		throw new NotImplementedException();
	}
}
