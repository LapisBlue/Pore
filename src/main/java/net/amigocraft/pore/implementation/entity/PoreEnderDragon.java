package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.ComplexEntityPart;
import org.bukkit.entity.EnderDragon;
import org.spongepowered.api.entity.living.complex.ComplexLivingPart;

import java.util.HashSet;
import java.util.Set;

public class PoreEnderDragon extends PoreComplexLivingEntity implements EnderDragon {

	private static TypeConverter<org.spongepowered.api.entity.living.complex.EnderDragon, PoreEnderDragon> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<org.spongepowered.api.entity.living.complex.EnderDragon, PoreEnderDragon>
	getEnderDragonConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.entity.living.complex.EnderDragon, PoreEnderDragon>(){
				@Override
				protected PoreEnderDragon convert(org.spongepowered.api.entity.living.complex.EnderDragon handle) {
					return new PoreEnderDragon(handle);
				}
			};
		}
		return converter;
	}

	protected PoreEnderDragon(org.spongepowered.api.entity.living.complex.EnderDragon handle) {
		super(handle);
	}

	@Override
	public org.spongepowered.api.entity.living.complex.EnderDragon getHandle() {
		return (org.spongepowered.api.entity.living.complex.EnderDragon)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreEnderDragon of(org.spongepowered.api.entity.living.complex.EnderDragon handle) {
		return converter.apply(handle);
	}

	@Override
	public Set<ComplexEntityPart> getParts() {
		Set<ComplexEntityPart> parts = new HashSet<ComplexEntityPart>();
		for (ComplexLivingPart part : getHandle().getParts()){
			parts.add(PoreComplexEntityPart.of(part));
		}
		return parts;
	}
}
