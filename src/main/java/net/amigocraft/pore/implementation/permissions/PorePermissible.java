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
		return false;
	}

	@Override
	public void setOp(boolean value) {

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
		return null;
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin) {
		return null;
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
		return null;
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
		return null;
	}

	@Override
	public void removeAttachment(PermissionAttachment attachment) {

	}

	@Override
	public void recalculatePermissions() {

	}

	@Override
	public Set<PermissionAttachmentInfo> getEffectivePermissions() {
		return null;
	}

}
