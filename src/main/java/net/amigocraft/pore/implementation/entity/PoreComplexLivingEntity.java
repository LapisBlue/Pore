package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.ComplexEntityPart;
import org.bukkit.entity.ComplexLivingEntity;
import org.spongepowered.api.entity.living.complex.ComplexLiving;
import org.spongepowered.api.entity.living.complex.ComplexLivingPart;
import org.spongepowered.api.entity.living.complex.EnderDragon;

import java.util.HashSet;
import java.util.Set;

public class PoreComplexLivingEntity extends PoreLivingEntity implements ComplexLivingEntity {

	private static TypeConverter<ComplexLiving, PoreComplexLivingEntity> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<ComplexLiving, PoreComplexLivingEntity> getComplexLivingEntityConverter() {
		if (converter == null) {
			converter = new TypeConverter<ComplexLiving, PoreComplexLivingEntity>(
					EnderDragon.class, PoreEnderDragon.getEnderDragonConverter()
			){
				@Override
				protected PoreComplexLivingEntity convert(ComplexLiving handle) {
					return new PoreComplexLivingEntity(handle);
				}
			};
		}
		return converter;
	}

	protected PoreComplexLivingEntity(ComplexLiving handle) {
		super(handle);
	}

	@Override
	public ComplexLiving getHandle() {
		return (ComplexLiving)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreComplexLivingEntity of(ComplexLiving handle) {
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
