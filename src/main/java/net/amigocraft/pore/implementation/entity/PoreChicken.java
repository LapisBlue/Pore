package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.EntityType;

public class PoreChicken extends PoreAnimals implements Chicken {

	private static TypeConverter<org.spongepowered.api.entity.living.animal.Chicken, PoreChicken> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<org.spongepowered.api.entity.living.animal.Chicken, PoreChicken> getChickenConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.entity.living.animal.Chicken, PoreChicken>(){
				@Override
				protected PoreChicken convert(org.spongepowered.api.entity.living.animal.Chicken handle) {
					return new PoreChicken(handle);
				}
			};
		}
		return converter;
	}

	protected PoreChicken(org.spongepowered.api.entity.living.animal.Chicken handle) {
		super(handle);
	}

	@Override
	public org.spongepowered.api.entity.living.animal.Chicken getHandle() {
		return (org.spongepowered.api.entity.living.animal.Chicken)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreChicken of(org.spongepowered.api.entity.living.animal.Chicken handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.CHICKEN;
	}

}
