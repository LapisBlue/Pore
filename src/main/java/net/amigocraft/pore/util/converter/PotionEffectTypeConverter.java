package net.amigocraft.pore.util.converter;

import com.google.common.collect.ImmutableBiMap;
import org.bukkit.potion.PotionEffectType;
import org.spongepowered.api.potion.PotionEffectTypes;

public class PotionEffectTypeConverter {

	private static ImmutableBiMap<org.bukkit.potion.PotionEffectType, org.spongepowered.api.potion.PotionEffectType> map =
			ImmutableBiMap
					.<PotionEffectType, org.spongepowered.api.potion.PotionEffectType>builder()
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

	public static org.spongepowered.api.potion.PotionEffectType of(org.bukkit.potion.PotionEffectType type){
		return map.get(type);
	}

	public static org.bukkit.potion.PotionEffectType of(org.spongepowered.api.potion.PotionEffectType type){
		return map.inverse().get(type);
	}

}
