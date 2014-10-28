package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.ComplexEntityPart;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.EntityType;

public class PoreComplexEntityPart extends PoreEntity implements ComplexEntityPart {

	//TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreComplexEntityPart(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreComplexEntityPart of(org.spongepowered.api.entity.Entity handle){
		throw new NotImplementedException();
	}

	@Override
	public EntityType getType(){
		return EntityType.COMPLEX_PART;
	}

	@Override
	public EnderDragon getParent() {
		throw new NotImplementedException(); //TODO: should we store this as a global?
	}
}
