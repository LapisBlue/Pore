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
package blue.lapis.pore.impl;

import static org.spongepowered.api.data.manipulator.catalog.CatalogEntityData.JOIN_DATA;
import static org.spongepowered.api.data.manipulator.catalog.CatalogEntityData.WHITELIST_DATA;

import blue.lapis.pore.converter.wrapper.WrapperConverter;
import blue.lapis.pore.impl.entity.PorePlayer;
import blue.lapis.pore.util.PoreWrapper;

import com.google.common.base.Optional;
import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.spongepowered.api.entity.player.User;

import java.util.Map;
import java.util.UUID;

public class PoreOfflinePlayer extends PoreWrapper<User> implements OfflinePlayer {

    public static PoreOfflinePlayer of(User handle) {
        return WrapperConverter.of(PoreOfflinePlayer.class, handle);
    }

    protected PoreOfflinePlayer(User handle) {
        super(handle);
    }

    @Override
    public boolean isOnline() {
        return getHandle().isOnline();
    }

    @Override
    public String getName() {
        return getHandle().getName();
    }

    @Override
    public UUID getUniqueId() {
        return getHandle().getUniqueId();
    }

    @Override
    public boolean isBanned() {
        throw new NotImplementedException("TODO");//TODO: Use the BanService
    }

    @Override
    public void setBanned(boolean banned) {       
        throw new NotImplementedException("TODO");//TODO: Use the BanService
    }

    @Override
    public boolean isWhitelisted() {
        return getHandle().get(WHITELIST_DATA).isPresent() && getHandle().get(WHITELIST_DATA).get().whitelisted().get();
    }

    @Override
    public void setWhitelisted(boolean value) {
        if (value != isWhitelisted()) {
            if (value) {
                getHandle().offer(getHandle().getOrCreate(WHITELIST_DATA).get().whitelisted().set(true));
            } else {
                getHandle().remove(WHITELIST_DATA);
            }
        }
    }

    @Override
    public Player getPlayer() {
        Optional<org.spongepowered.api.entity.player.Player> player = getHandle().getPlayer();
        if (player.isPresent()) {
            return PorePlayer.of(player.get());
        } else {
            return null;
        }
    }

    @Override
    public long getFirstPlayed() {
        return getHandle().get(JOIN_DATA).get().firstPlayed().get().getTime();
    }

    @Override
    public long getLastPlayed() {
        return getHandle().get(JOIN_DATA).get().lastPlayed().get().getTime();
    }

    @Override
    public boolean hasPlayedBefore() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public Location getBedSpawnLocation() {
        throw new NotImplementedException("TODO"); // can't determine the world
    }

    @Override
    public Map<String, Object> serialize() {
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
