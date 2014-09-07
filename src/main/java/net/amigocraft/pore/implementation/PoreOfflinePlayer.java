package net.amigocraft.pore.implementation;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

public class PoreOfflinePlayer implements org.bukkit.OfflinePlayer {

	@Override
	public boolean isOnline(){
		return false; //TODO: bridge
	}

	@Override
	public String getName(){
		return null; //TODO: bridge
	}

	@Override
	public UUID getUniqueId(){
		return null; //TODO: bridge
	}

	@Override
	public boolean isBanned(){
		return false; //TODO: bridge
	}

	@Override
	public void setBanned(boolean banned){
		//TODO: bridge
	}

	@Override
	public boolean isWhitelisted(){
		return false; //TODO: bridge
	}

	@Override
	public void setWhitelisted(boolean value){
		//TODO: bridge
	}

	@Override
	public Player getPlayer(){
		return null; //TODO: bridge
	}

	@Override
	public long getFirstPlayed(){
		return 0; //TODO: bridge
	}

	@Override
	public long getLastPlayed(){
		return 0; //TODO: bridge
	}

	@Override
	public boolean hasPlayedBefore(){
		return false; //TODO: bridge
	}

	@Override
	public Location getBedSpawnLocation(){
		return null; //TODO: bridge
	}

	@Override
	public Map<String, Object> serialize(){
		return null; //TODO: bridge
	}

	@Override
	public boolean isOp(){
		return false; //TODO: bridge
	}

	@Override
	public void setOp(boolean value){
		//TODO: bridge
	}
}
