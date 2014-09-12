package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Skeleton;

public class PoreSkeleton extends PoreMonster implements Skeleton {

	// TODO: Bridge

	public PoreSkeleton(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
	}

	@Override
	public SkeletonType getSkeletonType() {
		throw new NotImplementedException();
	}

	@Override
	public void setSkeletonType(SkeletonType type) {
		throw new NotImplementedException();
	}
}
