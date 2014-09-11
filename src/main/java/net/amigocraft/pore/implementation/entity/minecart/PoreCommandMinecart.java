package net.amigocraft.pore.implementation.entity.minecart;

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
		return null;
	}

	@Override
	public void setCommand(String command) {

	}

	@Override
	public void setName(String name) {

	}

	@Override
	public void sendMessage(String message) {

	}

	@Override
	public void sendMessage(String[] messages) {

	}

	@Override
	public String getName() {
		return null;
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

	@Override
	public boolean isOp() {
		return false;
	}

	@Override
	public void setOp(boolean value) {

	}


}
