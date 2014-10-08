package net.amigocraft.pore.implementation.entity.minecart;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.minecart.SpawnerMinecart;

public class PoreSpawnerMinecart extends PoreMinecart implements SpawnerMinecart {

	//TODO: make constructor as specific as possible
	protected PoreSpawnerMinecart(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreSpawnerMinecart of(org.spongepowered.api.entity.Entity handle){
		return (PoreSpawnerMinecart) PoreMinecart.of(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.MINECART_MOB_SPAWNER;
	}

}
