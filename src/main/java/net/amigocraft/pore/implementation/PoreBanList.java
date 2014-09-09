package net.amigocraft.pore.implementation;

import org.bukkit.BanEntry;
import org.bukkit.BanList;

import java.util.Date;
import java.util.Set;

//TODO: skeleton implementation

public class PoreBanList implements BanList {

	@Override
	public BanEntry getBanEntry(String target) {
		return null;
	}

	@Override
	public BanEntry addBan(String target, String reason, Date expires, String source) {
		return null;
	}

	@Override
	public Set<BanEntry> getBanEntries() {
		return null;
	}

	@Override
	public boolean isBanned(String target) {
		return false;
	}

	@Override
	public void pardon(String target) {
		
	}
}
