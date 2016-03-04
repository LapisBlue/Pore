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

import blue.lapis.pore.converter.wrapper.WrapperConverter;
import blue.lapis.pore.util.PoreText;
import blue.lapis.pore.util.PoreWrapper;

import com.google.common.base.Preconditions;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.spongepowered.api.scoreboard.Score;

public class PoreScore extends PoreWrapper<Score> implements org.bukkit.scoreboard.Score {
    // and seven years ago

    public static PoreScore of(Score handle) {
        return WrapperConverter.of(PoreScore.class, handle);
    }

    protected PoreScore(Score handle) {
        super(handle);
    }

    @Override
    @SuppressWarnings("deprecation")
    public OfflinePlayer getPlayer() {
        return Bukkit.getOfflinePlayer(getEntry());
    }

    @Override
    @SuppressWarnings("deprecation")
    public String getEntry() {
        return PoreText.convert(getHandle().getName());
    }

    @Override
    public Objective getObjective() {
        return (Objective) getHandle().getObjectives().toArray()[0];
    }

    @Override
    public int getScore() throws IllegalStateException {
        checkState();
        return getHandle().getScore();
    }

    @Override
    public void setScore(int score) throws IllegalStateException {
        checkState();
        getHandle().setScore(score);
    }

    @Override
    public Scoreboard getScoreboard() {
        return getObjective().getScoreboard();
    }

    private void checkState() throws IllegalStateException {
        Preconditions.checkState(!getHandle().getObjectives().isEmpty(), "Score has been unregistered");
    }

}
