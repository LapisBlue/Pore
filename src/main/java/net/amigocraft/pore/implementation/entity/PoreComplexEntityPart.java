package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.ComplexEntityPart;
import org.bukkit.entity.EnderDragon;

public class PoreComplexEntityPart extends PoreEntity implements ComplexEntityPart {

	//TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreComplexEntityPart(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreComplexEntityPart of(org.spongepowered.api.entity.Entity handle){
		return (PoreComplexEntityPart)PoreEntity.of(handle);
	}

	@Override
	public EnderDragon getParent() {
		throw new NotImplementedException(); //TODO: should we store this as a global?
	}
}
