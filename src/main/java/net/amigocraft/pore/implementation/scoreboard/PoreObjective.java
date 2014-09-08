package net.amigocraft.pore.implementation.scoreboard;

import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

//TODO: Bridge

public class PoreObjective implements Objective {

	@Override
	public String getName() throws IllegalStateException {
		return null; 
	}

	@Override
	public String getDisplayName() throws IllegalStateException {
		return null; 
	}

	@Override
	public void setDisplayName(String displayName) throws IllegalStateException, IllegalArgumentException {
		 
	}

	@Override
	public String getCriteria() throws IllegalStateException {
		return null; 
	}

	@Override
	public boolean isModifiable() throws IllegalStateException {
		return false; 
	}

	@Override
	public Scoreboard getScoreboard() {
		return null; 
	}

	@Override
	public void unregister() throws IllegalStateException {
		 
	}

	@Override
	public void setDisplaySlot(DisplaySlot slot) throws IllegalStateException {
		 
	}

	@Override
	public DisplaySlot getDisplaySlot() throws IllegalStateException {
		return null; 
	}

	@Override
	public Score getScore(OfflinePlayer player) throws IllegalArgumentException, IllegalStateException {
		return null; 
	}

	@Override
	public Score getScore(String entry) throws IllegalArgumentException, IllegalStateException {
		return null; 
	}

}
