package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.LargeFireball;

public class PoreLargeFireball extends PoreFireball implements LargeFireball {

	//TODO: make constructor as specific as possible
	protected PoreLargeFireball(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreLargeFireball of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

}
