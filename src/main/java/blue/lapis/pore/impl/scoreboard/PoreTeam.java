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
package blue.lapis.pore.impl.scoreboard;

import static com.google.common.base.Preconditions.checkState;

import blue.lapis.pore.converter.type.scoreboard.NameTagVisibilityConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;
import blue.lapis.pore.impl.PoreOfflinePlayer;
import blue.lapis.pore.util.PoreWrapper;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.NameTagVisibility;
import org.bukkit.scoreboard.Scoreboard;
import org.spongepowered.api.entity.player.User;
import org.spongepowered.api.scoreboard.Team;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.TextMessageException;

import java.util.Set;

public class PoreTeam extends PoreWrapper<Team> implements org.bukkit.scoreboard.Team {

    public static PoreTeam of(Team handle) {
        return WrapperConverter.of(PoreTeam.class, handle);
    }

    protected PoreTeam(Team handle) {
        super(handle);
    }

    @Override
    public String getName() throws IllegalStateException {
        //TODO: check if registered (same goes for all methods throwing an ISE)
        return getHandle().getName();
    }

    @Override
    @SuppressWarnings("deprecation")
    public String getDisplayName() throws IllegalStateException {
        return Texts.legacy().to(getHandle().getDisplayName());
    }

    @Override
    @SuppressWarnings("deprecation")
    public void setDisplayName(String displayName) throws IllegalStateException, IllegalArgumentException {
        checkState(displayName.length() > 32, "Display name must not be longer than 32 characters");
        try {
            getHandle().setDisplayName(Texts.legacy().from(displayName));
        } catch (TextMessageException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public String getPrefix() throws IllegalStateException {
        return Texts.legacy().to(getHandle().getPrefix());
    }

    @Override
    @SuppressWarnings("deprecation")
    public void setPrefix(String prefix) throws IllegalStateException, IllegalArgumentException {
        checkState(prefix != null, "Prefix must not be null");
        try {
            //noinspection ConstantConditions
            getHandle().setPrefix(Texts.legacy().from(prefix));
        } catch (TextMessageException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public String getSuffix() throws IllegalStateException {
        return Texts.legacy().to(getHandle().getSuffix());
    }

    @Override
    @SuppressWarnings("deprecation")
    public void setSuffix(String suffix) throws IllegalStateException, IllegalArgumentException {
        checkState(suffix != null, "Suffix must not be null");
        //noinspection ConstantConditions
        try {
            getHandle().setSuffix(Texts.legacy().from(suffix));
        } catch (TextMessageException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    @Override
    public boolean allowFriendlyFire() throws IllegalStateException {
        return getHandle().allowFriendlyFire();
    }

    @Override
    public void setAllowFriendlyFire(boolean enabled) throws IllegalStateException {
        getHandle().setAllowFriendlyFire(enabled);
    }

    @Override
    public boolean canSeeFriendlyInvisibles() throws IllegalStateException {
        return getHandle().canSeeFriendlyInvisibles();
    }

    @Override
    public void setCanSeeFriendlyInvisibles(boolean enabled) throws IllegalStateException {
        getHandle().setCanSeeFriendlyInvisibles(enabled);
    }

    @Override
    public NameTagVisibility getNameTagVisibility() throws IllegalArgumentException {
        return NameTagVisibilityConverter.of(getHandle().getNameTagVisibility());
    }

    @Override
    public void setNameTagVisibility(NameTagVisibility visibility) throws IllegalArgumentException {
        checkState(visibility != null, "Visibility cannot be null");
        getHandle().setNameTagVisibility(NameTagVisibilityConverter.of(visibility));
    }

    @Override
    public Set<OfflinePlayer> getPlayers() throws IllegalStateException {
        return Sets.newHashSet(Collections2.transform(getHandle().getUsers(),
                new Function<User, OfflinePlayer>() {
                    @Override
                    public OfflinePlayer apply(User user) {
                        return PoreOfflinePlayer.of(user);
                    }
                }
        ));
    }

    @Override
    public Set<String> getEntries() throws IllegalStateException {
        throw new NotImplementedException("TODO");
    }

    @Override
    public int getSize() throws IllegalStateException {
        return getHandle().getUsers().size();
    }

    @Override
    public Scoreboard getScoreboard() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void addPlayer(OfflinePlayer player) throws IllegalStateException, IllegalArgumentException {
        getHandle().addUser(((PoreOfflinePlayer)player).getHandle());
    }

    @Override
    public void addEntry(String entry) throws IllegalStateException, IllegalArgumentException {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean removePlayer(OfflinePlayer player) throws IllegalStateException, IllegalArgumentException {
        return getHandle().removeUser(((PoreOfflinePlayer)player).getHandle());
    }

    @Override
    public boolean removeEntry(String entry) throws IllegalStateException, IllegalArgumentException {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void unregister() throws IllegalStateException {
        throw new NotImplementedException("TODO");
    }

    @Override
    public boolean hasPlayer(OfflinePlayer player) throws IllegalArgumentException, IllegalStateException {
        checkState(player != null, "Offline player cannot be null");
        //noinspection ConstantConditions
        return getHandle().getUsers().contains(((PoreOfflinePlayer) player).getHandle());
    }

    @Override
    public boolean hasEntry(String entry) throws IllegalArgumentException, IllegalStateException {
        throw new NotImplementedException("TODO");
    }

}
