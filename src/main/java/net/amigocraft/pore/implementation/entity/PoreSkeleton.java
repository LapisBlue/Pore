package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Skeleton;

public class PoreSkeleton extends PoreMonster implements Skeleton {

	// TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreSkeleton(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreSkeleton of(org.spongepowered.api.entity.Entity handle){
		return (PoreSkeleton)PoreMonster.of(handle);
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
