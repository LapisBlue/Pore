package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.living.monster.Zombie;
import org.spongepowered.api.entity.living.monster.ZombiePigman;

public class PoreZombie extends PoreMonster implements org.bukkit.entity.Zombie {

	private static TypeConverter<Zombie, PoreZombie> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Zombie, PoreZombie> getZombieConverter() {
		if (converter == null) {
			converter = new TypeConverter<Zombie, PoreZombie>(
					ZombiePigman.class, PorePigZombie.getPigZombieConverter()
			){
				@Override
				protected PoreZombie convert(Zombie handle) {
					return new PoreZombie(handle);
				}
			};
		}
		return converter;
	}

	protected PoreZombie(Zombie handle) {
		super(handle);
	}

	@Override
	public Zombie getHandle() {
		return (Zombie)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreZombie of(Zombie handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.ZOMBIE;
	}

	@Override
	public boolean isBaby() {
		return getHandle().isBaby();
	}

	@Override
	public void setBaby(boolean flag) {
		if (flag)
			getHandle().setBaby();
		else
			getHandle().setAdult();
	}

	@Override
	public boolean isVillager() {
		return getHandle().isVillagerZombie();
	}

	@Override
	public void setVillager(boolean flag) {
		getHandle().setVillagerZombie(flag);
	}
}
