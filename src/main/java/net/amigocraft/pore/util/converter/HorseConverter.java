package net.amigocraft.pore.util.converter;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import org.bukkit.entity.Horse;
import org.spongepowered.api.entity.living.meta.*;

public class HorseConverter {

	private static final BiMap<Horse.Variant, HorseVariant> VARIANTS = ImmutableBiMap.<Horse.Variant, HorseVariant>builder()
			.put(Horse.Variant.HORSE, HorseVariants.HORSE)
			.put(Horse.Variant.DONKEY, HorseVariants.DONKEY)
			.put(Horse.Variant.MULE, HorseVariants.MULE)
			.put(Horse.Variant.UNDEAD_HORSE, HorseVariants.UNDEAD_HORSE)
			.put(Horse.Variant.SKELETON_HORSE, HorseVariants.SKELETON_HORSE)
			.build();

	public static HorseVariant of(Horse.Variant variant) {
		return VARIANTS.get(variant);
	}

	public static Horse.Variant of(HorseVariant variant) {
		return VARIANTS.inverse().get(variant);
	}

	private static final BiMap<Horse.Color, HorseColor> COLORS = ImmutableBiMap.<Horse.Color, HorseColor>builder()
			.put(Horse.Color.WHITE, HorseColors.WHITE)
			.put(Horse.Color.CREAMY, HorseColors.CREAMY)
			.put(Horse.Color.CHESTNUT, HorseColors.CHESTNUT)
			.put(Horse.Color.BROWN, HorseColors.BROWN)
			.put(Horse.Color.BLACK, HorseColors.BLACK)
			.put(Horse.Color.GRAY, HorseColors.GRAY)
			.put(Horse.Color.DARK_BROWN, HorseColors.DARK_BROWN)
			.build();

	public static HorseColor of(Horse.Color color) {
		return COLORS.get(color);
	}

	public static Horse.Color of(HorseColor color) {
		return COLORS.inverse().get(color);
	}

	private static final BiMap<Horse.Style, HorseStyle> STYLES = ImmutableBiMap.<Horse.Style, HorseStyle>builder()
			.put(Horse.Style.NONE, HorseStyles.NONE)
			.put(Horse.Style.WHITE, HorseStyles.WHITE)
			.put(Horse.Style.WHITEFIELD, HorseStyles.WHITEFIELD)
			.put(Horse.Style.WHITE_DOTS, HorseStyles.WHITE_DOTS)
			.put(Horse.Style.BLACK_DOTS, HorseStyles.BLACK_DOTS)
			.build();

	public static HorseStyle of(Horse.Style Style) {
		return STYLES.get(Style);
	}

	public static Horse.Style of(HorseStyle Style) {
		return STYLES.inverse().get(Style);
	}
}
