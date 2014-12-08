/*
 * Pore
 * Copyright (c) 2014, Maxim Roncacé <http://bitbucket.org/mproncace>
 * Copyright (c) 2014, Lapis <https://github.com/LapisBlue>
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
package net.amigocraft.pore.impl.permissions;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.permissions.ServerOperator;
import org.bukkit.plugin.Plugin;

import java.util.Set;

// TODO: Bridge

// TODO: Bridge

public class PorePermissibleBase implements Permissible {

    public PorePermissibleBase(ServerOperator opable) {
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

}
