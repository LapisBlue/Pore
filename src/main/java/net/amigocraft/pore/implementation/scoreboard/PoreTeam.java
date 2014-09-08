package net.amigocraft.pore.implementation.scoreboard;

import java.util.Set;

import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class PoreTeam implements Team {

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
	public String getPrefix() throws IllegalStateException {
		return null; //TODO: Bridge
	}

	@Override
	public void setPrefix(String prefix) throws IllegalStateException, IllegalArgumentException {
		 //TODO: Bridge
	}

	@Override
	public String getSuffix() throws IllegalStateException {
		return null; //TODO: Bridge
	}

	@Override
	public void setSuffix(String suffix) throws IllegalStateException, IllegalArgumentException {
		 //TODO: Bridge
	}

	@Override
	public boolean allowFriendlyFire() throws IllegalStateException {
		return false; //TODO: Bridge
	}

	@Override
	public void setAllowFriendlyFire(boolean enabled) throws IllegalStateException {
		 //TODO: Bridge
	}

	@Override
	public boolean canSeeFriendlyInvisibles() throws IllegalStateException {
		return false; //TODO: Bridge
	}

	@Override
	public void setCanSeeFriendlyInvisibles(boolean enabled) throws IllegalStateException {
		 //TODO: Bridge
	}

	@Override
	public Set<OfflinePlayer> getPlayers() throws IllegalStateException {
		return null; //TODO: Bridge
	}

	@Override
	public int getSize() throws IllegalStateException {
		return 0; //TODO: Bridge
	}

	@Override
	public Scoreboard getScoreboard() {
		return null; //TODO: Bridge
	}

	@Override
	public void addPlayer(OfflinePlayer player) throws IllegalStateException, IllegalArgumentException {
		 //TODO: Bridge
	}

	@Override
	public boolean removePlayer(OfflinePlayer player) throws IllegalStateException, IllegalArgumentException {
		return false; //TODO: Bridge
	}

	@Override
	public void unregister() throws IllegalStateException {
		 //TODO: Bridge
	}

	@Override
	public boolean hasPlayer(OfflinePlayer player) throws IllegalArgumentException, IllegalStateException {
		return false; //TODO: Bridge
	}

}
