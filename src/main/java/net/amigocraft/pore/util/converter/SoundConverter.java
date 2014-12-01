package net.amigocraft.pore.util.converter;

import com.google.common.collect.ImmutableBiMap;
import org.bukkit.Sound;
import org.spongepowered.api.effect.Sounds;

public class SoundConverter {

	private static final ImmutableBiMap<Sound, org.spongepowered.api.effect.Sound> map;

	static {
		ImmutableBiMap.Builder<Sound, org.spongepowered.api.effect.Sound> builder = ImmutableBiMap.builder();
		for (Sound sound : Sound.values()) {
			builder.put(sound, Sounds.getByName(sound.name()).get());
		}
		map = builder.build();
	}

	public static org.spongepowered.api.effect.Sound of(Sound sound){
		return map.get(sound);
	}

	public static Sound of(org.spongepowered.api.effect.Sound sound) {
		return map.inverse().get(sound);
	}
}
