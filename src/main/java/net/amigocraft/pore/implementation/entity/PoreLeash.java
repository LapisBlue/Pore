package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.LeashHitch;

public class PoreLeash extends PoreHanging implements LeashHitch {

    // TODO: Bridge

	public PoreLeash(org.spongepowered.api.entity.Entity handle) { //TODO: accept most specfific type
		super(handle);
	}

}
