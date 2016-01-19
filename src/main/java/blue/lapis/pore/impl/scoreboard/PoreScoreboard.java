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
import static org.spongepowered.api.text.serializer.TextSerializers.LEGACY_FORMATTING_CODE;

import blue.lapis.pore.Pore;
import blue.lapis.pore.converter.type.scoreboard.DisplaySlotConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;
import blue.lapis.pore.impl.PoreOfflinePlayer;
import blue.lapis.pore.util.PoreWrapper;

import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Team;
import org.spongepowered.api.scoreboard.Scoreboard;
import org.spongepowered.api.scoreboard.critieria.Criterion;
import org.spongepowered.api.scoreboard.objective.Objective;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.serializer.TextSerializers;
import org.spongepowered.api.util.TextMessageException;

import java.util.Optional;
import java.util.Set;

public class PoreScoreboard extends PoreWrapper<Scoreboard> implements org.bukkit.scoreboard.Scoreboard {

    public static PoreScoreboard of(Scoreboard handle) {
        return WrapperConverter.of(PoreScoreboard.class, handle);
    }

    protected PoreScoreboard(Scoreboard handle) {
        super(handle);
    }

    @Override
    public org.bukkit.scoreboard.Objective registerNewObjective(String name, String criteria) throws IllegalArgumentException {
        checkArgument(name != null, "Name must not be null");
        Objective.Builder builder = Objective.builder();
        //noinspection ConstantConditions
        builder.name(name);
        if (criteria != null) {
            //TODO: no idea whether this is right
            Optional<Criterion> criterion = Pore.getGame().getRegistry().getType(Criterion.class, criteria);
            if (criterion.isPresent()) {
                builder.criterion(criterion.get());
            }
        }
        return PoreObjective.of(builder.build());
    }

    @Override
    public org.bukkit.scoreboard.Objective getObjective(String name) throws IllegalArgumentException {
        checkArgument(name != null, "Name must not be null");
        return PoreObjective.of(getHandle().getObjective(name).orElse(null));
    }

    @Override
    public Set<org.bukkit.scoreboard.Objective> getObjectivesByCriteria(String criteria) throws IllegalArgumentException {
        checkArgument(criteria != null, "Criterion must not be null");
        //TODO: no idea whether this is right
        Optional<Criterion> c = Pore.getGame().getRegistry().getType(Criterion.class, criteria);
        checkArgument(c.isPresent(), "Invalid criterion");
        return Sets.newHashSet(Collections2.transform(getHandle().getObjectivesByCriteria(c.get()),
                PoreObjective::of
        ));
    }

    @Override
    public Set<org.bukkit.scoreboard.Objective> getObjectives() {
        return Sets.newHashSet(Collections2.transform(getHandle().getObjectives(), PoreObjective::of));
    }

    @Override
    public org.bukkit.scoreboard.Objective getObjective(DisplaySlot slot) throws IllegalArgumentException {
        checkArgument(slot != null, "Display slot must not be null");
        return PoreObjective.of(getHandle().getObjective(DisplaySlotConverter.of(slot)).orElse(null));
    }

    @SuppressWarnings("deprecation")
    @Override
    public Set<Score> getScores(OfflinePlayer player) throws IllegalArgumentException {
        checkArgument(player != null, "Offline player must not be null");
        return getScores(player.getName());
    }

    @Override
    @SuppressWarnings("deprecation")
    public Set<Score> getScores(String entry) throws IllegalArgumentException {
        checkArgument(entry != null, "Entry must not be null");
        return Sets.newHashSet(Collections2.transform(
                getHandle().getScores(LEGACY_FORMATTING_CODE.deserialize(entry)),
                PoreScore::of
        ));
    }

    @SuppressWarnings("deprecation")
    @Override
    public void resetScores(OfflinePlayer player) throws IllegalArgumentException {
        checkArgument(player != null, "Offline player must not be null");
        resetScores(player.getName());
    }

    @Override
    @SuppressWarnings("deprecation")
    public void resetScores(String entry) throws IllegalArgumentException {
        checkArgument(entry != null, "Entry must not be null");
        getHandle().removeScores(LEGACY_FORMATTING_CODE.deserialize(entry));
    }

    @SuppressWarnings("deprecation")
    @Override
    public Team getPlayerTeam(OfflinePlayer player) throws IllegalArgumentException {
        checkArgument(player != null, "Offline player must not be null");
        return PoreTeam.of(getHandle().getMemberTeam(
                LEGACY_FORMATTING_CODE.deserialize(((PoreOfflinePlayer) player).getHandle().getName())).orElse(null));
    }

    @SuppressWarnings("deprecation")
    @Override
    public Team getEntryTeam(String entry) throws IllegalArgumentException {
        for (org.spongepowered.api.scoreboard.Team team : getHandle().getTeams()) {
            for (Text text : team.getMembers()) {
                if (LEGACY_FORMATTING_CODE.serialize(text).equals(entry)) {
                    return PoreTeam.of(team);
                }
            }
        }
        return null;
    }

    @Override
    public Team getTeam(String teamName) throws IllegalArgumentException {
        checkArgument(teamName != null, "Team name must not be null");
        return PoreTeam.of(getHandle().getTeam(teamName).orElse(null));
    }

    @Override
    public Set<Team> getTeams() {
        return Sets.newHashSet(Collections2.transform(getHandle().getTeams(),
                PoreTeam::of
        ));
    }

    @Override
    public Team registerNewTeam(String name) throws IllegalArgumentException {
        checkArgument(name != null, "Team name must not be null");
        org.spongepowered.api.scoreboard.Team.Builder builder = org.spongepowered.api.scoreboard.Team.builder();
        builder.name(name);
        return PoreTeam.of(builder.build());
    }

    @Override
    @SuppressWarnings("deprecation")
    public Set<OfflinePlayer> getPlayers() {
        return Sets.newHashSet(Collections2.transform(getEntries(),
                Bukkit::getOfflinePlayer
        ));
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
