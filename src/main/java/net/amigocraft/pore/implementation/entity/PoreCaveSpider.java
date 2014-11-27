package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.EntityType;

public class PoreCaveSpider extends PoreSpider implements CaveSpider {

	private static TypeConverter<org.spongepowered.api.entity.living.monster.CaveSpider, PoreCaveSpider> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<org.spongepowered.api.entity.living.monster.CaveSpider, PoreCaveSpider> getCaveSpiderConverter() {
		if (converter == null) {
			converter = new TypeConverter<org.spongepowered.api.entity.living.monster.CaveSpider, PoreCaveSpider>(){
				@Override
				protected PoreCaveSpider convert(org.spongepowered.api.entity.living.monster.CaveSpider handle) {
					return new PoreCaveSpider(handle);
				}
			};
		}
		return converter;
	}

	protected PoreCaveSpider(org.spongepowered.api.entity.living.monster.CaveSpider handle) {
		super(handle);
	}

	@Override
	public org.spongepowered.api.entity.living.monster.CaveSpider getHandle() {
		return (org.spongepowered.api.entity.living.monster.CaveSpider)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreCaveSpider of(org.spongepowered.api.entity.living.monster.CaveSpider handle) {
		return converter.apply(handle);
	}

	//TODO: bridge

	@Override
	public EntityType getType(){
		return EntityType.CAVE_SPIDER;
	}

}
