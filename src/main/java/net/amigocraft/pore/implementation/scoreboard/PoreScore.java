package net.amigocraft.pore.implementation.scoreboard;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

// TODO: Bridge

// TODO: Bridge

public class PoreScore implements Score {

	@Override
	public OfflinePlayer getPlayer() {
		throw new NotImplementedException();
	}

	@Override
	public String getEntry() {
		throw new NotImplementedException();
	}

	@Override
	public Objective getObjective() {
		throw new NotImplementedException();
	}

	@Override
	public int getScore() throws IllegalStateException {
		return 0;
	}

	@Override
	public void setScore(int score) throws IllegalStateException {
		throw new NotImplementedException();
	}

	@Override
	public Scoreboard getScoreboard() {
		throw new NotImplementedException();
	}

}
