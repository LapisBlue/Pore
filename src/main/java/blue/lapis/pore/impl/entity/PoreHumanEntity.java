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
package blue.lapis.pore.impl.entity;

import static org.spongepowered.api.data.manipulator.catalog.CatalogEntityData.EXPERIENCE_HOLDER_DATA;

import blue.lapis.pore.converter.type.material.ItemStackConverter;
import blue.lapis.pore.converter.vector.LocationConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;
import blue.lapis.pore.impl.inventory.PoreInventory;
import blue.lapis.pore.impl.inventory.PoreInventoryView;
import blue.lapis.pore.impl.inventory.PorePlayerInventory;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.GameMode;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.entity.living.Human;
import org.spongepowered.api.entity.living.Humanoid;
import org.spongepowered.api.item.inventory.Carrier;
import org.spongepowered.api.item.inventory.entity.HumanInventory;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.api.util.Tristate;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.Set;

public class PoreHumanEntity extends PoreLivingEntity implements HumanEntity {

    public static PoreHumanEntity of(Humanoid handle) {
        return WrapperConverter.of(PoreHumanEntity.class, handle);
    }

    protected PoreHumanEntity(Humanoid handle) {
        super(handle);
    }

    @Override
    public Humanoid getHandle() {
        return (Humanoid) super.getHandle();
    }

    @Override
    public String getName() {
        return getHandle().getName();
    }

    @Override
    public PlayerInventory getInventory() {
        return PorePlayerInventory.of((HumanInventory) this.getHandle().getInventory());
    }

    @Override
    public Inventory getEnderChest() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean setWindowProperty(InventoryView.Property prop, int value) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public InventoryView getOpenInventory() {
        return PoreInventoryView.builder()
                .setPlayer(this)
                .setTopInventory(this.getHandle().getOpenInventory().orElse(null))
                .setBottomInventory(this.getHandle().getInventory())
                .build();
    }

    @Override
    public InventoryView openInventory(Inventory inventory) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void openInventory(InventoryView inventory) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public InventoryView openWorkbench(org.bukkit.Location location, boolean force) {
        Location<?> block = LocationConverter.of(location);
        if (force || block.getBlockType() == BlockTypes.CRAFTING_TABLE) {
            return openBlockInventory(block, force);
        }
        return null;
    }

    @Override
    public InventoryView openEnchanting(org.bukkit.Location location, boolean force) {
        Location<?> block = LocationConverter.of(location);
        if (force || block.getBlockType() == BlockTypes.ENCHANTING_TABLE) {
            return openBlockInventory(block, force);
        }
        return null;
    }

    private InventoryView openBlockInventory(Location<?> location, boolean force) {
        if (location.getTileEntity().isPresent() && location.getTileEntity().get() instanceof Carrier) {
            return this.openInventory(PoreInventory.of(
                    ((Carrier) location.getTileEntity().get()).getInventory()
            ));
        } else {
            throw new UnsupportedOperationException("Block is not an inventory carrier");
        }
    }

    @Override
    public void closeInventory() {
        this.getHandle().closeInventory();
    }

    @Override
    public ItemStack getItemInHand() {
        return ItemStackConverter.of(this.getHandle().getItemInHand().orElse(null));
    }

    @Override
    public void setItemInHand(ItemStack item) {
        this.getHandle().setItemInHand(ItemStackConverter.of(item));
    }

    @Override
    public ItemStack getItemOnCursor() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setItemOnCursor(ItemStack item) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean isSleeping() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public int getSleepTicks() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public GameMode getGameMode() {
        throw new UnsupportedOperationException("Cannot get gamemode of non-player human");
    }

    @Override
    public void setGameMode(GameMode mode) {
        throw new UnsupportedOperationException("Cannot get gamemode of non-player human");
    }

    @Override
    public boolean isBlocking() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public int getExpToLevel() {
        return getHandle().get(EXPERIENCE_HOLDER_DATA).get().getExperienceBetweenLevels().get()
                - getHandle().get(EXPERIENCE_HOLDER_DATA).get().experienceSinceLevel().get();
    }

    @Override
    public boolean isPermissionSet(String name) {
        if (getHandle() instanceof Subject) {
            Subject subject = (Subject) getHandle();
            return subject.getPermissionValue(subject.getActiveContexts(), name) != Tristate.UNDEFINED;
        }

        return false;
    }

    @Override
    public boolean isPermissionSet(Permission perm) {
        return isPermissionSet(perm.getName());
    }

    @Override
    public boolean hasPermission(String name) {
        return getHandle() instanceof Subject && ((Subject) getHandle()).hasPermission(name);
    }

    @Override
    public boolean hasPermission(Permission perm) {
        return hasPermission(perm.getName());
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
        return hasPermission("pore.op");
    }

    @Override
    public void setOp(boolean value) {
        throw new NotImplementedException("TODO");
    }
}
