package net.amigocraft.pore.impl.scoreboard;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

//TODO: Bridge

//TODO: Bridge

public class PoreObjective implements Objective {

	@Override
	public String getName() throws IllegalStateException {
		throw new NotImplementedException();
	}

	@Override
	public String getDisplayName() throws IllegalStateException {
		throw new NotImplementedException();
	}

	@Override
	public void setDisplayName(String displayName) throws IllegalStateException, IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public String getCriteria() throws IllegalStateException {
		throw new NotImplementedException();
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
	public void setDisplaySlot(DisplaySlot slot) throws IllegalStateException {
		throw new NotImplementedException();
	}

	@Override
	public DisplaySlot getDisplaySlot() throws IllegalStateException {
		throw new NotImplementedException();
	}

	@Override
	public Score getScore(OfflinePlayer player) throws IllegalArgumentException, IllegalStateException {
		throw new NotImplementedException();
	}

	@Override
	public Score getScore(String entry) throws IllegalArgumentException, IllegalStateException {
		throw new NotImplementedException();
	}

}
