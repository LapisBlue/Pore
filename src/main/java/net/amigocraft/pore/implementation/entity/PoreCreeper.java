package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Creeper;
import org.spongepowered.api.component.attribute.Powerable;

public class PoreCreeper extends PoreMonster implements Creeper {

	//TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreCreeper(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreCreeper of(org.spongepowered.api.entity.Entity handle){
		return (PoreCreeper)PoreMonster.of(handle);
	}

	@Override
	public boolean isPowered() {
		throw new NotImplementedException();
	}

	@Override
	public void setPowered(boolean value) {
		throw new NotImplementedException();
	}
}
