package net.amigocraft.pore.impl;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.BanEntry;
import org.bukkit.BanList;

import java.util.Date;
import java.util.Set;

//TODO: skeleton implementation

//TODO: skeleton implementation

public class PoreBanList implements BanList {

	@Override
	public BanEntry getBanEntry(String target) {
		throw new NotImplementedException();
	}

	@Override
	public BanEntry addBan(String target, String reason, Date expires, String source) {
		throw new NotImplementedException();
	}

	@Override
	public Set<BanEntry> getBanEntries() {
		throw new NotImplementedException();
	}

	@Override
	public boolean isBanned(String target) {
		throw new NotImplementedException();
	}

	@Override
	public void pardon(String target) {
		throw new NotImplementedException();
	}
}
