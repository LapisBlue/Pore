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
package net.amigocraft.pore.impl.scoreboard;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

//TODO: Bridge

//TODO: Bridge

public class PoreObjective implements Objective {

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
    public String getCriteria() throws IllegalStateException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isModifiable() throws IllegalStateException {
        throw new NotImplementedException();
    }

    @Override
    public Scoreboard getScoreboard() {
        throw new NotImplementedException();
    }

    @Override
    public void unregister() throws IllegalStateException {
        throw new NotImplementedException();
    }

    @Override
    public void setDisplaySlot(DisplaySlot slot) throws IllegalStateException {
        throw new NotImplementedException();
    }

    @Override
    public DisplaySlot getDisplaySlot() throws IllegalStateException {
        throw new NotImplementedException();
    }

    @Override
    public Score getScore(OfflinePlayer player) throws IllegalArgumentException, IllegalStateException {
        throw new NotImplementedException();
    }

    @Override
    public Score getScore(String entry) throws IllegalArgumentException, IllegalStateException {
        throw new NotImplementedException();
    }

}
