package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import net.amigocraft.pore.util.converter.entity.SkeletonConverter;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.living.monster.Skeleton;

public class PoreSkeleton extends PoreMonster implements org.bukkit.entity.Skeleton {

	private static TypeConverter<Skeleton, PoreSkeleton> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Skeleton, PoreSkeleton> getSkeletonConverter() {
		if (converter == null) {
			converter = new TypeConverter<Skeleton, PoreSkeleton>(){
				@Override
				protected PoreSkeleton convert(Skeleton handle) {
					return new PoreSkeleton(handle);
				}
			};
		}
		return converter;
	}

	protected PoreSkeleton(Skeleton handle) {
		super(handle);
	}

	@Override
	public Skeleton getHandle() {
		return (Skeleton)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreSkeleton of(Skeleton handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.SKELETON;
	}

	@Override
	public SkeletonType getSkeletonType() {
		return SkeletonConverter.of(getHandle().getSkeletonType());
	}

	@Override
	public void setSkeletonType(SkeletonType type) {
		getHandle().setSkeletonType(SkeletonConverter.of(type));
	}
}
