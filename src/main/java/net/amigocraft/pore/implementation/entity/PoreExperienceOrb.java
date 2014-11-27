package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.ExperienceOrb;

public class PoreExperienceOrb extends PoreEntity implements org.bukkit.entity.ExperienceOrb {

	private static TypeConverter<ExperienceOrb, PoreExperienceOrb> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<ExperienceOrb, PoreExperienceOrb> getExperienceOrbConverter() {
		if (converter == null) {
			converter = new TypeConverter<ExperienceOrb, PoreExperienceOrb>(){
				@Override
				protected PoreExperienceOrb convert(ExperienceOrb handle) {
					return new PoreExperienceOrb(handle);
				}
			};
		}
		return converter;
	}

	protected PoreExperienceOrb(ExperienceOrb handle) {
		super(handle);
	}

	@Override
	public ExperienceOrb getHandle() {
		return (ExperienceOrb)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreExperienceOrb of(ExperienceOrb handle) {
		return converter.apply(handle);
	}

	//TODO: bridge

	@Override
	public EntityType getType(){
		return EntityType.EXPERIENCE_ORB;
	}

	@Override
	public int getExperience() {
		return getHandle().getExperience();
	}

	@Override
	public void setExperience(int value) {
		getHandle().setExperience(value);
	}
}
