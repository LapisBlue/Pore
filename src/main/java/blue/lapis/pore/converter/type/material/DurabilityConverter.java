/*
 * Pore
 * Copyright (c) 2014-2015, Lapis <https://github.com/LapisBlue>
 *
 * The MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package blue.lapis.pore.converter.type.material;

import static org.spongepowered.api.data.manipulator.catalog.CatalogItemData.COAL_ITEM_DATA;
import static org.spongepowered.api.data.manipulator.catalog.CatalogItemData.COOKED_FISH_ITEM_DATA;
import static org.spongepowered.api.data.manipulator.catalog.CatalogItemData.DURABILITY_DATA;
import static org.spongepowered.api.data.manipulator.catalog.CatalogItemData.DYEABLE_DATA;
import static org.spongepowered.api.data.manipulator.catalog.CatalogItemData.FISH_DATA;
import static org.spongepowered.api.data.manipulator.catalog.CatalogItemData.GOLDEN_APPLE_ITEM_DATA;

import blue.lapis.pore.Pore;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.inventory.ItemStack;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.mutable.DyeableData;
import org.spongepowered.api.data.manipulator.mutable.VariantData;
import org.spongepowered.api.data.manipulator.mutable.item.CoalData;
import org.spongepowered.api.data.manipulator.mutable.item.CookedFishData;
import org.spongepowered.api.data.manipulator.mutable.item.DurabilityData;
import org.spongepowered.api.data.manipulator.mutable.item.FishData;
import org.spongepowered.api.data.manipulator.mutable.item.GoldenAppleData;
import org.spongepowered.api.data.manipulator.mutable.item.SpawnableData;
import org.spongepowered.api.data.type.CoalType;
import org.spongepowered.api.data.type.CoalTypes;
import org.spongepowered.api.data.type.CookedFish;
import org.spongepowered.api.data.type.CookedFishes;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.type.DyeColors;
import org.spongepowered.api.data.type.Fish;
import org.spongepowered.api.data.type.Fishes;
import org.spongepowered.api.data.type.GoldenApple;
import org.spongepowered.api.data.type.GoldenApples;

import java.util.Collection;
import java.util.Optional;

public final class DurabilityConverter {

    private DurabilityConverter() {
    }

    private static final BiMap<CoalType, Integer> COAL_MAP;
    private static final BiMap<CookedFish, Integer> COOKED_FISH_MAP;
    private static final BiMap<DyeColor, Integer> DYE_MAP;
    //TODO: Entity ID map
    private static final BiMap<Fish, Integer> FISH_MAP;
    private static final BiMap<GoldenApple, Integer> GOLDEN_APPLE_MAP;
    //TODO: potions, somehow

    static {
        //noinspection ConstantConditions
        COAL_MAP = ImmutableBiMap.<CoalType, Integer>builder()
                .put(CoalTypes.COAL, 0)
                .put(CoalTypes.CHARCOAL, 1)
                .build();
        //noinspection ConstantConditions
        COOKED_FISH_MAP = ImmutableBiMap.<CookedFish, Integer>builder()
                .put(CookedFishes.COD, 0)
                .put(CookedFishes.SALMON, 1)
                .build();
        //noinspection deprecation, ConstantConditions
        DYE_MAP = ImmutableBiMap.<DyeColor, Integer>builder()
                .put(DyeColors.BLACK, (int)org.bukkit.DyeColor.BLACK.getDyeData())
                .put(DyeColors.RED, (int)org.bukkit.DyeColor.RED.getDyeData())
                .put(DyeColors.GREEN, (int)org.bukkit.DyeColor.GREEN.getDyeData())
                .put(DyeColors.BROWN, (int)org.bukkit.DyeColor.BROWN.getDyeData())
                .put(DyeColors.BLUE, (int)org.bukkit.DyeColor.BLUE.getDyeData())
                .put(DyeColors.PURPLE, (int)org.bukkit.DyeColor.PURPLE.getDyeData())
                .put(DyeColors.CYAN, (int)org.bukkit.DyeColor.CYAN.getDyeData())
                .put(DyeColors.SILVER, (int)org.bukkit.DyeColor.SILVER.getDyeData())
                .put(DyeColors.GRAY, (int)org.bukkit.DyeColor.GRAY.getDyeData())
                .put(DyeColors.PINK, (int)org.bukkit.DyeColor.PINK.getDyeData())
                .put(DyeColors.LIME, (int)org.bukkit.DyeColor.LIME.getDyeData())
                .put(DyeColors.YELLOW, (int)org.bukkit.DyeColor.YELLOW.getDyeData())
                .put(DyeColors.LIGHT_BLUE, (int)org.bukkit.DyeColor.LIGHT_BLUE.getDyeData())
                .put(DyeColors.MAGENTA, (int)org.bukkit.DyeColor.MAGENTA.getDyeData())
                .put(DyeColors.ORANGE, (int)org.bukkit.DyeColor.ORANGE.getDyeData())
                .put(DyeColors.WHITE, (int)org.bukkit.DyeColor.WHITE.getDyeData())
                .build();
        //noinspection ConstantConditions
        FISH_MAP = ImmutableBiMap.<Fish, Integer>builder()
                .put(Fishes.COD, 0)
                .put(Fishes.SALMON, 1)
                .put(Fishes.CLOWNFISH, 2)
                .put(Fishes.PUFFERFISH, 3)
                .build();
        //noinspection ConstantConditions
        GOLDEN_APPLE_MAP = ImmutableBiMap.<GoldenApple, Integer>builder()
                .put(GoldenApples.GOLDEN_APPLE, 0)
                .put(GoldenApples.ENCHANTED_GOLDEN_APPLE, 1)
                .build();
    }

    /**
     * Derives a raw damage value from a collection of {@link DataManipulator}.
     * @param data The {@link DataManipulator} list to derive a value from
     * @return The raw damage value corresponding to the data list, or
     * {@code 0} if one cannot be obtained.
     */

    public static int getDamageValue(Collection<? extends DataManipulator<?, ?>> data) {
        for (DataManipulator<?, ?> itemData : data) {
            int damage = getDamageValue(itemData);
            if (damage != 0) {
                return damage;
            }
        }
        return 0;
    }


    /**
     * Converts a given {@link DataManipulator} value to a raw damage value.
     *
     * @param data The {@link DataManipulator} value to convert
     * @return The raw damage value corresponding to {@code data}, or
     * {@code 0} if one cannot be obtained.
     */
    public static int getDamageValue(DataManipulator<?, ?> data) {
        if (data instanceof VariantData) {
            return getDamageValueFromEnum((VariantData) data);
        } else if (data instanceof DurabilityData) {
            return ((DurabilityData) data).durability().get();
        }
        return 0;
    }

    /**
     * Converts a given {@link VariantData} value to a raw damage value.
     *
     * @param data The {@link VariantData} value to convert
     * @return The raw damage value corresponding to {@code data}, or
     * {@code 0} if one cannot be obtained.
     */
    @SuppressWarnings("rawtypes")
    public static int getDamageValueFromEnum(VariantData data) {
        if (data instanceof CoalData) {
            CoalType type = ((CoalData) data).type().get();
            return COAL_MAP.containsKey(type) ? COAL_MAP.get(type) : -1;
        } else if (data instanceof CookedFishData) {
            CookedFish type = ((CookedFishData) data).type().get();
            return COOKED_FISH_MAP.containsKey(type) ? COOKED_FISH_MAP.get(type) : -1;
        } else if (data instanceof DyeableData) {
            DyeColor type = ((DyeableData) data).type().get();
            return DYE_MAP.containsKey(type) ? DYE_MAP.get(type) : -1;
        } else if (data instanceof SpawnableData) {
            throw new NotImplementedException("TODO");
        } else if (data instanceof FishData) {
            Fish type = ((FishData) data).type().get();
            return FISH_MAP.containsKey(type) ? FISH_MAP.get(type) : -1;
        } else if (data instanceof GoldenAppleData) {
            GoldenApple type = ((GoldenAppleData) data).type().get();
            return GOLDEN_APPLE_MAP.containsKey(type) ? GOLDEN_APPLE_MAP.get(type) : -1;
        } else {
            return 0;
        }
    }

    /**
     * Obtains {@link DataManipulator} from an ItemStack.
     * @param item The ItemStack to retrieve {@link DataManipulator} from
     * @return The obtained {@link DataManipulator}, or {@code null} if none can
     *         be discerned
     */
    @SuppressWarnings("rawtypes") // I tried parameterizing the return value but Java absolutely spazzed out about it
    public static DataManipulator getItemData(ItemStack item) {
        switch (item.getType()) {
            case COAL:
                return getItemData(item, COAL_ITEM_DATA, COAL_MAP);
            case COOKED_FISH:
                return getItemData(item, COOKED_FISH_ITEM_DATA, COOKED_FISH_MAP);
            case WOOL:
                break;
            case INK_SACK:
                break;
            case STAINED_CLAY:
                break;
            case STAINED_GLASS:
                break;
            case STAINED_GLASS_PANE:
                return getItemData(item, DYEABLE_DATA, DYE_MAP);
            case RAW_FISH:
                return getItemData(item, FISH_DATA, FISH_MAP);
            case GOLDEN_APPLE:
                return getItemData(item, GOLDEN_APPLE_ITEM_DATA, GOLDEN_APPLE_MAP);
            default:
                Optional<DurabilityData> data =
                        org.spongepowered.api.item.inventory.ItemStack.builder()
                                .itemType(MaterialConverter.asItem(item.getType()))
                                .quantity(1).build().get(DURABILITY_DATA);
                if (data.isPresent()) {
                    return data.get();
                } else {
                    throw new UnsupportedOperationException();
                }
        }
        return null;
    }

    @SuppressWarnings({"rawtypes", "unchecked"}) // I can't parameterize this either; it scares the compiler
    private static <T extends VariantData<U, T, ?>, U extends CatalogType> T
        getItemData(ItemStack item, Class<T> type, BiMap<U, Integer> map) {
        int damage = item.getDurability();
        if (!map.containsValue(damage)) {
            throw new UnsupportedOperationException();
        }
        // no idea why a typecast is necessary here but excluding it makes javac angry
        @SuppressWarnings("RedundantCast")
        T data = (T) org.spongepowered.api.item.inventory.ItemStack.builder()
                .itemType(MaterialConverter.asItem(item.getType()))
                .quantity(1).build().getOrCreate(type).get();
        data.type().set(map.inverse().get(damage));
        return data;
    }

}
