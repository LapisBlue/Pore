package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Skeleton;

public class PoreSkeleton extends PoreMonster implements Skeleton {

    // TODO: Bridge

	public PoreSkeleton(org.spongepowered.api.entity.LivingEntity handle) { //TODO: accept most specfific type
		super(handle);
	}

    @Override
    public SkeletonType getSkeletonType() {
        return null;
    }

    @Override
    public void setSkeletonType(SkeletonType type) {

    }
}
