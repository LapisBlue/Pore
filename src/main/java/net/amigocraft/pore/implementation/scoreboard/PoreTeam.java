package net.amigocraft.pore.implementation.scoreboard;

import java.util.Set;

import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

// TODO: Bridge

public class PoreTeam implements Team {

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
	public String getPrefix() throws IllegalStateException {
		return null;
	}

	@Override
	public void setPrefix(String prefix) throws IllegalStateException, IllegalArgumentException {

	}

	@Override
	public String getSuffix() throws IllegalStateException {
		return null;
	}

	@Override
	public void setSuffix(String suffix) throws IllegalStateException, IllegalArgumentException {

	}

	@Override
	public boolean allowFriendlyFire() throws IllegalStateException {
		return false;
	}

	@Override
	public void setAllowFriendlyFire(boolean enabled) throws IllegalStateException {

	}

	@Override
	public boolean canSeeFriendlyInvisibles() throws IllegalStateException {
		return false;
	}

	@Override
	public void setCanSeeFriendlyInvisibles(boolean enabled) throws IllegalStateException {

	}

	@Override
	public Set<OfflinePlayer> getPlayers() throws IllegalStateException {
		return null;
	}

	@Override
	public int getSize() throws IllegalStateException {
		return 0;
	}

	@Override
	public Scoreboard getScoreboard() {
		return null;
	}

	@Override
	public void addPlayer(OfflinePlayer player) throws IllegalStateException, IllegalArgumentException {

	}

	@Override
	public boolean removePlayer(OfflinePlayer player) throws IllegalStateException, IllegalArgumentException {
		return false;
	}

	@Override
	public void unregister() throws IllegalStateException {

	}

	@Override
	public boolean hasPlayer(OfflinePlayer player) throws IllegalArgumentException, IllegalStateException {
		return false;
	}

}
