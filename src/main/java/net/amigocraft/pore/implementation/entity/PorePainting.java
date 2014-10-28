package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Art;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Painting;

public class PorePainting extends PoreHanging implements Painting {

	// TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PorePainting(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PorePainting of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.PAINTING;
	}

	@Override
	public Art getArt() {
		throw new NotImplementedException();
	}

	@Override
	public boolean setArt(Art art) {
		throw new NotImplementedException();
	}

	@Override
	public boolean setArt(Art art, boolean force) {
		throw new NotImplementedException();
	}
}
