package net.amigocraft.pore.implementation.entity;

import com.google.common.collect.ImmutableMap;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Creature;
import org.spongepowered.api.entity.living.Tameable;
import org.spongepowered.api.entity.living.animal.Animal;
import org.spongepowered.api.entity.living.animal.Ocelot;
import org.spongepowered.api.entity.living.animal.Wolf;

public class PoreTameable extends PoreAnimals implements org.bukkit.entity.Tameable, Creature {

	//TODO: hierarchy does not match Sponge's
	// Bukkit: Tameable -> Animals -> Ageable -> Creature -> LivingEntity -> Entity
	// Sponge: Tameable -> Agent -> Living -> Entity

	private static TypeConverter<Tameable, PoreTameable> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Tameable, PoreTameable> getTameableConverter() {
		if (converter == null) {
			converter = new TypeConverter<Tameable, PoreTameable>(
					(ImmutableMap)ImmutableMap.builder()
							.put(Ocelot.class, PoreOcelot.getOcelotConverter())
							.put(Wolf.class, PoreWolf.getWolfConverter())
							.build()
			){
				@Override
				protected PoreTameable convert(Tameable handle) {
					return new PoreTameable(handle);
				}
			};
		}
		return converter;
	}

	protected PoreTameable(Tameable handle) {
		super((Animal) handle);
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreTameable of(Tameable handle) {
		if (handle instanceof Animal) {
			return converter.apply(handle);
		}
		throw new UnsupportedOperationException();
	}

	private Tameable getTameable() {
		return (Tameable) getHandle();
	}

	@Override
	public boolean isTamed() {
		return getTameable().isTamed();
	}

	@Override
	public void setTamed(boolean tame) {
		getTameable().setTamed(tame);
	}

	@Override
	public AnimalTamer getOwner() {
		return PoreAnimalTamer.of(getTameable().getOwner().get());
	}

	@Override
	public void setOwner(AnimalTamer tamer) {
		getTameable().setOwner(((PoreAnimalTamer)tamer).getHandle());
	}
}
