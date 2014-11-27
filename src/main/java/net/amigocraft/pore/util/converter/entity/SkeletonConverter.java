package net.amigocraft.pore.util.converter.entity;

import com.google.common.collect.ImmutableBiMap;
import org.bukkit.entity.Skeleton;
import org.spongepowered.api.entity.living.meta.SkeletonType;
import org.spongepowered.api.entity.living.meta.SkeletonTypes;

public class SkeletonConverter {

	private static ImmutableBiMap<Skeleton.SkeletonType, SkeletonType> map =
			ImmutableBiMap.<Skeleton.SkeletonType, SkeletonType>builder()
					.put(Skeleton.SkeletonType.NORMAL,  SkeletonTypes.NORMAL)
					.put(Skeleton.SkeletonType.WITHER,  SkeletonTypes.WITHER)
					.build();

	public static SkeletonType of(Skeleton.SkeletonType type){
		return map.get(type);
	}

	public static Skeleton.SkeletonType of(SkeletonType type){
		return map.inverse().get(type);
	}

	// ░░░░░░░░░░░░▄▐
	// ░░░░░░▄▄▄░░▄██▄
	// ░░░░░▐▀█▀▌░░░░▀█▄
	// ░░░░░▐█▄█▌░░░░░░▀█▄
	// ░░░░░░▀▄▀░░░▄▄▄▄▄▀▀
	// ░░░░▄▄▄██▀▀▀▀
	// ░░░█▀▄▄▄█░▀▀
	// ░░░▌░▄▄▄▐▌▀▀▀
	// ▄░▐░░░▄▄░█░▀▀
	// ▀█▌░░░▄░▀█▀░▀
	// ░░░░░░░▄▄▐▌▄▄
	// ░░░░░░░▀███▀█░▄
	// ░░░░░░▐▌▀▄▀▄▀▐▄
	// ░░░░░░▐▀░░░░░░▐▌
	// ░░░░░░█░░░░░░░░█
	// ░░░░░▐▌░░░░░░░░░█
	// ░░░░░█░░░░░░░░░░▐▌

}
