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
package net.amigocraft.pore.impl.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.spongepowered.api.entity.living.Human;
import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.service.permission.Subject;

import java.util.Set;

public class PoreHumanEntity extends PoreLivingEntity implements HumanEntity {

    private static TypeConverter<Human, PoreHumanEntity> converter;

    static TypeConverter<Human, PoreHumanEntity> getHumanEntityConverter() {
        if (converter == null) {
            converter = new TypeConverter<Human, PoreHumanEntity>(
                    Player.class, PorePlayer.getPlayerConverter()
            ) {
                @Override
                protected PoreHumanEntity convert(Human handle) {
                    return new PoreHumanEntity(handle);
                }
            };
        }

        return converter;
    }

    protected PoreHumanEntity(Human handle) {
        super(handle);
    }

    @Override
    public Human getHandle() {
        return (Human) super.getHandle();
    }

    /**
     * Returns a Pore wrapper for the given handle.
     * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
     *
     * @param handle The Sponge object to wrap.
     * @return A Pore wrapper for the given Sponge object.
     */
    public static PoreHumanEntity of(Human handle) {
        return getHumanEntityConverter().apply(handle);
    }

    @Override
    public String getName() {
        if (getHandle() instanceof Player)
            return ((Player) getHandle()).getName();
        throw new NotImplementedException();
    }

    @Override
    public PlayerInventory getInventory() {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public Inventory getEnderChest() {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public boolean setWindowProperty(InventoryView.Property prop, int value) {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public InventoryView getOpenInventory() {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public InventoryView openInventory(Inventory inventory) {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public InventoryView openWorkbench(Location location, boolean force) {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public InventoryView openEnchanting(Location location, boolean force) {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public void openInventory(InventoryView inventory) {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public void closeInventory() {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public ItemStack getItemInHand() {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public void setItemInHand(ItemStack item) {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public ItemStack getItemOnCursor() {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public void setItemOnCursor(ItemStack item) {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public boolean isSleeping() {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public int getSleepTicks() {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public GameMode getGameMode() {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public void setGameMode(GameMode mode) {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public boolean isBlocking() {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public int getExpToLevel() {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public boolean isPermissionSet(String name) {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public boolean isPermissionSet(Permission perm) {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public boolean hasPermission(String name) {
        if (this instanceof Subject) {
            return ((Subject) this).isPermitted(name);
        }
        throw new NotImplementedException();
    }

    @Override
    public boolean hasPermission(Permission perm) {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin) {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public void removeAttachment(PermissionAttachment attachment) {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public void recalculatePermissions() {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public boolean isOp() {
        throw new NotImplementedException(); //TODO
    }

    @Override
    public void setOp(boolean value) {
        throw new NotImplementedException(); //TODO
    }
}
