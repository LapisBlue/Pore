package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Cow;

public class PoreCow extends PoreAnimals implements Cow {

	//TODO: Bridge

	public PoreCow(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
	}

}
