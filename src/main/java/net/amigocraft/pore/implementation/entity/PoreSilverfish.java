package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.living.monster.Silverfish;

public class PoreSilverfish extends PoreMonster implements org.bukkit.entity.Silverfish {

	private static TypeConverter<Silverfish, PoreSilverfish> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Silverfish, PoreSilverfish> getSilverfishConverter() {
		if (converter == null) {
			converter = new TypeConverter<Silverfish, PoreSilverfish>(){
				@Override
				protected PoreSilverfish convert(Silverfish handle) {
					return new PoreSilverfish(handle);
				}
			};
		}
		return converter;
	}

	protected PoreSilverfish(Silverfish handle) {
		super(handle);
	}

	@Override
	public Silverfish getHandle() {
		return (Silverfish)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreSilverfish of(Silverfish handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.SILVERFISH;
	}

}
