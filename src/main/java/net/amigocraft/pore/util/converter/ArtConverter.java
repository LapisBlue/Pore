package net.amigocraft.pore.util.converter;

import com.google.common.collect.ImmutableBiMap;
import org.bukkit.Art;
import org.spongepowered.api.entity.hanging.art.Arts;

public class ArtConverter {

	private static ImmutableBiMap<org.bukkit.Art, org.spongepowered.api.entity.hanging.art.Art> map =
			ImmutableBiMap.<org.bukkit.Art, org.spongepowered.api.entity.hanging.art.Art>builder()
					.put(Art.ALBAN,             Arts.ALBAN)
					.put(Art.AZTEC,             Arts.AZTEC)
					.put(Art.AZTEC2,            Arts.AZTEC2)
					.put(Art.BOMB,              Arts.BOMB)
					.put(Art.BURNINGSKULL,      Arts.BURNING_SKULL)
					.put(Art.COURBET,           Arts.COURBET)
					.put(Art.CREEBET,           Arts.CREEBET)
					.put(Art.DONKEYKONG,        Arts.DONKEY_KONG)
					.put(Art.FIGHTERS,          Arts.FIGHTERS)
					.put(Art.GRAHAM,            Arts.GRAHAM)
					.put(Art.KEBAB,             Arts.KEBAB)
					.put(Art.MATCH,             Arts.MATCH)
					.put(Art.PIGSCENE,          Arts.PIGSCENE)
					.put(Art.PLANT,             Arts.PLANT)
					.put(Art.POINTER,           Arts.POINTER)
					.put(Art.POOL,              Arts.POOL)
					.put(Art.SEA,               Arts.SEA)
					.put(Art.SKELETON,          Arts.SKELETON)
					.put(Art.SKULL_AND_ROSES,   Arts.SKULL_AND_ROSES)
					.put(Art.STAGE,             Arts.STAGE)
					.put(Art.SUNSET,            Arts.SUNSET)
					.put(Art.VOID,              Arts.VOID)
					.put(Art.WANDERER,          Arts.WANDERER)
					.put(Art.WASTELAND,         Arts.WASTELAND)
					.put(Art.WITHER,            Arts.WITHER)
					.build();

	public static org.spongepowered.api.entity.hanging.art.Art of(org.bukkit.Art art){
		return map.get(art);
	}

	public static org.bukkit.Art of(org.spongepowered.api.entity.hanging.art.Art art){
		return map.inverse().get(art);
	}

}
