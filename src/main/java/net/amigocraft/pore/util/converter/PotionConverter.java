package net.amigocraft.pore.util.converter;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.spongepowered.api.potion.PotionEffectTypes;

public class PotionConverter {

	private static BiMap<PotionEffectType, org.spongepowered.api.potion.PotionEffectType> TYPES =
			ImmutableBiMap.<PotionEffectType, org.spongepowered.api.potion.PotionEffectType>builder()
					.put(PotionEffectType.SPEED,                PotionEffectTypes.SPEED)
					.put(PotionEffectType.SLOW,                 PotionEffectTypes.SLOWNESS)
					.put(PotionEffectType.FAST_DIGGING,         PotionEffectTypes.HASTE)
					.put(PotionEffectType.SLOW_DIGGING,         PotionEffectTypes.MINING_FATIGUE)
					.put(PotionEffectType.INCREASE_DAMAGE,      PotionEffectTypes.STRENGTH)
					.put(PotionEffectType.HEAL,                 PotionEffectTypes.INSTANT_HEALTH)
					.put(PotionEffectType.HARM,                 PotionEffectTypes.INSTANT_DAMAGE)
					.put(PotionEffectType.JUMP,                 PotionEffectTypes.JUMP_BOOST)
					.put(PotionEffectType.CONFUSION,            PotionEffectTypes.NAUSEA)
					.put(PotionEffectType.REGENERATION,         PotionEffectTypes.REGENERATION)
					.put(PotionEffectType.DAMAGE_RESISTANCE,    PotionEffectTypes.RESISTANCE)
					.put(PotionEffectType.FIRE_RESISTANCE,      PotionEffectTypes.FIRE_RESISTANCE)
					.put(PotionEffectType.WATER_BREATHING,      PotionEffectTypes.WATER_BREATHING)
					.put(PotionEffectType.INVISIBILITY,         PotionEffectTypes.INVISIBILITY)
					.put(PotionEffectType.BLINDNESS,            PotionEffectTypes.BLINDNESS)
					.put(PotionEffectType.NIGHT_VISION,         PotionEffectTypes.NIGHT_VISION)
					.put(PotionEffectType.HUNGER,               PotionEffectTypes.HUNGER)
					.put(PotionEffectType.WEAKNESS,             PotionEffectTypes.WEAKNESS)
					.put(PotionEffectType.POISON,               PotionEffectTypes.POISON)
					.put(PotionEffectType.WITHER,               PotionEffectTypes.WITHER)
					.put(PotionEffectType.HEALTH_BOOST,         PotionEffectTypes.HEALTH_BOOST)
					.put(PotionEffectType.ABSORPTION,           PotionEffectTypes.ABSORPTION)
					.put(PotionEffectType.SATURATION,           PotionEffectTypes.SATURATION)
					.build();

	public static org.spongepowered.api.potion.PotionEffectType of(PotionEffectType type) {
		return TYPES.get(type);
	}

	public static PotionEffectType of(org.spongepowered.api.potion.PotionEffectType type){
		return TYPES.inverse().get(type);
	}

	public static PotionEffect of(org.spongepowered.api.potion.PotionEffect effect) {
		return new PotionEffect(of(effect.getType()), effect.getDuration(), effect.getAmplifier(), effect.isAmbient());
	}

	public static org.spongepowered.api.potion.PotionEffect of(PotionEffect effect) {
		throw new NotImplementedException(); // TODO
	}
}
