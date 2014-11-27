package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.TypeConverter;
import net.amigocraft.pore.util.converter.ArtConverter;
import org.bukkit.Art;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.hanging.Painting;

public class PorePainting extends PoreHanging implements org.bukkit.entity.Painting {

	private static TypeConverter<Painting, PorePainting> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Painting, PorePainting> getPaintingConverter() {
		if (converter == null) {
			converter = new TypeConverter<Painting, PorePainting>(){
				@Override
				protected PorePainting convert(Painting handle) {
					return new PorePainting(handle);
				}
			};
		}
		return converter;
	}

	protected PorePainting(Painting handle) {
		super(handle);
	}

	@Override
	public Painting getHandle() {
		return (Painting)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PorePainting of(Painting handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.PAINTING;
	}

	@Override
	public Art getArt() {
		return ArtConverter.of(getHandle().getArt());
	}

	@Override
	public boolean setArt(Art art) {
		return setArt(art, false);
	}

	@Override
	public boolean setArt(Art art, boolean force) {
		getHandle().setArt(ArtConverter.of(art));
		return true; //TODO
	}
}
