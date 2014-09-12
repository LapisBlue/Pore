package net.amigocraft.pore.implementation.entity.minecart;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.minecart.CommandMinecart;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

import java.util.Set;

public class PoreCommandMinecart extends PoreMinecart implements CommandMinecart {

	// TODO: Bridge

	public PoreCommandMinecart(org.spongepowered.api.entity.Entity handle) { //TODO: accept most specfific type
		super(handle);
	}

	@Override
	public String getCommand() {
		throw new NotImplementedException();
	}

	@Override
	public void setCommand(String command) {
		throw new NotImplementedException();
	}

	@Override
	public void setName(String name) {
		throw new NotImplementedException();
	}

	@Override
	public void sendMessage(String message) {
		throw new NotImplementedException();
	}

	@Override
	public void sendMessage(String[] messages) {
		throw new NotImplementedException();
	}

	@Override
	public String getName() {
		throw new NotImplementedException();
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
