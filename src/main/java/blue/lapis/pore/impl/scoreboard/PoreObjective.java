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

import blue.lapis.pore.converter.type.scoreboard.DisplaySlotConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;
import blue.lapis.pore.util.PoreWrapper;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.spongepowered.api.scoreboard.objective.Objective;
import org.spongepowered.api.text.Texts;

public class PoreObjective extends PoreWrapper<Objective> implements org.bukkit.scoreboard.Objective {

    private org.spongepowered.api.scoreboard.Scoreboard handle;

    public static PoreObjective of(Objective handle) {
        return WrapperConverter.of(PoreObjective.class, handle);
    }

    protected PoreObjective(Objective handle) {
        super(handle);
    }

    @Override
    public String getName() throws IllegalStateException {
        //TODO: check if registered (same goes for all other methods throwing an ISE)
        return getHandle().getName();
    }

    @Override
    @SuppressWarnings("deprecation")
    public String getDisplayName() throws IllegalStateException {
        return Texts.toLegacy(getHandle().getDisplayName());
    }

    @Override
    @SuppressWarnings("deprecation")
    public void setDisplayName(String displayName) throws IllegalStateException, IllegalArgumentException {
        checkState(displayName != null, "Display name cannot be null");
        getHandle().setDisplayName(Texts.fromLegacy(displayName));
    }

    @Override
    public String getCriteria() throws IllegalStateException {
        return getHandle().getCriterion().getName();
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
    public DisplaySlot getDisplaySlot() throws IllegalStateException {
        return DisplaySlotConverter.of(getHandle().getDisplaySlot().orNull());
    }

    @Override
    public void setDisplaySlot(DisplaySlot slot) throws IllegalStateException {
        getHandle().setDisplaySlot(DisplaySlotConverter.of(slot));
    }

    @Override
    public Score getScore(OfflinePlayer player) throws IllegalArgumentException, IllegalStateException {
        checkState(player != null, "Offline player cannot be null");
        //noinspection ConstantConditions
        return getScore(player.getName());
    }

    @Override
    public Score getScore(String entry) throws IllegalArgumentException, IllegalStateException {
        checkState(entry != null, "Entry cannot be null");
        //TODO: check if registered
        return PoreScore.of(getHandle().getScore(Texts.of(entry)));
    }

}
