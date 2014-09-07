package net.amigocraft.pore.implementation;

import org.bukkit.BanEntry;
import org.bukkit.BanList;

import java.util.Date;
import java.util.Set;

public class PoreBanList implements BanList {

	@Override
	public BanEntry getBanEntry(String target){
		return null; //TODO: bridge
	}

	@Override
	public BanEntry addBan(String target, String reason, Date expires, String source){
		return null; //TODO: bridge
	}

	@Override
	public Set<BanEntry> getBanEntries(){
		return null; //TODO: bridge
	}

	@Override
	public boolean isBanned(String target){
		return false; //TODO: bridge
	}

	@Override
	public void pardon(String target){
		//TODO: bridge
	}
}
