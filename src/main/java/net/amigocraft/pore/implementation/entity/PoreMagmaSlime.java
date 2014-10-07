package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.MagmaCube;

public class PoreMagmaSlime extends PoreSlime implements MagmaCube {

	//TODO: make constructor as specific as possible
	protected PoreMagmaSlime(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreMagmaSlime of(org.spongepowered.api.entity.Entity handle){
		return (PoreMagmaSlime)PoreSlime.of(handle);
	}

}
