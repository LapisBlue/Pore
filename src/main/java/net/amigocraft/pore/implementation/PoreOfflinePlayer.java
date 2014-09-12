package net.amigocraft.pore.implementation;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

//TODO: skeleton implementation

//TODO: skeleton implementation

public class PoreOfflinePlayer implements org.bukkit.OfflinePlayer {

	@Override
	public boolean isOnline() {
		return false;
	}

	@Override
	public String getName() {
		throw new NotImplementedException();
	}

	@Override
	public UUID getUniqueId() {
		throw new NotImplementedException();
	}

	@Override
	public boolean isBanned() {
		return false;
	}

	@Override
	public void setBanned(boolean banned) {
		throw new NotImplementedException();
	}

	@Override
	public boolean isWhitelisted() {
		return false;
	}

	@Override
	public void setWhitelisted(boolean value) {
		throw new NotImplementedException();
	}

	@Override
	public Player getPlayer() {
		throw new NotImplementedException();
	}

	@Override
	public long getFirstPlayed() {
		return 0;
	}

	@Override
	public long getLastPlayed() {
		return 0;
	}

	@Override
	public boolean hasPlayedBefore() {
		return false;
	}

	@Override
	public Location getBedSpawnLocation() {
		throw new NotImplementedException();
	}

	@Override
	public Map<String, Object> serialize() {
		throw new NotImplementedException();
	}

	@Override
	public boolean isOp() {
		return false;
	}

	@Override
	public void setOp(boolean value) {
		throw new NotImplementedException();
	}
}
