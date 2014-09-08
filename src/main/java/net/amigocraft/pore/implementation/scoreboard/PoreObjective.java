package net.amigocraft.pore.implementation.scoreboard;

import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class PoreObjective implements Objective {

	@Override
	public String getName() throws IllegalStateException {
		return null; //TODO: Bridge
	}

	@Override
	public String getDisplayName() throws IllegalStateException {
		return null; //TODO: Bridge
	}

	@Override
	public void setDisplayName(String displayName) throws IllegalStateException, IllegalArgumentException {
		 //TODO: Bridge
	}

	@Override
	public String getCriteria() throws IllegalStateException {
		return null; //TODO: Bridge
	}

	@Override
	public boolean isModifiable() throws IllegalStateException {
		return false; //TODO: Bridge
	}

	@Override
	public Scoreboard getScoreboard() {
		return null; //TODO: Bridge
	}

	@Override
	public void unregister() throws IllegalStateException {
		 //TODO: Bridge
	}

	@Override
	public void setDisplaySlot(DisplaySlot slot) throws IllegalStateException {
		 //TODO: Bridge
	}

	@Override
	public DisplaySlot getDisplaySlot() throws IllegalStateException {
		return null; //TODO: Bridge
	}

	@Override
	public Score getScore(OfflinePlayer player) throws IllegalArgumentException, IllegalStateException {
		return null; //TODO: Bridge
	}

	@Override
	public Score getScore(String entry) throws IllegalArgumentException, IllegalStateException {
		return null; //TODO: Bridge
	}

}
