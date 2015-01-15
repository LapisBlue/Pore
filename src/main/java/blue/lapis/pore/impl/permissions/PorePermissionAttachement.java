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
package blue.lapis.pore.impl.permissions;

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
