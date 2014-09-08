package net.amigocraft.pore.implementation.potion;

import java.util.Collection;

import org.bukkit.potion.PotionBrewer;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

// TODO: Bridge

public class PorePotionBrewer implements PotionBrewer {

	@Override
	public PotionEffect createEffect(PotionEffectType potion, int duration, int amplifier) {
		return null;
	}

	@Override
	public Collection<PotionEffect> getEffectsFromDamage(int damage) {
		return null;
	}

}
