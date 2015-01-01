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
package net.amigocraft.pore.impl.scoreboard;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.NameTagVisibility;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.Set;

// TODO: Bridge

public class PoreTeam implements Team {

    @Override
    public String getName() throws IllegalStateException {
        throw new NotImplementedException();
    }

    @Override
    public String getDisplayName() throws IllegalStateException {
        throw new NotImplementedException();
    }

    @Override
    public void setDisplayName(String displayName) throws IllegalStateException, IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public String getPrefix() throws IllegalStateException {
        throw new NotImplementedException();
    }

    @Override
    public void setPrefix(String prefix) throws IllegalStateException, IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public String getSuffix() throws IllegalStateException {
        throw new NotImplementedException();
    }

    @Override
    public void setSuffix(String suffix) throws IllegalStateException, IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public boolean allowFriendlyFire() throws IllegalStateException {
        throw new NotImplementedException();
    }

    @Override
    public void setAllowFriendlyFire(boolean enabled) throws IllegalStateException {
        throw new NotImplementedException();
    }

    @Override
    public boolean canSeeFriendlyInvisibles() throws IllegalStateException {
        throw new NotImplementedException();
    }

    @Override
    public void setCanSeeFriendlyInvisibles(boolean enabled) throws IllegalStateException {
        throw new NotImplementedException();
    }

    @Override
    public NameTagVisibility getNameTagVisibility() throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void setNameTagVisibility(NameTagVisibility visibility) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public Set<OfflinePlayer> getPlayers() throws IllegalStateException {
        throw new NotImplementedException();
    }

    @Override
    public int getSize() throws IllegalStateException {
        throw new NotImplementedException();
    }

    @Override
    public Scoreboard getScoreboard() {
        throw new NotImplementedException();
    }

    @Override
    public void addPlayer(OfflinePlayer player) throws IllegalStateException, IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public boolean removePlayer(OfflinePlayer player) throws IllegalStateException, IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void unregister() throws IllegalStateException {
        throw new NotImplementedException();
    }

    @Override
    public boolean hasPlayer(OfflinePlayer player) throws IllegalArgumentException, IllegalStateException {
        throw new NotImplementedException();
    }

}
