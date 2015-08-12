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

import blue.lapis.pore.Pore;
import blue.lapis.pore.util.PoreWrapper;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.api.util.Tristate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PorePermissible extends PoreWrapper<Subject> implements Permissible {

    private List<PermissionAttachment> attachments = new ArrayList<PermissionAttachment>();
    private List<String> attachedNodes = new ArrayList<String>();

    protected PorePermissible(Subject handle) {
        super(handle);
    }

    @Override
    public boolean isOp() {
        // I'm hesitant to throw an UnsupportedOperationException
        // because that might break a lot of perms plugins
        return false;
    }

    @Override
    public void setOp(boolean value) {
        /*
         * In the hundreds of plugins I reviewed while BukkitDev staff, I
         * literally only saw this method used by force-op plugins. I know
         * because the first thing I would do when reviewing the source was
         * CTRL+F -> setOp. Any matches and it was almost sure to be rejected.
         * That's why I don't think an UOE will be too problemeatic here.
         * - caseif
         */
        throw new UnsupportedOperationException("Sponge does not support server operators");
    }

    @Override
    public boolean isPermissionSet(String name) {
        return getHandle().getPermissionValue(getHandle().getActiveContexts(), name) != Tristate.UNDEFINED;
    }

    @Override
    public boolean isPermissionSet(Permission perm) {
        return isPermissionSet(perm.getName());
    }

    @Override
    public boolean hasPermission(String name) {
        return getHandle().hasPermission(name);
    }

    @Override
    public boolean hasPermission(Permission perm) {
        return hasPermission(perm.getName());
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
        return addAttachment(plugin, name, value, -1);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin) {
        return addAttachment(plugin, -1);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, final String name, boolean value, int ticks) {
        final PermissionAttachment attachment = addAttachment(plugin, ticks);
        return attachment;
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
        final PermissionAttachment attachment = new PermissionAttachment(plugin, this);
        attachments.add(attachment);
        if (ticks != -1) {
            Pore.getGame().getScheduler().createTaskBuilder().delay(ticks).execute(new Runnable() {
                public void run() {
                    removeAttachment(attachment);
                }
            }).submit(Pore.getPlugin());
        }
        recalculatePermissions();
        return attachment;
    }

    @Override
    public void removeAttachment(PermissionAttachment attachment) {
        attachments.remove(attachment);
        recalculatePermissions();
    }

    @Override
    public void recalculatePermissions() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        throw new NotImplementedException("TODO");
    }

}
