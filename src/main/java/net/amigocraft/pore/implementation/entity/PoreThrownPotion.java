package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.util.Collection;

public class PoreThrownPotion extends PoreProjectile implements ThrownPotion {

	// TODO: Bridge

	//TODO: make constructor as specific as possible
	protected PoreThrownPotion(org.spongepowered.api.entity.Entity handle){
		super(handle);
	}

	public static PoreThrownPotion of(org.spongepowered.api.entity.Entity handle){
		return (PoreThrownPotion)PoreProjectile.of(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.SPLASH_POTION;
	}

	@Override
	public Collection<PotionEffect> getEffects() {
		throw new NotImplementedException();
	}

	@Override
	public ItemStack getItem() {
		throw new NotImplementedException();
	}

	@Override
	public void setItem(ItemStack item) {
		throw new NotImplementedException();
	}
}
