package net.amigocraft.pore.implementation.scoreboard;

import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

// TODO: Bridge

public class PoreScore implements Score {

	@Override
	public OfflinePlayer getPlayer() {
		return null;
	}

	@Override
	public String getEntry() {
		return null;
	}

	@Override
	public Objective getObjective() {
		return null;
	}

	@Override
	public int getScore() throws IllegalStateException {
		return 0;
	}

	@Override
	public void setScore(int score) throws IllegalStateException {

	}

	@Override
	public Scoreboard getScoreboard() {
		return null;
	}

}
