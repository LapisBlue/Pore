package net.amigocraft.pore.util.converter;

import com.google.common.collect.ImmutableBiMap;
import org.bukkit.DyeColor;
import org.spongepowered.api.entity.living.meta.DyeColors;

public class DyeColorConverter {

	private static ImmutableBiMap<org.bukkit.DyeColor, org.spongepowered.api.entity.living.meta.DyeColor> map =
			ImmutableBiMap.<org.bukkit.DyeColor, org.spongepowered.api.entity.living.meta.DyeColor>builder()
					.put(DyeColor.BLACK,        DyeColors.BLACK)
					.put(DyeColor.BLUE,         DyeColors.BLUE)
					.put(DyeColor.BROWN,        DyeColors.BROWN)
					.put(DyeColor.CYAN,         DyeColors.CYAN)
					.put(DyeColor.GRAY,         DyeColors.GRAY)
					.put(DyeColor.GREEN,        DyeColors.GREEN)
					.put(DyeColor.LIGHT_BLUE,   DyeColors.LIGHT_BLUE)
					.put(DyeColor.LIME,         DyeColors.LIME)
					.put(DyeColor.MAGENTA,      DyeColors.MAGENTA)
					.put(DyeColor.ORANGE,       DyeColors.ORANGE)
					.put(DyeColor.PINK,         DyeColors.PINK)
					.put(DyeColor.PURPLE,       DyeColors.PURPLE)
					.put(DyeColor.RED,          DyeColors.RED)
					.put(DyeColor.SILVER,       DyeColors.SILVER)
					.put(DyeColor.WHITE,        DyeColors.WHITE)
					.put(DyeColor.YELLOW,       DyeColors.YELLOW)
					.build();

	public static org.spongepowered.api.entity.living.meta.DyeColor of(org.bukkit.DyeColor color){
		return map.get(color);
	}

	public static org.bukkit.DyeColor of(org.spongepowered.api.entity.living.meta.DyeColor color){
		return map.inverse().get(color);
	}

}
