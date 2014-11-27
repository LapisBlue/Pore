package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.ComplexEntityPart;
import org.bukkit.entity.ComplexLivingEntity;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.living.complex.ComplexLivingPart;
import org.spongepowered.api.entity.living.complex.EnderDragonPart;

public class PoreComplexEntityPart extends PoreEntity implements ComplexEntityPart {

	private static TypeConverter<ComplexLivingPart, PoreComplexEntityPart> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<ComplexLivingPart, PoreComplexEntityPart> getComplexEntityPartConverter() {
		if (converter == null) {
			converter = new TypeConverter<ComplexLivingPart, PoreComplexEntityPart>(
					EnderDragonPart.class, PoreEnderDragonPart.getEnderDragonPartConverter()
			){
				@Override
				protected PoreComplexEntityPart convert(ComplexLivingPart handle) {
					return new PoreComplexEntityPart(handle);
				}
			};
		}
		return converter;
	}

	protected PoreComplexEntityPart(ComplexLivingPart handle) {
		super(handle);
	}

	@Override
	public ComplexLivingPart getHandle() {
		return (ComplexLivingPart)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreComplexEntityPart of(ComplexLivingPart handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.COMPLEX_PART;
	}

	@Override
	public ComplexLivingEntity getParent() {
		return PoreComplexLivingEntity.of(getHandle().getParent());
	}
}
