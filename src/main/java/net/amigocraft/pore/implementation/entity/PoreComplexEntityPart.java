package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.ComplexEntityPart;
import org.bukkit.entity.EnderDragon;

public class PoreComplexEntityPart extends PoreEntity implements ComplexEntityPart {

	//TODO: Bridge

	public PoreComplexEntityPart(org.spongepowered.api.entity.Entity handle) { //TODO: accept most specfific type
		super(handle);
	}

	@Override
	public EnderDragon getParent() {
		throw new NotImplementedException();
	}
}
