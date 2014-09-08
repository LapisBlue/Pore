package net.amigocraft.pore.implementation;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

//TODO: skeleton implementation

public class PoreOfflinePlayer implements org.bukkit.OfflinePlayer {

	@Override
	public boolean isOnline() {
		return false;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public UUID getUniqueId() {
		return null;
	}

	@Override
	public boolean isBanned() {
		return false;
	}

	@Override
	public void setBanned(boolean banned) {
		
	}

	@Override
	public boolean isWhitelisted() {
		return false;
	}

	@Override
	public void setWhitelisted(boolean value) {
		
	}

	@Override
	public Player getPlayer() {
		return null;
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
		return null;
	}

	@Override
	public Map<String, Object> serialize() {
		return null;
	}

	@Override
	public boolean isOp() {
		return false;
	}

	@Override
	public void setOp(boolean value) {
		
	}
}
