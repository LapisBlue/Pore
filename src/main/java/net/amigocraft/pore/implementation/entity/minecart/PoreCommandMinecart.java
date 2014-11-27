package net.amigocraft.pore.implementation.entity.minecart;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.minecart.CommandMinecart;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.spongepowered.api.entity.vehicle.minecart.MinecartCommandBlock;

import java.util.Set;

public class PoreCommandMinecart extends PoreMinecart implements CommandMinecart {

	private static TypeConverter<MinecartCommandBlock, PoreCommandMinecart> converter;

	@SuppressWarnings("unchecked")
	public static TypeConverter<MinecartCommandBlock, PoreCommandMinecart> getCommandMinecartConverter() {
		if (converter == null) {
			converter = new TypeConverter<MinecartCommandBlock, PoreCommandMinecart>(){
				@Override
				protected PoreCommandMinecart convert(MinecartCommandBlock handle) {
					return new PoreCommandMinecart(handle);
				}
			};
		}
		return converter;
	}

	protected PoreCommandMinecart(MinecartCommandBlock handle) {
		super(handle);
	}

	@Override
	public MinecartCommandBlock getHandle() {
		return (MinecartCommandBlock)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreCommandMinecart of(MinecartCommandBlock handle) {
		return converter.apply(handle);
	}

	//TODO: bridge

	@Override
	public EntityType getType(){
		return EntityType.MINECART_COMMAND;
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
