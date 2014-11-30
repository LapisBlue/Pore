package net.amigocraft.pore.impl.scoreboard;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.*;

import java.util.Set;

//TODO: Bridge

//TODO: Bridge

public class PoreScoreboard implements Scoreboard {

	@Override
	public Objective registerNewObjective(String name, String criteria) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public Objective getObjective(String name) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public Set<Objective> getObjectivesByCriteria(String criteria) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public Set<Objective> getObjectives() {
		throw new NotImplementedException();
	}

	@Override
	public Objective getObjective(DisplaySlot slot) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public Set<Score> getScores(OfflinePlayer player) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public Set<Score> getScores(String entry) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public void resetScores(OfflinePlayer player) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public void resetScores(String entry) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public Team getPlayerTeam(OfflinePlayer player) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public Team getTeam(String teamName) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public Set<Team> getTeams() {
		throw new NotImplementedException();
	}

	@Override
	public Team registerNewTeam(String name) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

	@Override
	public Set<OfflinePlayer> getPlayers() {
		throw new NotImplementedException();
	}

	@Override
	public Set<String> getEntries() {
		throw new NotImplementedException();
	}

	@Override
	public void clearSlot(DisplaySlot slot) throws IllegalArgumentException {
		throw new NotImplementedException();
	}

}
