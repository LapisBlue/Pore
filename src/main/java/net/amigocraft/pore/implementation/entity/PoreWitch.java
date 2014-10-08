package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Witch;

public class PoreWitch extends PoreMonster implements Witch {

	//TODO: make constructor as specific as possible
	protected PoreWitch(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreWitch of(org.spongepowered.api.entity.Entity handle){
		return (PoreWitch)PoreMonster.of(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.WITCH;
	}

}
