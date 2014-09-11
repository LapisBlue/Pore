package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.MagmaCube;

public class PoreMagmaSlime extends PoreSlime implements MagmaCube {

    // TODO: Bridge

	public PoreMagmaSlime(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
	}

}
