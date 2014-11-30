package net.amigocraft.pore.impl.command;

import net.amigocraft.pore.impl.permissions.PorePermissibleBase;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.spongepowered.api.service.permission.Subject;

import java.util.Set;

// TODO: Bridge

// TODO: Bridge

public class PoreServerCommandSender extends PoreCommandSender implements CommandSender {

	private PorePermissibleBase perm = new PorePermissibleBase(this);

	protected PoreServerCommandSender(Subject handle) {
		super(handle);
	}

	public boolean isPermissionSet(String name) {
		return perm.isPermissionSet(name);
	}

	public boolean isPermissionSet(Permission perm) {
		return this.perm.isPermissionSet(perm);
	}

	public boolean hasPermission(String name) {
		return perm.hasPermission(name);
	}

	public boolean hasPermission(Permission perm) {
		return this.perm.hasPermission(perm);
	}

	public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
		return perm.addAttachment(plugin, name, value);
	}

	public PermissionAttachment addAttachment(Plugin plugin) {
		return perm.addAttachment(plugin);
	}

	public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
		return perm.addAttachment(plugin, name, value, ticks);
	}

	public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
		return perm.addAttachment(plugin, ticks);
	}

	public void removeAttachment(PermissionAttachment attachment) {
		perm.removeAttachment(attachment);
	}

	public void recalculatePermissions() {
		perm.recalculatePermissions();
	}

	public Set<PermissionAttachmentInfo> getEffectivePermissions() {
		return perm.getEffectivePermissions();
	}

	public boolean isPlayer() {
		throw new NotImplementedException();
	}

	public Server getServer() {
		throw new NotImplementedException();
	}

}
