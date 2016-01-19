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

import blue.lapis.pore.converter.wrapper.WrapperConverter;
import blue.lapis.pore.util.PoreWrapper;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.spongepowered.api.scoreboard.critieria.Criteria;
import org.spongepowered.api.scoreboard.objective.Objective;

public class PoreObjective extends PoreWrapper<Objective> implements org.bukkit.scoreboard.Objective {

    public static PoreObjective of(Objective handle) {
        return WrapperConverter.of(PoreObjective.class, handle);
    }

    protected PoreObjective(Objective handle) {
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
        return LEGACY_FORMATTING_CODE.serialize(getHandle().getDisplayName());
    }

    @Override
    @SuppressWarnings("deprecation")
    public void setDisplayName(String displayName) throws IllegalStateException, IllegalArgumentException {
        checkState();
        checkArgument(displayName != null, "Display name must not be null");
        getHandle().setDisplayName(LEGACY_FORMATTING_CODE.deserialize(displayName));
    }

    @Override
    public String getCriteria() throws IllegalStateException {
        checkState();
        return getHandle().getCriterion().getName();
    }

    @Override
    public boolean isModifiable() throws IllegalStateException {
        checkState();
        // TODO: I might try to get a method into SpongeAPI, but this will do for now
        return getHandle().getCriterion() == Criteria.HEALTH;
    }

    @Override
    public Scoreboard getScoreboard() {
        //TODO: eh, this might be screwy because Bukkit doesn't account for multiple parents
        return PoreScoreboard.of(
                (org.spongepowered.api.scoreboard.Scoreboard) getHandle().getScoreboards().toArray()[0]
        );
    }

    @Override
    public void unregister() throws IllegalStateException {
        checkState();
        for (org.spongepowered.api.scoreboard.Scoreboard sb : getHandle().getScoreboards()) {
            sb.removeObjective(getHandle());
        }
    }

    @Override
    public DisplaySlot getDisplaySlot() throws IllegalStateException {
        // I genuinely have no idea why this isn't implemented in SpongeAPI
        checkState();
        throw new NotImplementedException("TODO");
    }

    @Override
    public void setDisplaySlot(DisplaySlot slot) throws IllegalStateException {
        // same goes for this one
        checkState();
        throw new NotImplementedException("TODO");
    }

    @SuppressWarnings("deprecation")
    @Override
    public Score getScore(OfflinePlayer player) throws IllegalArgumentException, IllegalStateException {
        checkState();
        checkArgument(player != null, "Offline player cannot be null");
        //noinspection ConstantConditions
        return getScore(player.getName());
    }

    @SuppressWarnings("deprecation")
    @Override
    public Score getScore(String entry) throws IllegalArgumentException, IllegalStateException {
        checkState();
        checkArgument(entry != null, "Entry cannot be null");
        //noinspection ConstantConditions
        return PoreScore.of(getHandle().getOrCreateScore(LEGACY_FORMATTING_CODE.deserialize(entry)));
    }

    private void checkState() throws IllegalStateException {
        Preconditions.checkState(!getHandle().getScoreboards().isEmpty(), "Objective has been unregistered");
    }

}
