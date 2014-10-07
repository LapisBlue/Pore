package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.EnderSignal;

public class PoreEnderSignal extends PoreEntity implements EnderSignal {

	//TODO: make constructor as specific as possible
	protected PoreEnderSignal(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreEnderSignal of(org.spongepowered.api.entity.Entity handle){
		return (PoreEnderSignal)PoreEntity.of(handle);
	}

}
