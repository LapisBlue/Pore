package net.amigocraft.pore.impl.entity;

import net.amigocraft.pore.util.converter.HorseConverter;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.HorseInventory;
import org.spongepowered.api.entity.living.animal.Horse;

public class PoreHorse extends PoreTameable implements org.bukkit.entity.Horse {

	private static TypeConverter<Horse, PoreHorse> converter;

	@SuppressWarnings("unchecked")
	static TypeConverter<Horse, PoreHorse> getHorseConverter() {
		if (converter == null) {
			converter = new TypeConverter<Horse, PoreHorse>(){
				@Override
				protected PoreHorse convert(Horse handle) {
					return new PoreHorse(handle);
				}
			};
		}
		return converter;
	}

	protected PoreHorse(Horse handle) {
		super(handle);
	}

	@Override
	public Horse getHandle() {
		return (Horse)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreHorse of(Horse handle) {
		return converter.apply(handle);
	}

	//TODO: bridge

	@Override
	public EntityType getType(){
		return EntityType.HORSE;
	}

	@Override
	public Variant getVariant() {
		return HorseConverter.of(getHandle().getVariant());
	}

	@Override
	public void setVariant(Variant variant) {
		getHandle().setVariant(HorseConverter.of(variant));
	}

	@Override
	public Color getColor() {
		return HorseConverter.of(getHandle().getColor());
	}

	@Override
	public void setColor(Color color) {
		getHandle().setColor(HorseConverter.of(color));
	}

	@Override
	public Style getStyle() {
		return HorseConverter.of(getHandle().getStyle());
	}

	@Override
	public void setStyle(Style style) {
		getHandle().setStyle(HorseConverter.of(style));
	}

	@Override
	public boolean isCarryingChest() {
		throw new NotImplementedException();
	}

	@Override
	public void setCarryingChest(boolean chest) {
		throw new NotImplementedException();
	}

	@Override
	public int getDomestication() {
		throw new NotImplementedException();
	}

	@Override
	public void setDomestication(int level) {
		throw new NotImplementedException();
	}

	@Override
	public int getMaxDomestication() {
		throw new NotImplementedException();
	}

	@Override
	public void setMaxDomestication(int level) {
		throw new NotImplementedException();
	}

	@Override
	public double getJumpStrength() {
		throw new NotImplementedException();
	}

	@Override
	public void setJumpStrength(double strength) {
		throw new NotImplementedException();
	}

	@Override
	public HorseInventory getInventory() {
		throw new NotImplementedException();
	}

}
