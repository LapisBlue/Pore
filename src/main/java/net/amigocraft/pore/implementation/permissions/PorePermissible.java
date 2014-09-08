package net.amigocraft.pore.implementation.permissions;

import java.util.Set;

import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

//TODO: Bridge

public class PorePermissible implements Permissible {

	@Override
	public boolean isOp() {
		return false; // TODO: Bridge
	}

	@Override
	public void setOp(boolean value) {
		// TODO: Bridge
	}

	@Override
	public boolean isPermissionSet(String name) {
		return false; // TODO: Bridge
	}

	@Override
	public boolean isPermissionSet(Permission perm) {
		return false; // TODO: Bridge
	}

	@Override
	public boolean hasPermission(String name) {
		return false; // TODO: Bridge
	}

	@Override
	public boolean hasPermission(Permission perm) {
		return false; // TODO: Bridge
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
		return null; // TODO: Bridge
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin) {
		return null; // TODO: Bridge
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
		return null; // TODO: Bridge
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
		return null; // TODO: Bridge
	}

	@Override
	public void removeAttachment(PermissionAttachment attachment) {
		// TODO: Bridge
	}

	@Override
	public void recalculatePermissions() {
		// TODO: Bridge
	}

	@Override
	public Set<PermissionAttachmentInfo> getEffectivePermissions() {
		return null; // TODO: Bridge
	}

}
