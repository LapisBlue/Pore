package net.amigocraft.pore.implementation.entity.minecart;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.minecart.RideableMinecart;

public class PoreRideableMinecart extends PoreMinecart implements RideableMinecart {

	//TODO: make constructor as specific as possible
	protected PoreRideableMinecart(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreRideableMinecart of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.MINECART;
	}

}
