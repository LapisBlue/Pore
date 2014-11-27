package net.amigocraft.pore.implementation.entity;

import net.amigocraft.pore.util.converter.ItemStackConverter;
import net.amigocraft.pore.util.converter.TypeConverter;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.spongepowered.api.entity.projectile.ThrownPotion;

import java.util.Collection;

public class PoreThrownPotion extends PoreProjectile implements org.bukkit.entity.ThrownPotion {

	private static TypeConverter<ThrownPotion, PoreThrownPotion> converter;

	static TypeConverter<ThrownPotion, PoreThrownPotion> getThrownPotionConverter(){
		if (converter == null) {
			converter = new TypeConverter<ThrownPotion, PoreThrownPotion>(){
				@Override
				protected PoreThrownPotion convert(ThrownPotion handle) {
					return new PoreThrownPotion(handle);
				}
			};
		}
		return converter;
	}

	protected PoreThrownPotion(ThrownPotion handle) {
		super(handle);
	}

	@Override
	public ThrownPotion getHandle() {
		return (ThrownPotion)super.getHandle();
	}

	/**
	 * Returns a Pore wrapper for the given handle.
	 * If one exists, it will be retrieved; otherwise, a new wrapper instance will be created.
	 * @param handle The Sponge object to wrap.
	 * @return A Pore wrapper for the given Sponge object.
	 */
	public static PoreThrownPotion of(ThrownPotion handle) {
		return converter.apply(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.SPLASH_POTION;
	}

	@Override
	public Collection<PotionEffect> getEffects() {
		throw new NotImplementedException(); //TODO
	}

	@Override
	public ItemStack getItem() {
		return ItemStackConverter.of(getHandle().getItem());
	}

	@Override
	public void setItem(ItemStack item) {
		getHandle().setItem(ItemStackConverter.of(item));
	}
}
