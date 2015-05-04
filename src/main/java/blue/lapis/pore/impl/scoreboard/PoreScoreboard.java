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

import blue.lapis.pore.Pore;
import blue.lapis.pore.converter.type.scoreboard.DisplaySlotConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;
import blue.lapis.pore.impl.PoreOfflinePlayer;
import blue.lapis.pore.util.PoreWrapper;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Team;
import org.spongepowered.api.scoreboard.Scoreboard;
import org.spongepowered.api.scoreboard.TeamBuilder;
import org.spongepowered.api.scoreboard.critieria.Criterion;
import org.spongepowered.api.scoreboard.objective.ObjectiveBuilder;
import org.spongepowered.api.text.Texts;

import java.util.Set;

public class PoreScoreboard extends PoreWrapper<Scoreboard> implements org.bukkit.scoreboard.Scoreboard {

    public static PoreScoreboard of(Scoreboard handle) {
        return WrapperConverter.of(PoreScoreboard.class, handle);
    }

    protected PoreScoreboard(Scoreboard handle) {
        super(handle);
    }

    @Override
    public Objective registerNewObjective(String name, String criteria) throws IllegalArgumentException {
        checkState(name != null, "Name cannot be null");
        ObjectiveBuilder builder = Pore.getGame().getRegistry().getObjectiveBuilder();
        //noinspection ConstantConditions
        builder.name(name);
        if (criteria != null) {
            Optional<Criterion> criterion = Pore.getGame().getRegistry()
                            .getType(Criterion.class, criteria); //TODO: no idea whether this is right
            if (criterion.isPresent()) {
                builder.criterion(criterion.get());
            }
        }
        return PoreObjective.of(builder.build());
    }

    @Override
    public Objective getObjective(String name) throws IllegalArgumentException {
        checkState(name != null, "Name cannot be null");
        //noinspection ConstantConditions
        return PoreObjective.of(getHandle().getObjective(name).orNull());
    }

    @Override
    public Set<Objective> getObjectivesByCriteria(String criteria) throws IllegalArgumentException {
        checkState(criteria != null, "Criterion cannot be null");
        //noinspection ConstantConditions
        Optional<Criterion> c = Pore.getGame().getRegistry()
                .getType(Criterion.class, criteria); //TODO: no idea whether this is right
        checkState(c.isPresent(), "Invalid criterion");
        return Sets.newHashSet(Collections2.transform(getHandle().getObjectivesByCriteria(c.get()),
                new Function<org.spongepowered.api.scoreboard.objective.Objective, Objective>() {
                    public Objective apply(org.spongepowered.api.scoreboard.objective.Objective obj) {
                        return PoreObjective.of(obj);
                    }
                }
        ));
    }

    @Override
    public Set<Objective> getObjectives() {
        return Sets.newHashSet(Collections2.transform(getHandle().getObjectives(),
                new Function<org.spongepowered.api.scoreboard.objective.Objective, Objective>() {
                    public Objective apply(org.spongepowered.api.scoreboard.objective.Objective obj) {
                        return PoreObjective.of(obj);
                    }
                }
        ));
    }

    @Override
    public Objective getObjective(DisplaySlot slot) throws IllegalArgumentException {
        checkState(slot != null, "Display slot cannot be null");
        return PoreObjective.of(getHandle().getObjective(DisplaySlotConverter.of(slot)).orNull());
    }

    @Override
    public Set<Score> getScores(OfflinePlayer player) throws IllegalArgumentException {
        checkState(player != null, "Offline player cannot be null");
        //noinspection ConstantConditions
        return getScores(player.getName());
    }

    @Override
    @SuppressWarnings("deprecation")
    public Set<Score> getScores(String entry) throws IllegalArgumentException {
        checkState(entry != null, "Entry cannot be null");
        //TODO deprecated, not sure this is right
        //noinspection ConstantConditions
        return Sets.newHashSet(Collections2.transform(getHandle().getScores(Texts.fromLegacy(entry)),
                new Function<org.spongepowered.api.scoreboard.Score, Score>() {
                    public Score apply(org.spongepowered.api.scoreboard.Score score) {
                        return PoreScore.of(score);
                    }
                }
        ));
    }

    @Override
    public void resetScores(OfflinePlayer player) throws IllegalArgumentException {
        checkState(player != null, "Offline player cannot be null");
        //noinspection ConstantConditions
        resetScores(player.getName());
    }

    @Override
    @SuppressWarnings("deprecation")
    public void resetScores(String entry) throws IllegalArgumentException {
        checkState(entry != null, "Entry cannot be null");
        //noinspection ConstantConditions
        getHandle().removeScores(Texts.fromLegacy(entry)); //TODO deprecated, not sure this is right
    }

    @Override
    public Team getPlayerTeam(OfflinePlayer player) throws IllegalArgumentException {
        checkState(player != null, "Offline player cannot be null");
        //noinspection ConstantConditions
        Set<org.spongepowered.api.scoreboard.Team> teams =
                getHandle().getPlayerTeams(((PoreOfflinePlayer) player).getHandle());
        if (teams.isEmpty()) {
            return null;
        }
        return PoreTeam.of(((org.spongepowered.api.scoreboard.Team[])teams.toArray())[0]);
    }

    @Override
    public Team getTeam(String teamName) throws IllegalArgumentException {
        checkState(teamName != null, "Team name cannot be null");
        //noinspection ConstantConditions
        return PoreTeam.of(getHandle().getTeam(teamName).orNull());
    }

    @Override
    public Set<Team> getTeams() {
        return Sets.newHashSet(Collections2.transform(getHandle().getTeams(),
                new Function<org.spongepowered.api.scoreboard.Team, Team>() {
                    public Team apply(org.spongepowered.api.scoreboard.Team team) {
                        return PoreTeam.of(team);
                    }
                }
        ));
    }

    @Override
    public Team registerNewTeam(String name) throws IllegalArgumentException {
        checkState(name != null, "Team name cannot be null");
        TeamBuilder builder = Pore.getGame().getRegistry().getTeamBuilder();
        //noinspection ConstantConditions
        builder.name(name);
        return PoreTeam.of(builder.build());
    }

    @Override
    @SuppressWarnings("deprecation")
    public Set<OfflinePlayer> getPlayers() {
        /*return Sets.newHashSet(Collections2.transform(getHandle().getEntries(),
                new Function<String, OfflinePlayer>() {
                    public OfflinePlayer apply(String entry) {
                        return Bukkit.getOfflinePlayer(entry);
                    }
                }
        ));*/ //TODO
        throw new NotImplementedException("TODO");
    }

    @Override
    public Set<String> getEntries() {
        throw new NotImplementedException("TODO");
    }

    @Override
    public void clearSlot(DisplaySlot slot) throws IllegalArgumentException {
        getHandle().clearSlot(DisplaySlotConverter.of(slot));
    }

}
