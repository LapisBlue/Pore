package net.amigocraft.pore.implementation.permissions;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionRemovedExecutor;
import org.bukkit.plugin.Plugin;

import java.util.Map;

//TODO: Bridge
public class PorePermissionAttachement {

	public PorePermissionAttachement(Plugin plugin, Permissible Permissible) {
	}

	public Plugin getPlugin() {
		throw new NotImplementedException();
	}

	public void setRemovalCallback(PermissionRemovedExecutor ex) {
		throw new NotImplementedException();
	}

	public PermissionRemovedExecutor getRemovalCallback() {
		throw new NotImplementedException();
	}

	public Permissible getPermissible() {
		throw new NotImplementedException();
	}

	public Map<String, Boolean> getPermissions() {
		throw new NotImplementedException();
	}

	public void setPermission(String name, boolean value) {
		throw new NotImplementedException();
	}

	public void setPermission(Permission perm, boolean value) {
		throw new NotImplementedException();
	}

	public void unsetPermission(String name) {
		throw new NotImplementedException();
	}

	public void unsetPermission(Permission perm) {
		throw new NotImplementedException();
	}

	public boolean remove() {
		throw new NotImplementedException();
	}


}
