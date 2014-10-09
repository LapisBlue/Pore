package net.amigocraft.pore.implementation.inventory.meta;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

// TODO: bridge

// TODO: bridge

public class PorePotionMeta extends PoreItemMeta implements PotionMeta {

	@Override
	public boolean hasCustomEffects() {
		throw new NotImplementedException();
	}

	@Override
	public List<PotionEffect> getCustomEffects() {
		throw new NotImplementedException();
	}

	@Override
	public boolean addCustomEffect(PotionEffect effect, boolean overwrite) {
		throw new NotImplementedException();
	}

	@Override
	public boolean removeCustomEffect(PotionEffectType type) {
		throw new NotImplementedException();
	}

	@Override
	public boolean hasCustomEffect(PotionEffectType type) {
		throw new NotImplementedException();
	}

	@Override
	public boolean setMainEffect(PotionEffectType type) {
		throw new NotImplementedException();
	}

	@Override
	public boolean clearCustomEffects() {
		throw new NotImplementedException();
	}

	@Override
	public PotionMeta clone() {
		throw new NotImplementedException();
	}

}