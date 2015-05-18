/*
 * Pore
 * Copyright (c) 2014-2015, Lapis <https://github.com/LapisBlue>
 *
 * The MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package blue.lapis.pore.impl.entity.minecart;

import blue.lapis.pore.converter.wrapper.WrapperConverter;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.minecart.CommandMinecart;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.spongepowered.api.data.manipulator.CommandData;
import org.spongepowered.api.entity.vehicle.minecart.MinecartCommandBlock;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;

import java.util.Set;

public class PoreCommandMinecart extends PoreMinecart implements CommandMinecart {

    public static PoreCommandMinecart of(MinecartCommandBlock handle) {
        return WrapperConverter.of(PoreCommandMinecart.class, handle);
    }

    protected PoreCommandMinecart(MinecartCommandBlock handle) {
        super(handle);
    }

    @Override
    public MinecartCommandBlock getHandle() {
        return (MinecartCommandBlock) super.getHandle();
    }

    @Override
    public EntityType getType() {
        return EntityType.MINECART_COMMAND;
    }

    @Override
    public String getCommand() {
        return get(CommandData.class).getStoredCommand();
    }

    @Override
    public void setCommand(String command) {
        getOrCreate(CommandData.class).setStoredCommand(command);
    }

    @Override
    public String getName() {
        return getHandle().getName();
    }

    @Override
    public void setName(String name) {
       // getHandle().setCommandName(name); TODO ??
        throw new NotImplementedException("TODO");
    }

    @Override
    @SuppressWarnings("deprecation")
    public void sendMessage(String message) {
        getHandle().sendMessage(Texts.fromLegacy(message));
    }

    @Override
    @SuppressWarnings("deprecation")
    public void sendMessage(String[] messages) {
        Text[] texts = new Text[messages.length];
        for (int i = 0; i < messages.length; i++) {
            texts[i] = Texts.fromLegacy(messages[i]);
        }
        this.getHandle().sendMessage(texts);
    }

    @Override
    public boolean isPermissionSet(String name) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean isPermissionSet(Permission perm) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean hasPermission(String name) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean hasPermission(Permission perm) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void removeAttachment(PermissionAttachment attachment) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void recalculatePermissions() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean isOp() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setOp(boolean value) {
        throw new NotImplementedException("TODO");
    }


}
