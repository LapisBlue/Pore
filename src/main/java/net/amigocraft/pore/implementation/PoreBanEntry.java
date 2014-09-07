package net.amigocraft.pore.implementation;

import org.bukkit.BanEntry;

import java.util.Date;

public class PoreBanEntry implements BanEntry {

	@Override
	public String getTarget(){
		return null; //TODO: bridge
	}

	@Override
	public Date getCreated(){
		return null; //TODO: bridge
	}

	@Override
	public void setCreated(Date created){
		//TODO: bridge
	}

	@Override
	public String getSource(){
		return null; //TODO: bridge
	}

	@Override
	public void setSource(String source){
		//TODO: bridge
	}

	@Override
	public Date getExpiration(){
		return null; //TODO: bridge
	}

	@Override
	public void setExpiration(Date expiration){
		//TODO: bridge
	}

	@Override
	public String getReason(){
		return null; //TODO: bridge
	}

	@Override
	public void setReason(String reason){
		//TODO: bridge
	}

	@Override
	public void save(){
		//TODO: bridge
	}
}
