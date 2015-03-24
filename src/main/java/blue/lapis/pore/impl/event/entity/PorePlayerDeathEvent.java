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
package blue.lapis.pore.impl.event.entity;

import static com.google.common.base.Preconditions.checkNotNull;

import blue.lapis.pore.converter.type.EntityConverter;
import blue.lapis.pore.impl.entity.PorePlayer;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class PorePlayerDeathEvent extends PlayerDeathEvent {

    private final org.spongepowered.api.event.entity.player.PlayerDeathEvent handle;

    public PorePlayerDeathEvent(org.spongepowered.api.event.entity.player.PlayerDeathEvent handle) {
        super(null, null, -1, null);
        this.handle = checkNotNull(handle, "handle");
    }

    public org.spongepowered.api.event.entity.player.PlayerDeathEvent getHandle() {
        return this.handle;
    }

    @Override
    public Player getEntity() {
        return PorePlayer.of(this.getHandle().getEntity());
    }

    @Override
    public EntityType getEntityType() {
        return EntityConverter.of(this.getHandle().getEntity().getType());
    }

    @Override
    public String getDeathMessage() {
        throw new NotImplementedException();
    }

    @Override
    public void setDeathMessage(String deathMessage) {
        throw new NotImplementedException();
    }

    @Override
    public int getNewExp() {
        throw new NotImplementedException();
    }

    @Override
    public void setNewExp(int exp) {
        throw new NotImplementedException();
    }

    @Override
    public int getNewLevel() {
        throw new NotImplementedException();
    }

    @Override
    public void setNewLevel(int level) {
        throw new NotImplementedException();
    }

    @Override
    public int getNewTotalExp() {
        throw new NotImplementedException();
    }

    @Override
    public void setNewTotalExp(int totalExp) {
        throw new NotImplementedException();
    }

    @Override
    public boolean getKeepLevel() {
        throw new NotImplementedException();
    }

    @Override
    public void setKeepLevel(boolean keepLevel) {
        throw new NotImplementedException();
    }

    @Override
    public boolean getKeepInventory() {
        throw new NotImplementedException();
    }

    @Override
    public void setKeepInventory(boolean keepInventory) {
        throw new NotImplementedException();
    }

    @Override
    public int getDroppedExp() {
        throw new NotImplementedException();
    }

    @Override
    public void setDroppedExp(int exp) {
        throw new NotImplementedException();
    }

    @Override
    public List<ItemStack> getDrops() {
        throw new NotImplementedException();
    }
}
