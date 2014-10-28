package net.amigocraft.pore.implementation.entity.minecart;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.minecart.ExplosiveMinecart;

public class PoreExplosiveMinecart extends PoreMinecart implements ExplosiveMinecart {

	//TODO: make constructor as specific as possible
	protected PoreExplosiveMinecart(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreExplosiveMinecart of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.MINECART_TNT;
	}

}
