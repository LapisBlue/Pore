package net.amigocraft.pore.implementation.permissions;

import net.amigocraft.pore.util.converter.TypeConverter;
import net.amigocraft.pore.util.PoreWrapper;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.spongepowered.api.service.permission.Subject;

import java.util.Set;

//TODO: Bridge

//TODO: Bridge

public class PorePermissible extends PoreWrapper<Subject> implements Permissible {

	private static TypeConverter<Subject, PorePermissible> converter;

	static TypeConverter<Subject, PorePermissible> getConverter() {
		if (converter == null) {
			converter = new TypeConverter<Subject, PorePermissible>() {
				@Override
				protected PorePermissible convert(Subject handle) {
					return new PorePermissible(handle);
				}
			};
		}

		return converter;
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PorePermissible of(Subject handle) {
		return getConverter().apply(handle);
	}

	protected PorePermissible(Subject handle) {
		super(handle);
	}

	@Override
	public boolean isOp() {
		throw new NotImplementedException();
	}

	@Override
	public void setOp(boolean value) {
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
		return getHandle().isPermitted(name);
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

}
