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
package net.amigocraft.pore.impl;

import com.google.common.base.Optional;
import net.amigocraft.pore.impl.entity.PorePlayer;
import net.amigocraft.pore.util.PoreWrapper;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.spongepowered.api.entity.player.User;

import java.util.Map;
import java.util.UUID;

public class PoreOfflinePlayer extends PoreWrapper<User> implements org.bukkit.OfflinePlayer {
    private static TypeConverter<User, PoreOfflinePlayer> converter;

    static TypeConverter<User, PoreOfflinePlayer> getConverter() {
        if (converter == null) {
            converter = new TypeConverter<User, PoreOfflinePlayer>() {
                @Override
                protected PoreOfflinePlayer convert(User handle) {
                    return new PoreOfflinePlayer(handle);
                }
            };
        }

        return converter;
    }

    protected PoreOfflinePlayer(User handle) {
        super(handle);
    }

    public static PoreOfflinePlayer of(User user) {
        return converter.apply(user);
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
        return getHandle().isBanned();
    }

    @Override
    public void setBanned(boolean banned) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isWhitelisted() {
        return getHandle().isWhitelisted();
    }

    @Override
    public void setWhitelisted(boolean value) {
        throw new NotImplementedException();
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
        return getHandle().getFirstPlayed().getTime();
    }

    @Override
    public long getLastPlayed() {
        return getHandle().getLastPlayed().getTime();
    }

    @Override
    public boolean hasPlayedBefore() {
        return getHandle().hasJoinedBefore();
    }

    @Override
    public Location getBedSpawnLocation() {
        throw new NotImplementedException();
    }

    @Override
    public Map<String, Object> serialize() {
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