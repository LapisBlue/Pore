package net.amigocraft.pore.implementation.potion;

import java.util.Collection;

import org.bukkit.potion.PotionBrewer;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PorePotionBrewer implements PotionBrewer {

	@Override
	public PotionEffect createEffect(PotionEffectType potion, int duration, int amplifier) {
		return null; // TODO: Bridge
	}

	@Override
	public Collection<PotionEffect> getEffectsFromDamage(int damage) {
		return null; // TODO: Bridge
	}

}
