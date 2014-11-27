package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.ProfessionConverter;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.living.villager.Careers;
import org.spongepowered.api.entity.living.villager.Villager;

public class PoreVillager extends PoreAgeable implements org.bukkit.entity.Villager {

	private static TypeConverter<Villager, PoreVillager> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Villager, PoreVillager> getVillagerConverter() {
		if (converter == null) {
			converter = new TypeConverter<Villager, PoreVillager>(){
				@Override
				protected PoreVillager convert(Villager handle) {
					return new PoreVillager(handle);
				}
			};
		}
		return converter;
	}

	protected PoreVillager(Villager handle) {
		super(handle);
	}

	@Override
	public Villager getHandle() {
		return (Villager)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreVillager of(Villager handle) {
		return converter.apply(handle);
	}

	//TODO: bridge

	@Override
	public EntityType getType(){
		return EntityType.VILLAGER;
	}

	@Override
	public Profession getProfession() {
		return ProfessionConverter.of(getHandle().getCareer().getProfession());
	}

	@Override
	public void setProfession(Profession profession) {
		//TODO: not really sure what to do here
		getHandle().setCareer(Careers.getCareersForProfession(ProfessionConverter.of(profession)).get(0));
	}
}
