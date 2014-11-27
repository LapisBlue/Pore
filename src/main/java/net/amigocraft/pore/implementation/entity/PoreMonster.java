package net.amigocraft.pore.implementation.entity;

import com.google.common.collect.ImmutableMap;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.spongepowered.api.entity.living.monster.*;

public class PoreMonster extends PoreCreature implements org.bukkit.entity.Monster {

	private static TypeConverter<Monster, PoreMonster> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Monster, PoreMonster> getMonsterConverter() {
		if (converter == null) {
			converter = new TypeConverter<Monster, PoreMonster>(
					(ImmutableMap)ImmutableMap.builder()
							.put(Blaze.class, PoreBlaze.getBlazeConverter())
							.put(Creeper.class, PoreCreeper.getCreeperConverter())
							.put(Enderman.class, PoreEnderman.getEndermanConverter())
							.put(Giant.class, PoreGiant.getGiantConverter())
							.put(Silverfish.class, PoreSilverfish.getSilverfishConverter())
							.put(Skeleton.class, PoreSkeleton.getSkeletonConverter())
							.put(Spider.class, PoreSpider.getSpiderConverter())
							.put(Witch.class, PoreWitch.getWitchConverter())
							.put(Wither.class, PoreWither.getWitherConverter())
							.put(Zombie.class, PoreZombie.getZombieConverter())
							.build()
			){
				@Override
				protected PoreMonster convert(Monster handle) {
					return new PoreMonster(handle);
				}
			};
		}
		return converter;
	}

	protected PoreMonster(Monster handle) {
		super(handle);
	}

	@Override
	public Monster getHandle() {
		return (Monster)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreMonster of(Monster handle) {
		return converter.apply(handle);
	}

}
