package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.LeashHitch;

public class PoreLeash extends PoreHanging implements LeashHitch {

	//TODO: make constructor as specific as possible
	protected PoreLeash(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreLeash of(org.spongepowered.api.entity.Entity handle){
		return (PoreLeash)PoreHanging.of(handle);
	}

}
