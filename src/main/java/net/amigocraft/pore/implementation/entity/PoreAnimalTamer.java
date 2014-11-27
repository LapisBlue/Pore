package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.PoreWrapper;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.AnimalTamer;
import org.spongepowered.api.entity.Tamer;

import java.util.UUID;

public class PoreAnimalTamer extends PoreWrapper<Tamer> implements AnimalTamer {

	private static TypeConverter<Tamer, PoreAnimalTamer> converter;

	static TypeConverter<Tamer, PoreAnimalTamer> getHumanEntityConverter() {
		if (converter == null) {
			converter = new TypeConverter<Tamer, PoreAnimalTamer>(
			) {
				@Override
				protected PoreAnimalTamer convert(Tamer handle) {
					return new PoreAnimalTamer(handle);
				}
			};
		}

		return converter;
	}

	protected PoreAnimalTamer(Tamer handle) {
		super(handle);
	}

	@Override
	public Tamer getHandle() {
		return (Tamer)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreAnimalTamer of(Tamer handle) {
		return getHumanEntityConverter().apply(handle);
	}

	@Override
	public String getName() {
		return getHandle().getName();
	}

	@Override
	public UUID getUniqueId(){
		return getHandle().getUniqueId();
	}
}
