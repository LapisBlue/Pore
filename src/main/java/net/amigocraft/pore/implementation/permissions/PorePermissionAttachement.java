package net.amigocraft.pore.implementation.permissions;

import java.util.Map;

import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionRemovedExecutor;
import org.bukkit.plugin.Plugin;

//TODO: Bridge

public class PorePermissionAttachement {

	public PorePermissionAttachement(Plugin plugin, Permissible Permissible) {
	}

	public Plugin getPlugin() {
		return null;
	}

	public void setRemovalCallback(PermissionRemovedExecutor ex) {

	}

	public PermissionRemovedExecutor getRemovalCallback() {
		return null;
	}

	public Permissible getPermissible() {
		return null;
	}

	public Map<String, Boolean> getPermissions() {
		return null;
	}

	public void setPermission(String name, boolean value) {

	}

	public void setPermission(Permission perm, boolean value) {

	}

	public void unsetPermission(String name) {

	}

	public void unsetPermission(Permission perm) {

	}

	public boolean remove() {
		return false;
	}


}
