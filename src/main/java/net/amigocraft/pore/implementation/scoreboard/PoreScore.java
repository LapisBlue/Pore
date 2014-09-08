package net.amigocraft.pore.implementation.scoreboard;

import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class PoreScore implements Score {

	@Override
	public OfflinePlayer getPlayer() {
		return null; //TODO: Bridge
	}

	@Override
	public String getEntry() {
		return null; //TODO: Bridge
	}

	@Override
	public Objective getObjective() {
		return null; //TODO: Bridge
	}

	@Override
	public int getScore() throws IllegalStateException {
		return 0; //TODO: Bridge
	}

	@Override
	public void setScore(int score) throws IllegalStateException {
		 //TODO: Bridge
	}

	@Override
	public Scoreboard getScoreboard() {
		return null; //TODO: Bridge
	}

}
