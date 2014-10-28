package net.amigocraft.pore.implementation.entity.minecart;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.minecart.SpawnerMinecart;

public class PoreSpawnerMinecart extends PoreMinecart implements SpawnerMinecart {

	//TODO: make constructor as specific as possible
	protected PoreSpawnerMinecart(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreSpawnerMinecart of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.MINECART_MOB_SPAWNER;
	}

}
