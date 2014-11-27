package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.living.monster.Witch;

public class PoreWitch extends PoreMonster implements org.bukkit.entity.Witch {

	private static TypeConverter<Witch, PoreWitch> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Witch, PoreWitch> getWitchConverter() {
		if (converter == null) {
			converter = new TypeConverter<Witch, PoreWitch>(){
				@Override
				protected PoreWitch convert(Witch handle) {
					return new PoreWitch(handle);
				}
			};
		}
		return converter;
	}

	protected PoreWitch(Witch handle) {
		super(handle);
	}

	@Override
	public Witch getHandle() {
		return (Witch)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreWitch of(Witch handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.WITCH;
	}

}
