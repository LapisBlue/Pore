package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Cow;
import org.bukkit.entity.EntityType;

public class PoreCow extends PoreAnimals implements Cow {

	//TODO: make constructor as specific as possible
	protected PoreCow(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreCow of(org.spongepowered.api.entity.Entity handle){
		return (PoreCow)PoreAnimals.of(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.COW;
	}

}
