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

import static com.google.common.base.Preconditions.checkArgument;

import blue.lapis.pore.Pore;
import blue.lapis.pore.converter.type.scoreboard.NameTagVisibilityConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;
import blue.lapis.pore.util.PoreWrapper;

import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.NameTagVisibility;
import org.bukkit.scoreboard.Scoreboard;
import org.spongepowered.api.scoreboard.Team;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.TextMessageException;

import java.util.Set;

public class PoreTeam extends PoreWrapper<Team> implements org.bukkit.scoreboard.Team {

    private static final int MAX_NAME_LENGTH = 32;

    public static PoreTeam of(Team handle) {
        return WrapperConverter.of(PoreTeam.class, handle);
    }

    protected PoreTeam(Team handle) {
        super(handle);
    }

    @Override
    public String getName() throws IllegalStateException {
        checkState();
        return getHandle().getName();
    }

    @Override
    @SuppressWarnings("deprecation")
    public String getDisplayName() throws IllegalStateException {
        checkState();
        return Texts.legacy().to(getHandle().getDisplayName());
    }

    @Override
    @SuppressWarnings("deprecation")
    public void setDisplayName(String displayName) throws IllegalStateException, IllegalArgumentException {
        checkState();
        checkArgument(displayName.length() > MAX_NAME_LENGTH,
                "Display name must not be longer than " + MAX_NAME_LENGTH + " characters");
        try {
            getHandle().setDisplayName(Texts.legacy().from(displayName));
        } catch (TextMessageException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public String getPrefix() throws IllegalStateException {
        checkState();
        return Texts.legacy().to(getHandle().getPrefix());
    }

    @Override
    @SuppressWarnings("deprecation")
    public void setPrefix(String prefix) throws IllegalStateException, IllegalArgumentException {
        checkState();
        checkArgument(prefix != null, "Prefix must not be null");
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
        checkState();
        return Texts.legacy().to(getHandle().getSuffix());
    }

    @Override
    @SuppressWarnings("deprecation")
    public void setSuffix(String suffix) throws IllegalStateException, IllegalArgumentException {
        checkState();
        checkArgument(suffix != null, "Suffix must not be null");
        try {
            //noinspection ConstantConditions
            getHandle().setSuffix(Texts.legacy().from(suffix));
        } catch (TextMessageException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    @Override
    public boolean allowFriendlyFire() throws IllegalStateException {
        checkState();
        return getHandle().allowFriendlyFire();
    }

    @Override
    public void setAllowFriendlyFire(boolean enabled) throws IllegalStateException {
        checkState();
        getHandle().setAllowFriendlyFire(enabled);
    }

    @Override
    public boolean canSeeFriendlyInvisibles() throws IllegalStateException {
        checkState();
        return getHandle().canSeeFriendlyInvisibles();
    }

    @Override
    public void setCanSeeFriendlyInvisibles(boolean enabled) throws IllegalStateException {
        checkState();
        getHandle().setCanSeeFriendlyInvisibles(enabled);
    }

    @Override
    public NameTagVisibility getNameTagVisibility() throws IllegalArgumentException {
        checkState(); // this is technically against documentation but the documentation is stupid for this method
        return NameTagVisibilityConverter.of(getHandle().getNameTagVisibility());
    }

    @Override
    public void setNameTagVisibility(NameTagVisibility visibility) throws IllegalArgumentException {
        checkState(); // same for this
        checkArgument(visibility != null, "Visibility cannot be null");
        getHandle().setNameTagVisibility(NameTagVisibilityConverter.of(visibility));
    }

    @Override
    public Set<OfflinePlayer> getPlayers() throws IllegalStateException {
        checkState();
        return Sets.newHashSet(Collections2.transform(getHandle().getMembers(),
                user -> Pore.getServer().getOfflinePlayer(Texts.toPlain(user))
        ));
    }

    @Override
    public Set<String> getEntries() throws IllegalStateException {
        checkState();
        return Sets.newHashSet(Collections2.transform(getHandle().getMembers(),
                Texts::toPlain
        ));
    }

    @Override
    public int getSize() throws IllegalStateException {
        checkState();
        return getHandle().getMembers().size();
    }

    @Override
    public Scoreboard getScoreboard() {
        //TODO: this method might behave weirdly
        return PoreScoreboard.of(
                (org.spongepowered.api.scoreboard.Scoreboard) getHandle().getScoreboards().toArray()[0]
        );
    }

    @Override
    public void addPlayer(OfflinePlayer player) throws IllegalStateException, IllegalArgumentException {
        checkArgument(player != null, "Player cannot be null");
        addEntry(player.getName());
    }

    @Override
    @SuppressWarnings("deprecation")
    public void addEntry(String entry) throws IllegalStateException, IllegalArgumentException {
        checkArgument(entry != null, "Entry cannot be null");
        checkState();
        getHandle().addMember(Texts.of(entry));
    }

    @Override
    public boolean removePlayer(OfflinePlayer player) throws IllegalStateException, IllegalArgumentException {
        checkArgument(player != null, "Player cannot be null");
        //noinspection ConstantConditions
        return removeEntry(player.getName());
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean removeEntry(String entry) throws IllegalStateException, IllegalArgumentException {
        checkState();
        checkArgument(entry != null, "Entry cannot be null");
        for (Text user : getHandle().getMembers()) {
            if (Texts.toPlain(user).equals(entry)) {
                return getHandle().removeMember(user);
            }
        }
        return false;
    }

    @Override
    public void unregister() throws IllegalStateException {
        checkState();
        for (org.spongepowered.api.scoreboard.Scoreboard scoreboard : getHandle().getScoreboards()) {
            scoreboard.removeTeam(getHandle());
        }
    }

    @Override
    public boolean hasPlayer(OfflinePlayer player) throws IllegalArgumentException, IllegalStateException {
        checkArgument(player != null, "Offline player cannot be null");
        //noinspection ConstantConditions
        return hasEntry(player.getName());
    }

    @Override
    public boolean hasEntry(String entry) throws IllegalArgumentException, IllegalStateException {
        checkState();
        checkArgument(entry != null, "Entry cannot be null");
        for (Text user : getHandle().getMembers()) {
            if (Texts.toPlain(user).equals(entry)) {
                return true;
            }
        }
        return false;
    }

    private void checkState() throws IllegalStateException {
        Preconditions.checkState(!getHandle().getScoreboards().isEmpty(), "Team has been unregistered");
    }

}
