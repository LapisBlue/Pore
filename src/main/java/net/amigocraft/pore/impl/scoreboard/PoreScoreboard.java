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
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.Set;

//TODO: Bridge

//TODO: Bridge

public class PoreScoreboard implements Scoreboard {

    @Override
    public Objective registerNewObjective(String name, String criteria) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public Objective getObjective(String name) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public Set<Objective> getObjectivesByCriteria(String criteria) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public Set<Objective> getObjectives() {
        throw new NotImplementedException();
    }

    @Override
    public Objective getObjective(DisplaySlot slot) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public Set<Score> getScores(OfflinePlayer player) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public Set<Score> getScores(String entry) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void resetScores(OfflinePlayer player) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void resetScores(String entry) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public Team getPlayerTeam(OfflinePlayer player) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public Team getTeam(String teamName) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public Set<Team> getTeams() {
        throw new NotImplementedException();
    }

    @Override
    public Team registerNewTeam(String name) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public Set<OfflinePlayer> getPlayers() {
        throw new NotImplementedException();
    }

    @Override
    public Set<String> getEntries() {
        throw new NotImplementedException();
    }

    @Override
    public void clearSlot(DisplaySlot slot) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

}
