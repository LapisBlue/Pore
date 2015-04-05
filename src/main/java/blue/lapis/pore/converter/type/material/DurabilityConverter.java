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

import blue.lapis.pore.Pore;
import blue.lapis.pore.converter.type.material.MaterialConverter;

import com.google.common.base.Optional;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import org.apache.commons.lang.NotImplementedException;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.spongepowered.api.item.CoalType;
import org.spongepowered.api.item.CoalTypes;
import org.spongepowered.api.item.CookedFish;
import org.spongepowered.api.item.CookedFishes;
import org.spongepowered.api.item.DyeColor;
import org.spongepowered.api.item.DyeColors;
import org.spongepowered.api.item.Fish;
import org.spongepowered.api.item.Fishes;
import org.spongepowered.api.item.GoldenApple;
import org.spongepowered.api.item.GoldenApples;
import org.spongepowered.api.item.data.CoalItemData;
import org.spongepowered.api.item.data.CookedFishItemData;
import org.spongepowered.api.item.data.DurabilityData;
import org.spongepowered.api.item.data.DyeableItemData;
import org.spongepowered.api.item.data.FishItemData;
import org.spongepowered.api.item.data.GoldenAppleItemData;
import org.spongepowered.api.item.data.ItemData;
import org.spongepowered.api.item.data.PseudoEnumItemData;
import org.spongepowered.api.item.data.SpawnableData;

import java.util.Arrays;
import java.util.Collection;

public class DurabilityConverter {

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
     * Derives a raw damage value from a collection of {@link ItemData}.
     * @param data The {@link ItemData} list to derive a value from
     * @return The raw damage value corresponding to the data list, or
     * <code>0</code> if one cannot be obtained.
     */

    public static int getDamageValue(Collection<ItemData<?>> data) {
        for (ItemData<?> itemData : data) {
            int damage = getDamageValue(itemData);
            if (damage != 0) {
                return damage;
            }
        }
        return 0;
    }


    /**
     * Converts a given {@link ItemData} value to a raw damage value.
     * @param data The {@link ItemData} value to convert
     * @return The raw damage value corresponding to <code>data</code>, or
     * <code>0</code> if one cannot be obtained.
     */
    public static int getDamageValue(ItemData<?> data) {
        if (data instanceof PseudoEnumItemData<?, ?>) {
            return getDamageValueFromEnum((PseudoEnumItemData)data);
        } else if (data instanceof DurabilityData) {
            return ((DurabilityData)data).getDurability();
        }
        return 0;
    }

    /**
     * Converts a given {@link PseudoEnumItemData} value to a raw damage value.
     * @param data The {@link PseudoEnumItemData} value to convert
     * @return The raw damage value corresponding to <code>data</code>, or
     * <code>0</code> if one cannot be obtained.
     */
    public static int getDamageValueFromEnum(PseudoEnumItemData<?, ?> data) {
        if (data instanceof CoalItemData) {
            CoalType type = ((CoalItemData)data).get();
            return COAL_MAP.containsKey(type) ? COAL_MAP.get(type) : -1;
        } else if (data instanceof CookedFishItemData) {
            CookedFish type = ((CookedFishItemData)data).get();
            return COOKED_FISH_MAP.containsKey(type) ? COOKED_FISH_MAP.get(type) : -1;
        } else if (data instanceof DyeableItemData) {
            DyeColor type = ((DyeableItemData)data).get();
            return DYE_MAP.containsKey(type) ? DYE_MAP.get(type) : -1;
        } else if (data instanceof SpawnableData) {
            throw new NotImplementedException();
        } else if (data instanceof FishItemData) {
            Fish type = ((FishItemData)data).get();
            return FISH_MAP.containsKey(type) ? FISH_MAP.get(type) : -1;
        } else if (data instanceof GoldenAppleItemData) {
            GoldenApple type = ((GoldenAppleItemData)data).get();
            return GOLDEN_APPLE_MAP.containsKey(type) ? GOLDEN_APPLE_MAP.get(type) : -1;
        } else {
            return 0;
        }
    }

    /**
     * Obtains {@link ItemData} from an ItemStack.
     * @param item The ItemStack to retrieve {@link ItemData} from
     * @return The obtained {@link ItemData}, or <code>null</code> if none can
     *         be discerned
     */
    @SuppressWarnings("rawtypes") // I tried parameterizing the return value but Java absolutely spazzed out about it
    public static ItemData getItemData(ItemStack item) {
        Material type = item.getType();
        if (type == Material.COAL) {
            return getItemData(item, CoalItemData.class, COAL_MAP);
        } else if (type == Material.COOKED_FISH) {
            return getItemData(item, CookedFishItemData.class, COOKED_FISH_MAP);
        } else if (Arrays.asList(Material.WOOL, Material.INK_SACK, Material.STAINED_CLAY, Material.STAINED_GLASS,
                Material.STAINED_GLASS_PANE).contains(type)) {
            return getItemData(item, DyeableItemData.class, DYE_MAP);
        } else if (type == Material.RAW_FISH) {
            return getItemData(item, FishItemData.class, FISH_MAP);
        } else if (type == Material.GOLDEN_APPLE) {
            return getItemData(item, GoldenAppleItemData.class, GOLDEN_APPLE_MAP);
        } else {
            Optional<DurabilityData> data =
                    Pore.getGame().getRegistry().getItemBuilder().itemType(MaterialConverter.asItem(item.getType()))
                    .quantity(1).build().getOrCreateItemData(DurabilityData.class);
            if (data.isPresent()) {
                return data.get();
            } else {
                throw new UnsupportedOperationException();
            }
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"}) // I can't parameterize this either; it scares the compiler
    private static <T extends PseudoEnumItemData> T getItemData(ItemStack item, Class<T> type, BiMap<?, Integer> map) {
        int damage = item.getDurability();
        if (!map.containsValue(damage)) {
            throw new UnsupportedOperationException();
        }
        // no idea why a typecast is necessary here but excluding it makes javac angry
        T data = (T)Pore.getGame().getRegistry().getItemBuilder().itemType(MaterialConverter.asItem(item.getType()))
                .quantity(1).build().getOrCreateItemData(type).get();
        data.set(map.inverse().get(damage));
        return data;
    }

}
