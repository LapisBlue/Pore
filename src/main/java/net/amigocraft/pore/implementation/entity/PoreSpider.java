package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.living.monster.CaveSpider;
import org.spongepowered.api.entity.living.monster.Spider;

public class PoreSpider extends PoreMonster implements org.bukkit.entity.Spider {

	private static TypeConverter<Spider, PoreSpider> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Spider, PoreSpider> getSpiderConverter() {
		if (converter == null) {
			converter = new TypeConverter<Spider, PoreSpider>(
					CaveSpider.class, PoreCaveSpider.getCaveSpiderConverter()
			){
				@Override
				protected PoreSpider convert(Spider handle) {
					return new PoreSpider(handle);
				}
			};
		}
		return converter;
	}

	protected PoreSpider(Spider handle) {
		super(handle);
	}

	@Override
	public Spider getHandle() {
		return (Spider)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreSpider of(Spider handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.SPIDER;
	}

}
