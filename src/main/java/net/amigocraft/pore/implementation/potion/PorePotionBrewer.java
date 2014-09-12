package net.amigocraft.pore.implementation.potion;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.potion.PotionBrewer;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Collection;

// TODO: Bridge
public class PorePotionBrewer implements PotionBrewer {

	@Override
	public PotionEffect createEffect(PotionEffectType potion, int duration, int amplifier) {
		throw new NotImplementedException();
	}

	@Override
	public Collection<PotionEffect> getEffectsFromDamage(int damage) {
		throw new NotImplementedException();
	}

}
