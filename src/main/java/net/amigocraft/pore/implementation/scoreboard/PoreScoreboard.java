package net.amigocraft.pore.implementation.scoreboard;

import java.util.Set;

import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

//TODO: Bridge

public class PoreScoreboard implements Scoreboard {

	@Override
	public Objective registerNewObjective(String name, String criteria) throws IllegalArgumentException {
		return null;
	}

	@Override
	public Objective getObjective(String name) throws IllegalArgumentException {
		return null;
	}

	@Override
	public Set<Objective> getObjectivesByCriteria(String criteria) throws IllegalArgumentException {
		return null;
	}

	@Override
	public Set<Objective> getObjectives() {
		return null;
	}

	@Override
	public Objective getObjective(DisplaySlot slot) throws IllegalArgumentException {
		return null;
	}

	@Override
	public Set<Score> getScores(OfflinePlayer player) throws IllegalArgumentException {
		return null;
	}

	@Override
	public Set<Score> getScores(String entry) throws IllegalArgumentException {
		return null;
	}

	@Override
	public void resetScores(OfflinePlayer player) throws IllegalArgumentException {

	}

	@Override
	public void resetScores(String entry) throws IllegalArgumentException {

	}

	@Override
	public Team getPlayerTeam(OfflinePlayer player) throws IllegalArgumentException {
		return null;
	}

	@Override
	public Team getTeam(String teamName) throws IllegalArgumentException {
		return null;
	}

	@Override
	public Set<Team> getTeams() {
		return null;
	}

	@Override
	public Team registerNewTeam(String name) throws IllegalArgumentException {
		return null;
	}

	@Override
	public Set<OfflinePlayer> getPlayers() {
		return null;
	}

	@Override
	public Set<String> getEntries() {
		return null;
	}

	@Override
	public void clearSlot(DisplaySlot slot) throws IllegalArgumentException {

	}

}
