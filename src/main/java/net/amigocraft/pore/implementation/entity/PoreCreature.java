package net.amigocraft.pore.implementation.entity;

import com.google.common.collect.ImmutableMap;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Creature;
import org.bukkit.entity.LivingEntity;
import org.spongepowered.api.entity.living.Ageable;
import org.spongepowered.api.entity.living.Agent;
import org.spongepowered.api.entity.living.golem.Golem;
import org.spongepowered.api.entity.living.monster.Monster;

public class PoreCreature extends PoreLivingEntity implements Creature {

	private static TypeConverter<Agent, PoreCreature> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Agent, PoreCreature> getCreatureConverter() {
		if (converter == null) {
			converter = new TypeConverter<Agent, PoreCreature>(
					(ImmutableMap)ImmutableMap.builder() // generified for simplicity and readability
							.put(Ageable.class, PoreAgeable.getAgeableConverter())
							.put(Golem.class, PoreGolem.getGolemConverter())
							.put(Monster.class, PoreMonster.getMonsterConverter())
							//.put(Agent.class, PoreWaterMob.getWaterMobConverter())
							.build()
			){
				@Override
				protected PoreCreature convert(Agent handle) {
					return new PoreCreature(handle);
				}
			};
		}
		return converter;
	}

	protected PoreCreature(Agent handle) {
		super(handle);
	}

	@Override
	public Agent getHandle() {
		return (Agent)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreCreature of(Agent handle) {
		return converter.apply(handle);
	}

	@Override
	public void setTarget(LivingEntity target) {
		throw new NotImplementedException();
	}

	@Override
	public LivingEntity getTarget() {
		throw new NotImplementedException();
	}
}
