package blue.lapis.pore.converter.type;

import com.google.common.base.Converter;
import org.bukkit.Achievement;
import org.spongepowered.api.stats.achievement.Achievements;

public class AchievementConverter {

    public static final Converter<Achievement, org.spongepowered.api.stats.achievement.Achievement> CONVERTER =
            TypeConverter.<Achievement, org.spongepowered.api.stats.achievement.Achievement>builder()
                    .add(Achievement.OPEN_INVENTORY, Achievements.OPEN_INVENTORY)
                    .add(Achievement.MINE_WOOD, Achievements.MINE_WOOD)
                    .add(Achievement.BUILD_WORKBENCH, Achievements.BUILD_WORKBENCH)
                    .add(Achievement.BUILD_PICKAXE, Achievements.BUILD_PICKAXE)
                    .add(Achievement.BUILD_FURNACE, Achievements.BUILD_FURNACE)
                    .add(Achievement.ACQUIRE_IRON, Achievements.ACQUIRE_IRON)
                    .add(Achievement.BUILD_HOE, Achievements.BUILD_HOE)
                    .add(Achievement.MAKE_BREAD, Achievements.MAKE_BREAD)
                    .add(Achievement.BAKE_CAKE, Achievements.BAKE_CAKE)
                    .add(Achievement.BUILD_BETTER_PICKAXE, Achievements.BUILD_BETTER_PICKAXE)
                    .add(Achievement.COOK_FISH, Achievements.COOK_FISH)
                    .add(Achievement.ON_A_RAIL, Achievements.ON_A_RAIL)
                    .add(Achievement.BUILD_SWORD, Achievements.BUILD_SWORD)
                    .add(Achievement.KILL_ENEMY, Achievements.KILL_ENEMY)
                    .add(Achievement.KILL_COW, Achievements.KILL_COW)
                    .add(Achievement.FLY_PIG, Achievements.FLY_PIG)
                    .add(Achievement.SNIPE_SKELETON, Achievements.SNIPE_SKELETON)
                    .add(Achievement.GET_DIAMONDS, Achievements.GET_DIAMONDS)
                    .add(Achievement.NETHER_PORTAL, Achievements.NETHER_PORTAL)
                    .add(Achievement.GHAST_RETURN, Achievements.GHAST_RETURN)
                    .add(Achievement.GET_BLAZE_ROD, Achievements.GET_BLAZE_ROD)
                    .add(Achievement.BREW_POTION, Achievements.BREW_POTION)
                    .add(Achievement.END_PORTAL, Achievements.END_PORTAL)
                    .add(Achievement.THE_END, Achievements.THE_END)
                    .add(Achievement.ENCHANTMENTS, Achievements.ENCHANTMENTS)
                    .add(Achievement.OVERKILL, Achievements.OVERKILL)
                    .add(Achievement.BOOKCASE, Achievements.BOOKCASE)
                    .add(Achievement.EXPLORE_ALL_BIOMES, Achievements.EXPLORE_ALL_BIOMES)
                    .add(Achievement.SPAWN_WITHER, Achievements.SPAWN_WITHER)
                    .add(Achievement.KILL_WITHER, Achievements.KILL_WITHER)
                    .add(Achievement.FULL_BEACON, Achievements.FULL_BEACON)
                    .add(Achievement.BREED_COW, Achievements.BREED_COW)
                    .add(Achievement.DIAMONDS_TO_YOU, Achievements.DIAMONDS_TO_YOU)
                    .add(Achievement.OVERPOWERED, Achievements.OVERPOWERED)
                    .build();

    public static org.spongepowered.api.stats.achievement.Achievement of(Achievement achievement) {
        return CONVERTER.convert(achievement);
    }

    public static Achievement of(org.spongepowered.api.stats.achievement.Achievement achievement) {
        return CONVERTER.reverse().convert(achievement);
    }

}
