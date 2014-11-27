package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EnderSignal;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.projectile.EyeOfEnder;

public class PoreEnderSignal extends PoreEntity implements EnderSignal {

	private static TypeConverter<EyeOfEnder, PoreEnderSignal> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<EyeOfEnder, PoreEnderSignal> getEnderSignalConverter() {
		if (converter == null) {
			converter = new TypeConverter<EyeOfEnder, PoreEnderSignal>(){
				@Override
				protected PoreEnderSignal convert(EyeOfEnder handle) {
					return new PoreEnderSignal(handle);
				}
			};
		}
		return converter;
	}

	protected PoreEnderSignal(EyeOfEnder handle) {
		super(handle);
	}

	@Override
	public EyeOfEnder getHandle() {
		return (EyeOfEnder)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreEnderSignal of(EyeOfEnder handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.ENDER_SIGNAL;
	}

}
