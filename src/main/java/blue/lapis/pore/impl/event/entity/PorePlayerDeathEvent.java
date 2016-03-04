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

import blue.lapis.pore.event.PoreEvent;
import blue.lapis.pore.event.RegisterEvent;
import blue.lapis.pore.event.Source;
import blue.lapis.pore.impl.entity.PorePlayer;
import blue.lapis.pore.util.PoreText;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.entity.DestructEntityEvent;

import java.util.List;

@RegisterEvent
public final class PorePlayerDeathEvent extends PlayerDeathEvent implements PoreEvent<DestructEntityEvent.Death> {

    private final DestructEntityEvent.Death handle;
    private final Player player;

    public PorePlayerDeathEvent(DestructEntityEvent.Death handle, @Source Player player) {
        super(null, null, -1, null);
        this.handle = checkNotNull(handle, "handle");
        this.player = checkNotNull(player, "player");
    }

    @Override
    public DestructEntityEvent.Death getHandle() {
        return this.handle;
    }

    @Override
    public org.bukkit.entity.Player getEntity() {
        return PorePlayer.of(this.player);
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.PLAYER;
    }

    @Override
    public String getDeathMessage() {
        return PoreText.convert(getHandle().getMessage().orElse(null));
    }

    @Override
    public void setDeathMessage(String deathMessage) {
        getHandle().setMessage(PoreText.convert(deathMessage));
    }

    @Override
    public int getNewExp() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setNewExp(int exp) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public int getNewLevel() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setNewLevel(int level) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public int getNewTotalExp() {
        //TODO: WHAT THE HELL EVEN IS THIS METHOD? DID BUKKIT HAVE LITERALLY NO STANDARDS FOR DOCUMENTATION?
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setNewTotalExp(int totalExp) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean getKeepLevel() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setKeepLevel(boolean keepLevel) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean getKeepInventory() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setKeepInventory(boolean keepInventory) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public int getDroppedExp() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setDroppedExp(int exp) {
        throw new NotImplementedException("TODO");
    }

    @Override
    public List<ItemStack> getDrops() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public String toString() {
        return toStringHelper().toString();
    }

}
